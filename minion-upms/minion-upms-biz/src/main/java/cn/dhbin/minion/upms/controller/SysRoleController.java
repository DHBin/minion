package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.model.dto.SysRoleDto;
import cn.dhbin.minion.upms.model.param.SysRoleParam;
import cn.dhbin.minion.upms.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class SysRoleController extends RestfulController {

    private final SysRoleService sysRoleService;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有角色", authorizations = @Authorization("sys_role_all"))
    @PreAuthorize("hasAuthority('sys_role_all')")
    public ApiResponse<List<SysRoleDto>> all() {
        List<SysRoleDto> sysRoleDtos = this.sysRoleService.list().stream()
                .map(sysRole -> sysRole.convert(SysRoleDto.class))
                .collect(Collectors.toList());
        return success(sysRoleDtos);
    }

    @GetMapping
    @ApiOperation(value = "分页获取角色", authorizations = @Authorization("sys_role_list"))
    @PreAuthorize("hasAuthority('sys_role_list')")
    public ApiResponse<IPage<SysRoleDto>> list(PageModel<SysRole> page) {
        return success(sysRoleService.list(page));
    }

    @PostMapping
    @ApiOperation(value = "创建角色", authorizations = @Authorization("sys_role_create"))
    @PreAuthorize("hasAuthority('sys_role_create')")
    public ApiResponse<?> create(@Validated(SysRoleParam.Create.class) @RequestBody SysRoleParam sysRoleParam) {
        SysRole sysRole = sysRoleParam.convert(SysRole.class);
        this.sysRoleService.create(sysRole, sysRoleParam.getPerms());
        return created();
    }

    @PutMapping
    @ApiOperation(value = "更新角色", authorizations = @Authorization("sys_role_update"))
    @PreAuthorize("hasAuthority('sys_role_update')")
    public ApiResponse<?> update(@Validated(SysRoleParam.Update.class) @RequestBody SysRoleParam sysRoleParam) {
        SysRole sysRole = sysRoleParam.convert(SysRole.class);
        this.sysRoleService.update(sysRole, sysRoleParam.getPerms());
        return created();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除角色", authorizations = @Authorization("sys_role_delete"))
    @PreAuthorize("hasAuthority('sys_role_delete')")
    public ApiResponse<?> delete(@PathVariable Long id) {
        return created(this.sysRoleService.removeById(id));
    }

}
