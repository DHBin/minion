package cn.dhbin.minion.auth.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 认证用户
 *
 * @author donghaibin
 * @date 2020/1/4
 */
@Component
@Slf4j
public class MinionUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // todo 替换成upms加载
        log.info("加载用户: [{}]", username);
        return User.builder().username("user").password("{noop}user").authorities("*").build();
    }

}
