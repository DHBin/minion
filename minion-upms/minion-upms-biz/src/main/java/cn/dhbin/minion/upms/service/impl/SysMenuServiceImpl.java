package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysMenu;
import cn.dhbin.minion.upms.mapper.SysMenuMapper;
import cn.dhbin.minion.upms.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysMenuServiceImpl extends MinionServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}
