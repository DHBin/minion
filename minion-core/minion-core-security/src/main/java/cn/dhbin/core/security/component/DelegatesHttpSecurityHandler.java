package cn.dhbin.core.security.component;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
public class DelegatesHttpSecurityHandler implements HttpSecurityHandler {

    private List<HttpSecurityHandler> delegates;

    public DelegatesHttpSecurityHandler() {
        delegates = new ArrayList<>(8);
        delegates.add(new CommonHttpSecurityHandler());
    }

    @Override
    public void handle(HttpSecurity http) throws Exception {
        for (HttpSecurityHandler delegate : delegates) {
            delegate.handle(http);
        }
    }


}
