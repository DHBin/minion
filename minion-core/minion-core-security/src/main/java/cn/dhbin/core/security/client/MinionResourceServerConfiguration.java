package cn.dhbin.core.security.client;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
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

    /**
     * 排除swagger文档路径
     */
    private static final String SWAGGER_DOC_PATH = "/v2/api-docs";

    /**
     * 监控接口
     */
    private static final String ACTUATOR_PATH = "/actuator/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        remoteTokenServices.setRestTemplate(restTemplate);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(SWAGGER_DOC_PATH).permitAll()
                .antMatchers(ACTUATOR_PATH).permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
