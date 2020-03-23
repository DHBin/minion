package cn.dhbin.core.security.component;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
public interface HttpSecurityHandler {

    /**
     * @param http httpSecurity
     * @throws Exception ex
     */
    void handle(HttpSecurity http) throws Exception;


}
