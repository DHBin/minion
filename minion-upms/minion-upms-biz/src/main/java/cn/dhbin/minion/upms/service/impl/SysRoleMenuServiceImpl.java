package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysRoleMenu;
import cn.dhbin.minion.upms.mapper.SysRoleMenuMapper;
import cn.dhbin.minion.upms.service.SysRoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysRoleMenuServiceImpl extends MinionServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {


    @Override
    public List<SysRoleMenu> getByRoleId(Long roleId) {
        return lambdaQuery().eq(SysRoleMenu::getRid, roleId).list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoleMenu(Long roleId, List<Long> menuIds) {
        this.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRid, roleId));
        List<SysRoleMenu> sysRoleMenus = menuIds.stream().map(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMid(menuId);
            sysRoleMenu.setRid(roleId);
            return sysRoleMenu;
        }).collect(Collectors.toList());
        this.saveBatch(sysRoleMenus);
    }


}
