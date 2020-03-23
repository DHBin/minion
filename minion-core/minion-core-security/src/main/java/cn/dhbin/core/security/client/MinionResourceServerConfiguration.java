package cn.dhbin.core.security.client;

import cn.dhbin.core.security.component.DelegatesHttpSecurityHandler;
import cn.dhbin.core.security.component.HttpSecurityHandler;
import cn.dhbin.core.security.component.MinionUserAuthenticationConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.RestTemplate;

/**
 * @author donghaibin
 * @date 2020/1/4
 */
@Configuration
@RequiredArgsConstructor
public class MinionResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private final RestTemplate restTemplate;

    private final RemoteTokenServices remoteTokenServices;

    private final HttpSecurityHandler httpSecurityHandler = new DelegatesHttpSecurityHandler();

//    private final UserDetailsService userDetailsService;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        MinionUserAuthenticationConverter userTokenConverter = new MinionUserAuthenticationConverter();
        // setUserDetailsService会导致客户端执行userDetailsService#loadUserByUsername加载权限
        // userTokenConverter.setUserDetailsService(userDetailsService);
        accessTokenConverter.setUserTokenConverter(userTokenConverter);
        remoteTokenServices.setRestTemplate(restTemplate);
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        httpSecurityHandler.handle(http);
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
