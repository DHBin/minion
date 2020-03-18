package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.entity.SysUserRole;
import cn.dhbin.minion.upms.mapper.SysRoleMapper;
import cn.dhbin.minion.upms.service.SysRoleService;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends MinionServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleService sysUserRoleService;


    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        List<SysUserRole> sysUserRoles = sysUserRoleService.getByUserId(userId);
        return sysUserRoles.stream().map(sysUserRole -> lambdaQuery().eq(SysRole::getId, sysUserRole.getRid()).one())
                .collect(Collectors.toList());
    }

}
