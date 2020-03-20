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

    /**
     * 判断是否拥有该角色
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 是否拥有该角色
     */
    boolean hasRole(Long userId, Long roleId);

    /**
     * 通过用户id移除关联
     *
     * @param userId 用户id
     */
    void removeByUid(Long userId);

    /**
     * 更新用户角色
     *
     * @param roleIds 角色id集合
     * @param userId  用户id
     */
    void updateUserRole(List<Long> roleIds, Long userId);
}
