package cn.dhbin.core.security.annotation;

import cn.dhbin.core.security.component.MinionUserDetailServiceImpl;
import cn.dhbin.core.security.server.AuthorizationServerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author donghaibin
 * @date 2020/3/23
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AuthorizationServerConfiguration.class, MinionUserDetailServiceImpl.class})
public @interface EnableMinionAuthorizationServer {


}
