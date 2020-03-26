package cn.dhbin.core.security.client;

import cn.dhbin.core.security.component.DelegatesHttpSecurityHandler;
import cn.dhbin.core.security.component.IgnoreUrlHttpSecurityHandler;
import cn.dhbin.core.security.component.MinionUserAuthenticationConverter;
import cn.dhbin.core.security.properties.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@Import(SecurityProperties.class)
public class MinionResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private final RestTemplate restTemplate;

    private final RemoteTokenServices remoteTokenServices;

    private final SecurityProperties securityProperties;

    private final DelegatesHttpSecurityHandler httpSecurityHandler = new DelegatesHttpSecurityHandler();

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        MinionUserAuthenticationConverter userTokenConverter = new MinionUserAuthenticationConverter();
        // setUserDetailsService会导致客户端执行userDetailsService#loadUserByUsername加载权限
        accessTokenConverter.setUserTokenConverter(userTokenConverter);
        remoteTokenServices.setRestTemplate(restTemplate);
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        httpSecurityHandler.add(new IgnoreUrlHttpSecurityHandler(securityProperties.getIgnoreUrl()));
        httpSecurityHandler.handle(http);
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
