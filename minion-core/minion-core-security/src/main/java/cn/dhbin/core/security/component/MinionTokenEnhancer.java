package cn.dhbin.core.security.component;

import cn.dhbin.core.security.Constant;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
public class MinionTokenEnhancer implements TokenEnhancer {

    /**
     * 添加userId、username
     *
     * @param accessToken    accessToken
     * @param authentication authentication
     * @return token
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        MinionUser minionUser = (MinionUser) authentication.getUserAuthentication().getPrincipal();
        Map<String, Object> additionalInformation = new HashMap<>(8);
        // String.valueOf 转Str 防止Long在js中丢精度
        additionalInformation.put(Constant.USER_ID_KEY, String.valueOf(minionUser.getId()));
        additionalInformation.put(Constant.USER_NAME_KEU, minionUser.getUsername());
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
        }
        return accessToken;
    }

}
