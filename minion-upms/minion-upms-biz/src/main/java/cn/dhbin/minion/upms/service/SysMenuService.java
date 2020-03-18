package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysMenu;
import cn.dhbin.minion.upms.model.dto.MenuDto;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysMenuService extends IMinionService<SysMenu> {


    /**
     * 获取用户菜单
     *
     * @param userId   用户id
     * @param parentId parentId
     * @return 用户菜单
     */
    List<MenuDto> getMenuByUserId(Long userId, Integer parentId);

}
