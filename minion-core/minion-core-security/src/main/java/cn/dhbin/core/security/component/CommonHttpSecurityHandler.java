package cn.dhbin.core.security.component;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import static cn.dhbin.core.security.Constant.ACTUATOR_PATH;
import static cn.dhbin.core.security.Constant.SWAGGER_DOC_PATH;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
public class CommonHttpSecurityHandler implements HttpSecurityHandler {

    @Override
    public void handle(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(SWAGGER_DOC_PATH).permitAll()
                .antMatchers(ACTUATOR_PATH).permitAll();
    }

}
