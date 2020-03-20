package cn.dhbin.minion.upms.controller;

import cn.dhbin.core.security.util.SecurityUtil;
import cn.dhbin.minion.auth.api.TokenService;
import cn.dhbin.minion.auth.api.Version;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.model.dto.UserDto;
import cn.dhbin.minion.upms.model.param.SysUserParam;
import cn.dhbin.minion.upms.service.RemoteUserService;
import cn.dhbin.minion.upms.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author donghaibin
 * @date 2020/1/4
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class SysUserController extends RestfulController {

    private final RemoteUserService remoteUserService;

    private final SysUserService sysUserService;

    @Reference(version = Version.V_1_0_0, check = false)
    private TokenService tokenService;

    @GetMapping("getUserInfo")
    @ApiOperation(value = "获取当前用户信息")
    public ApiResponse<UserInfo> getUserInfo() {
        String username = SecurityUtil.getUsername();
        return success(remoteUserService.getByUsername(username));
    }

    @GetMapping("/logout")
    @ApiOperation(value = "登出")
    public ApiResponse<?> logout() {
        OAuth2Authentication oAuth2Authentication = Objects.requireNonNull(SecurityUtil.getOAuth2Authentication());
        String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
        String name = oAuth2Authentication.getUserAuthentication().getName();
        return success(tokenService.removeToken(clientId, name));
    }

    @GetMapping
    @ApiOperation(value = "获取用户列表", authorizations = @Authorization("sys_user_list"))
    @PreAuthorize("hasAuthority('sys_user_list')")
    public ApiResponse<IPage<UserDto>> list(PageModel<SysUser> page) {
        return success(this.sysUserService.list(page));
    }

    @PutMapping
    @ApiOperation(value = "更新用户", authorizations = @Authorization("sys_user_update"))
    @PreAuthorize("hasAuthority('sys_user_update')")
    public ApiResponse<?> update(@Validated(SysUserParam.UPDATE.class) @RequestBody SysUserParam sysUserParam) {
        SysUser sysUser = sysUserParam.convert(SysUser.class);
        this.sysUserService.updateUser(sysUser, sysUserParam.getRoles());
        return created();
    }

    @PostMapping
    @ApiOperation(value = "创建用户", authorizations = @Authorization("sys_user_create"))
    @PreAuthorize("hasAuthority('sys_user_create')")
    public ApiResponse<?> create(@Validated(SysUserParam.CREATE.class) @RequestBody SysUserParam sysUserParam) {
        SysUser sysUser = sysUserParam.convert(SysUser.class);
        this.sysUserService.createUser(sysUser, sysUserParam.getRoles());
        return created();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除用户", authorizations = @Authorization("sys_user_delete"))
    @PreAuthorize("hasAuthority('sys_user_delete')")
    public ApiResponse<?> delete(@PathVariable Long id) {
        return created(this.sysUserService.removeById(id));
    }

}
