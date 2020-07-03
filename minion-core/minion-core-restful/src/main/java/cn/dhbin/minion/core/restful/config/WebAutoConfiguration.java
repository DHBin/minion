package cn.dhbin.minion.core.restful.config;

import cn.dhbin.minion.core.restful.config.props.LogConfigProperties;
import cn.dhbin.minion.core.restful.config.props.MinionConfigProperties;
import cn.dhbin.minion.core.restful.filter.WrapperRequestFilter;
import cn.dhbin.minion.core.restful.log.DefaultLogHandler;
import cn.dhbin.minion.core.restful.log.ILogHandler;
import cn.dhbin.minion.core.restful.spring.CustomHandlerExceptionResolver;
import cn.dhbin.minion.core.restful.spring.IEnumConverterFactory;
import cn.dhbin.minion.core.restful.spring.validator.ValidatorCollectionImpl;
import cn.dhbin.minion.core.restful.util.JacksonUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Web配置
 *
 * @author donghaibin
 * @date 2019-08-10
 */
@Configuration
@EnableConfigurationProperties({LogConfigProperties.class, MinionConfigProperties.class})
@ComponentScan("cn.dhbin.minion.core.restful.spring")
public class WebAutoConfiguration implements WebMvcConfigurer {

    /**
     * 默认日志处理
     *
     * @return ILogHandler
     */
    @Bean
    @ConditionalOnMissingBean(ILogHandler.class)
    @ConditionalOnProperty(value = "enable", prefix = "log.http.request", havingValue = "true")
    public ILogHandler defaultLogHandler() {
        return new DefaultLogHandler();
    }

    /**
     * 请求包装器
     *
     * @param logHandler 日志处理类
     * @return WrapperRequestFilter
     */
    @Bean
    @ConditionalOnBean(ILogHandler.class)
    @ConditionalOnProperty(value = "enable", prefix = "log.http.request", havingValue = "true")
    public WrapperRequestFilter wrapperRequestFilter(ILogHandler logHandler, LogConfigProperties logConfigProperties) {
        return new WrapperRequestFilter(logHandler, logConfigProperties);
    }

    /**
     * 数据校验器
     *
     * @return 数据校验器
     */
    @Override
    public Validator getValidator() {
        return new SpringValidatorAdapter(new ValidatorCollectionImpl());
    }

    /**
     * 添加枚举处理
     *
     * @param registry FormatterRegistry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new IEnumConverterFactory());
    }

    /**
     * RequestContextListener
     *
     * @return RequestContextListener
     */
    @Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    /**
     * 转换器
     *
     * @param converters converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(JacksonUtils.wrapperObjectMapper());
    }

    /**
     * 异常处理
     *
     * @param resolvers resolvers
     */
    @Override
    public void extendHandlerExceptionResolvers(@NonNull List<HandlerExceptionResolver> resolvers) {
        resolvers.add(new CustomHandlerExceptionResolver());
    }
}
