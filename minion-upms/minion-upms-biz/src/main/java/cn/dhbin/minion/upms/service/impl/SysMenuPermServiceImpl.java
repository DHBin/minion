package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysMenuPerm;
import cn.dhbin.minion.upms.mapper.SysMenuPermMapper;
import cn.dhbin.minion.upms.service.SysMenuPermService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Service
public class SysMenuPermServiceImpl extends MinionServiceImpl<SysMenuPermMapper, SysMenuPerm> implements SysMenuPermService {


    @Override
    public List<SysMenuPerm> getByMenuId(Long menuId) {
        return lambdaQuery().eq(SysMenuPerm::getMid, menuId).list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByMenuId(Long menuId, List<String> perms) {
        this.remove(new LambdaQueryWrapper<SysMenuPerm>().eq(SysMenuPerm::getMid, menuId));
        List<SysMenuPerm> rolePermList = perms.stream().map(permId -> {
            SysMenuPerm sysMenuPerm = new SysMenuPerm();
            sysMenuPerm.setPid(permId);
            sysMenuPerm.setMid(menuId);
            return sysMenuPerm;
        }).collect(Collectors.toList());
        this.saveBatch(rolePermList);
    }


}
