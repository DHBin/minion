package cn.dhbin.core.security.component;

import cn.dhbin.minion.upms.Version;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.service.RemoteUserService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
@Component
@Slf4j
public class MinionUserDetailServiceImpl implements UserDetailsService {

    @Reference(version = Version.V_1_0_0, check = false)
    private RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (remoteUserService == null) {
            log.warn("remoteUserService == null，检查upms服务是否正常");
            throw new UsernameNotFoundException("remoteUserService == null");
        }
        UserInfo userInfo = remoteUserService.getByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(StrUtil.format("[{}] not found", username));
        }
        return new MinionUser(userInfo.getId(), username, userInfo.getPassword(), AuthorityUtils.createAuthorityList(userInfo.getAuthorities()));
    }

}
