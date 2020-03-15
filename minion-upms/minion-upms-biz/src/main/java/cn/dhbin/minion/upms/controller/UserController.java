package cn.dhbin.minion.upms.controller;

import cn.dhbin.core.security.util.SecurityUtil;
import cn.dhbin.minion.auth.api.TokenService;
import cn.dhbin.minion.auth.api.Version;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.service.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author donghaibin
 * @date 2020/1/4
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends RestfulController {

    private final RemoteUserService remoteUserService;

    @Reference(version = Version.V_1_0_0, check = false)
    private TokenService tokenService;

    @GetMapping("getUserInfo")
    public ApiResponse<UserInfo> getUserInfo() {
        String username = SecurityUtil.getUsername();
        return success(remoteUserService.getByUsername(username));
    }

    @GetMapping("/logout")
    public ApiResponse<?> logout() {
        OAuth2Authentication oAuth2Authentication = Objects.requireNonNull(SecurityUtil.getOAuth2Authentication());
        String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
        String name = oAuth2Authentication.getUserAuthentication().getName();
        return success(tokenService.removeToken(clientId, name));
    }

}
