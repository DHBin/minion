package cn.dhbin.core.security.annotation;

import cn.dhbin.core.security.client.MinionOauth2AutoConfiguration;
import cn.dhbin.core.security.component.MinionUserDetailServiceImpl;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({MinionOauth2AutoConfiguration.class, MinionUserDetailServiceImpl.class})
public @interface EnableMinionResourceServer {

}
