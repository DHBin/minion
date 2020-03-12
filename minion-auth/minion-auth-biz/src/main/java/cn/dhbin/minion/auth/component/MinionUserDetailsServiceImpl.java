package cn.dhbin.minion.auth.component;

import cn.dhbin.minion.auth.api.Version;
import cn.dhbin.minion.umps.dto.UserInfo;
import cn.dhbin.minion.umps.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
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

    @Reference(version = Version.V_1_0_0)
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = sysUserService.getByUsername(username);
        if (userInfo == null) {
            return null;
        }
        if (log.isDebugEnabled()) {
            log.debug(userInfo.toString());
        }
        return User.withUsername(username).password(userInfo.getPassword()).authorities(userInfo.getAuthorities()).build();
    }

}
