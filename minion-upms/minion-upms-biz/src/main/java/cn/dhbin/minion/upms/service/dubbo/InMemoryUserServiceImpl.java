package cn.dhbin.minion.upms.service.dubbo;

import cn.dhbin.minion.upms.Version;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.service.*;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private final SysRoleMenuService sysRoleMenuService;



    @Override
    public UserInfo getByUsername(String username) {
        SysUser sysUser = this.sysUserService.getByUsername(username);
        if (sysUser == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(sysUser.getUsername());
        userInfo.setPassword(sysUser.getPassword());

        List<SysRole> roles = this.sysRoleService.getRoleByUserId(sysUser.getId());
        userInfo.setRoles(roles.stream().map(SysRole::getRoleKey).distinct().toArray(String[]::new));

        // 角色权限
        List<SysPerm> rolePerms = roles.stream().map(sysRole -> this.sysPermService.getByRoleId(sysRole.getId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 菜单权限
        List<SysPerm> menuPerms = roles.stream()
                .map(sysRole -> this.sysRoleMenuService.getByRoleId(sysRole.getId()))
                .flatMap(Collection::stream)
                .map(sysRoleMenu -> this.sysPermService.getByMenuId(sysRoleMenu.getMid()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        String[] authorities = Stream.of(rolePerms, menuPerms)
                .flatMap(Collection::stream).map(SysPerm::getAuthorizations)
                .filter(StrUtil::isNotBlank)
                .toArray(String[]::new);
        userInfo.setAuthorities(authorities);
        userInfo.setId(sysUser.getId());
        return userInfo;
    }

}
