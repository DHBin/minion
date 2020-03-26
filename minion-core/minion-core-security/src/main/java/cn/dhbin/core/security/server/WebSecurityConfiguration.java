package cn.dhbin.core.security.server;

import cn.dhbin.core.security.component.DelegatesHttpSecurityHandler;
import cn.dhbin.core.security.component.IgnoreUrlHttpSecurityHandler;
import cn.dhbin.core.security.properties.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Import(SecurityProperties.class)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final SecurityProperties securityProperties;

    private final DelegatesHttpSecurityHandler httpSecurityHandler = new DelegatesHttpSecurityHandler();

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        httpSecurityHandler.add(new IgnoreUrlHttpSecurityHandler(securityProperties.getIgnoreUrl()));
        httpSecurityHandler.handle(http);
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
