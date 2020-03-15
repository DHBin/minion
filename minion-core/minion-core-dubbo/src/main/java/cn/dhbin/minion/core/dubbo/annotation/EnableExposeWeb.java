package cn.dhbin.minion.core.dubbo.annotation;

import cn.dhbin.minion.core.dubbo.web.DubboRequestMappingServiceExporter;
import cn.dhbin.minion.core.dubbo.web.config.RequestMappingConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author donghaibin
 * @date 2020/3/14
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RequestMappingConfig.class, DubboRequestMappingServiceExporter.class})
public @interface EnableExposeWeb {


}
