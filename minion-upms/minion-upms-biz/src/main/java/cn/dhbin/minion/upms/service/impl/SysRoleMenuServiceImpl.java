package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysRoleMenu;
import cn.dhbin.minion.upms.mapper.SysRoleMenuMapper;
import cn.dhbin.minion.upms.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
