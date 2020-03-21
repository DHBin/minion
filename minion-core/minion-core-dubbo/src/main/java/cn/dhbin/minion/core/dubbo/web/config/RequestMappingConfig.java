package cn.dhbin.minion.core.dubbo.web.config;

import cn.dhbin.minion.core.dubbo.web.DubboRequestMappingServiceExporter;
import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.dhbin.minion.core.dubbo.web.util.DubboUtil;
import com.alibaba.cloud.dubbo.registry.event.ServiceInstancePreRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

import static com.alibaba.cloud.dubbo.autoconfigure.DubboServiceRegistrationAutoConfiguration.CONSUL_AUTO_SERVICE_AUTO_CONFIGURATION_CLASS_NAME;
import static com.alibaba.cloud.dubbo.autoconfigure.DubboServiceRegistrationAutoConfiguration.EUREKA_CLIENT_AUTO_CONFIGURATION_CLASS_NAME;

/**
 * @author donghaibin
 * @date 2020/3/14
 */
@RequiredArgsConstructor
@Slf4j
@AutoConfigureAfter(name = {EUREKA_CLIENT_AUTO_CONFIGURATION_CLASS_NAME,
        CONSUL_AUTO_SERVICE_AUTO_CONFIGURATION_CLASS_NAME,
        "org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration"})
@AutoConfigureBefore(RequestMappingHandlerMapping.class)
public class RequestMappingConfig implements ApplicationContextAware {

    /**
     * 所有分组
     */
    private static final String ALL_GROUP = "*";
    private final DubboRequestMappingServiceExporter dubboRequestMappingServiceExporter;
    private final ApplicationConfig applicationConfig;
    private final List<RegistryConfig> registryConfig;

    private ApplicationContext context;

    @EventListener(ServiceInstancePreRegisteredEvent.class)
    public void export() {
        dubboRequestMappingServiceExporter.export();
    }

    /**
     * Dubbo requestMappingService对象，并不是调用本地服务
     *
     * @return requestMappingService
     */
    @Bean
    public RequestMappingService requestMappingService() {
        ReferenceConfig<RequestMappingService> reference = new ReferenceConfig<>();
        ConfigurableEnvironment environment = (ConfigurableEnvironment) context
                .getEnvironment();
        reference.setRegistries(DubboUtil.resolveRegistryConfigs(registryConfig, environment));
        reference.setApplication(applicationConfig);
        reference.setInterface(RequestMappingService.class);
        reference.setGroup(ALL_GROUP);
        reference.setMerger(Boolean.TRUE.toString());
        reference.setCheck(false);
        reference.setVersion(RequestMappingService.VERSION);
        return reference.get();
    }


    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
