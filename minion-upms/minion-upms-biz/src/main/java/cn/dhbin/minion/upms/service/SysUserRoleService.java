package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysUserRole;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysUserRoleService extends IMinionService<SysUserRole> {

    /**
     * 获取用户-角色关联信息
     *
     * @param userId 用户id
     * @return 用户-角色关联信息
     */
    List<SysUserRole> getByUserId(Long userId);
}
