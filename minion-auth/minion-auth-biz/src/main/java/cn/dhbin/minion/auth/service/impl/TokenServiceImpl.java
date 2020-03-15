package cn.dhbin.minion.auth.service.impl;

import cn.dhbin.minion.auth.api.TokenService;
import cn.dhbin.minion.upms.Version;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Collection;

/**
 * @author donghaibin
 * @date 2020/3/12
 */
@Service(version = Version.V_1_0_0)
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenStore tokenStore;

    @Override
    public Boolean removeToken(String clientId, String username) {
        try {
            Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByClientIdAndUserName(clientId, username);
            for (OAuth2AccessToken accessToken : accessTokens) {
                tokenStore.removeAccessToken(accessToken);
                tokenStore.removeRefreshToken(accessToken.getRefreshToken());
            }
        } catch (Exception e) {
            log.error("removeToken error", e);
            return false;
        }
        return true;
    }

}
