package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.model.dto.SysPermDto;
import cn.dhbin.minion.upms.service.SysPermService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@RestController
@RequestMapping("/perm")
@RequiredArgsConstructor
public class SysPermController extends RestfulController {

    private final SysPermService sysPermService;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有权限", authorizations = @Authorization("sys_perm_all"))
    @PreAuthorize("hasAuthority('sys_perm_all')")
    public ApiResponse<List<SysPermDto>> all() {
        return success(sysPermService.all());
    }

    @GetMapping
    @ApiOperation(value = "分页获取权限", authorizations = @Authorization("sys_perm_list"))
    @PreAuthorize("hasAuthority('sys_perm_list')")
    public ApiResponse<IPage<SysPermDto>> page(PageModel<SysPerm> page) {
        return success(this.sysPermService.page(page));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除权限", authorizations = @Authorization("sys_perm_delete"))
    @PreAuthorize("hasAuthority('sys_perm_delete')")
    public ApiResponse<?> delete(@PathVariable String id) {
        this.sysPermService.removeById(id);
        return created();
    }

    @PutMapping("/reload")
    @ApiOperation(value = "重载权限", authorizations = @Authorization("sys_perm_reload"))
    @PreAuthorize("hasAuthority('sys_perm_reload')")
    public ApiResponse<?> reload() {
        this.sysPermService.reload();
        return created();
    }

}
