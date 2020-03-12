package cn.dhbin.minion.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    /**
     * 排除swagger文档路径
     */
    private static final String SWAGGER_DOC_PATH = "/v2/api-docs";

    /**
     * 监控接口
     */
    private static final String ACTUATOR_PATH = "/actuator/**";

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(SWAGGER_DOC_PATH).permitAll()
                .antMatchers(ACTUATOR_PATH).permitAll()
                .anyRequest().authenticated();
    }
}