package cn.dhbin.minion.upms.service.dubbo;

import cn.dhbin.minion.upms.Version;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.service.RemoteUserService;
import cn.dhbin.minion.upms.service.SysPermService;
import cn.dhbin.minion.upms.service.SysRoleService;
import cn.dhbin.minion.upms.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
@Service(version = Version.V_1_0_0)
@RequiredArgsConstructor
public class InMemoryUserServiceImpl implements RemoteUserService {

    private final SysUserService sysUserService;

    private final SysRoleService sysRoleService;

    private final SysPermService sysPermService;

    @Override
    public UserInfo getByUsername(String username) {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(sysUser.getUsername());
        userInfo.setPassword(sysUser.getPassword());

        String[] roles = sysRoleService.getRoleByUserId(sysUser.getId())
                .stream().map(SysRole::getRoleKey).toArray(String[]::new);
        userInfo.setRoles(roles);

        String[] authorities = sysPermService.getByUserId(sysUser.getId()).stream()
                .map(SysPerm::getAuthorizations)
                .toArray(String[]::new);
        userInfo.setAuthorities(authorities);
        return userInfo;
    }

}
