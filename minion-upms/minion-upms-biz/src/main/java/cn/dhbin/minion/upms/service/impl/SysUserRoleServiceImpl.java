package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysUserRole;
import cn.dhbin.minion.upms.mapper.SysUserRoleMapper;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysUserRoleServiceImpl extends MinionServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {


    @Override
    public List<SysUserRole> getByUserId(Long userId) {
        return lambdaQuery().eq(SysUserRole::getUid, userId).list();
    }

    @Override
    public boolean hasRole(Long userId, Long roleId) {
        return this.lambdaQuery().eq(SysUserRole::getRid, roleId)
                .eq(SysUserRole::getUid, userId)
                .count() != 0;
    }

    @Override
    public void removeByUid(Long userId) {
        this.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUid, userId));
    }

    @Override
    public void updateUserRole(List<Long> roleIds, final Long userId) {
        List<SysUserRole> userRoles = roleIds.stream()
                .map(rid -> {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setRid(rid);
                    sysUserRole.setUid(userId);
                    return sysUserRole;
                }).collect(Collectors.toList());
        this.removeByUid(userId);
        this.saveBatch(userRoles);
    }
}
