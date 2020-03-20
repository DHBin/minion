package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.mapper.SysPermMapper;
import cn.dhbin.minion.upms.model.dto.SysPermDto;
import cn.dhbin.minion.upms.service.SysMenuPermService;
import cn.dhbin.minion.upms.service.SysPermService;
import cn.dhbin.minion.upms.service.SysRolePermService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysPermServiceImpl extends MinionServiceImpl<SysPermMapper, SysPerm> implements SysPermService {

    private final SysRolePermService sysRolePermService;

    private final SysMenuPermService sysMenuPermService;


    @Override
    public List<SysPerm> getByRoleId(Long roleId) {
        return sysRolePermService.getByRoleId(roleId)
                .stream()
                .map(sysUserPerm -> getById(sysUserPerm.getPid()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SysPerm> getByMenuId(Long menuId) {
        return sysMenuPermService.getByMenuId(menuId)
                .stream()
                .map(sysMenuPerm -> getById(sysMenuPerm.getPid()))
                .collect(Collectors.toList());

    }

    @Override
    public List<SysPermDto> all() {
        return this.lambdaQuery().list().stream().map(sysPerm -> sysPerm.convert(SysPermDto.class)).collect(Collectors.toList());
    }

    @Override
    public IPage<SysPermDto> page(PageModel<SysPerm> pageModel) {
        return this.page(pageModel.convert()).convert(sysPerm -> sysPerm.convert(SysPermDto.class));
    }


}
