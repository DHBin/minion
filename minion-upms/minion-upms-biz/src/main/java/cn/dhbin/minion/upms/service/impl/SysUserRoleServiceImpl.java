package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysUserRole;
import cn.dhbin.minion.upms.mapper.SysUserRoleMapper;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
