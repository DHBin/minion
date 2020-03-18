package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysRoleMenu;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysRoleMenuService extends IMinionService<SysRoleMenu> {

    /**
     * 获取角色-菜单关联信息
     *
     * @param roleId 角色id
     * @return 角色-菜单关联信息
     */
    List<SysRoleMenu> getByRoleId(Long roleId);


}
