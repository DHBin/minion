package cn.dhbin.minion.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthConfiguration extends AuthorizationServerConfigurerAdapter {


}
