package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysMenu;
import cn.dhbin.minion.upms.entity.SysUserRole;
import cn.dhbin.minion.upms.mapper.SysMenuMapper;
import cn.dhbin.minion.upms.model.dto.MenuDto;
import cn.dhbin.minion.upms.model.enums.MenuType;
import cn.dhbin.minion.upms.service.SysMenuService;
import cn.dhbin.minion.upms.service.SysRoleMenuService;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends MinionServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public List<MenuDto> getMenuByUserId(Long userId, Integer parentId) {
        List<SysUserRole> userRoleList = sysUserRoleService.getByUserId(userId);

        List<SysMenu> sysMenus = userRoleList.stream()
                .map(sysUserRole -> sysRoleMenuService.getByRoleId(sysUserRole.getRid()))
                .flatMap(Collection::stream)
                .map(sysRoleMenu -> lambdaQuery()
                        .eq(SysMenu::getId, sysRoleMenu.getMid())
                        .eq(SysMenu::getType, MenuType.MENU)
                        .one()
                ).collect(Collectors.toList());

        List<MenuDto> menuDtos = new ArrayList<>(sysMenus.size());
        for (SysMenu sysMenu : sysMenus) {
            if (!sysMenu.getParentNum().equals(parentId)) {
                continue;
            }
            MenuDto menuDto = sysMenu.convert(MenuDto.class);
            List<SysMenu> subMenuDto = sysMenus.stream()
                    .filter(m -> m.getParentNum().equals(menuDto.getNum()))
                    .collect(Collectors.toList());
            sysMenus.removeAll(subMenuDto);
            menuDto.setChildren(subMenuDto.stream().map(m -> m.convert(MenuDto.class)).collect(Collectors.toList()));
            menuDtos.add(menuDto);
        }
        return menuDtos;
    }

}
