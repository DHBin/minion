package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysMenu;
import cn.dhbin.minion.upms.model.dto.SysMenuDto;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysMenuService extends IMinionService<SysMenu> {


    /**
     * 获取用户顶部菜单
     *
     * @param userId 用户id
     * @return 顶部菜单
     */
    List<SysMenuDto> getTopMenuByUserId(Long userId);

    /**
     * 获取用户左侧菜单
     *
     * @param userId   用户id
     * @param parentId parentId
     * @return 用户菜单
     */
    List<SysMenuDto> getMenuTreeByUserId(Long userId, Integer parentId);

    /**
     * 获取角色菜单
     *
     * @param roleId 角色id
     * @return 菜单
     */
    List<SysMenuDto> getByRoleId(Long roleId);


    /**
     * 所有菜单
     *
     * @return 所有菜单
     */
    List<SysMenuDto> getAllMenuTree();

    /**
     * 更新菜单
     *
     * @param sysMenu 菜单
     * @param perms   权限
     */
    void updateMenu(SysMenu sysMenu, List<String> perms);

    /**
     * 创建菜单
     *
     * @param sysMenu 菜单
     * @param perms   权限
     */
    void createMenu(SysMenu sysMenu, List<String> perms);
}
