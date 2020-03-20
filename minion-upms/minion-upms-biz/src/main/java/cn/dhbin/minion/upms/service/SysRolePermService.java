package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysRolePerm;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysRolePermService extends IMinionService<SysRolePerm> {


    /**
     * 获取角色-权限关联信息
     *
     * @param roleId 用户id
     * @return 角色-权限关联信息
     */
    List<SysRolePerm> getByRoleId(Long roleId);

    /**
     * 更新角色权限
     *
     * @param roleId 角色id
     * @param perms  权限id
     */
    void updateByRoleId(Long roleId, List<String> perms);
}
