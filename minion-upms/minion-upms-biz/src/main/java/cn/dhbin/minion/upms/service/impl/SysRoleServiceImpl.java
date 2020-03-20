package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.entity.SysRoleMenu;
import cn.dhbin.minion.upms.entity.SysRolePerm;
import cn.dhbin.minion.upms.entity.SysUserRole;
import cn.dhbin.minion.upms.mapper.SysRoleMapper;
import cn.dhbin.minion.upms.model.dto.SysRoleDto;
import cn.dhbin.minion.upms.service.SysRoleMenuService;
import cn.dhbin.minion.upms.service.SysRolePermService;
import cn.dhbin.minion.upms.service.SysRoleService;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends MinionServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleService sysUserRoleService;

    private final SysRolePermService sysRolePermService;

    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        List<SysUserRole> sysUserRoles = sysUserRoleService.getByUserId(userId);
        return sysUserRoles.stream().map(sysUserRole -> lambdaQuery().eq(SysRole::getId, sysUserRole.getRid()).one())
                .collect(Collectors.toList());
    }

    @Override
    public IPage<SysRoleDto> list(PageModel<SysRole> pageModel) {
        Page<SysRole> page = pageModel.convert();
        return this.lambdaQuery().page(page)
                .convert(sysRole -> {
                    SysRoleDto dto = sysRole.convert(SysRoleDto.class);
                    List<String> perms = sysRolePermService.getByRoleId(dto.getId()).stream()
                            .map(SysRolePerm::getPid).collect(Collectors.toList());
                    dto.setPerms(perms);
                    return dto;
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(SysRole sysRole, List<String> perms) {
        this.save(sysRole);
        this.sysRolePermService.updateByRoleId(sysRole.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole sysRole, List<String> perms) {
        this.updateByIdAndReturn(sysRole);
        this.sysRolePermService.updateByRoleId(sysRole.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        this.sysRolePermService.remove(new LambdaQueryWrapper<SysRolePerm>().eq(SysRolePerm::getRid, id));
        this.sysRoleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRid, id));
        this.sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRid, id));
        return super.removeById(id);
    }

}
