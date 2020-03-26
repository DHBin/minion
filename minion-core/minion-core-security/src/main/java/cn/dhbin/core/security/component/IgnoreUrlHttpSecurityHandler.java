package cn.dhbin.core.security.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/26
 */
@RequiredArgsConstructor
public class IgnoreUrlHttpSecurityHandler implements HttpSecurityHandler {

    private final List<String> ignoreUrls;

    @Override
    public void handle(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRegistry = http.authorizeRequests();
        for (String ignoreUrl : ignoreUrls) {
            urlRegistry.antMatchers(ignoreUrl).permitAll();
        }
    }

}
