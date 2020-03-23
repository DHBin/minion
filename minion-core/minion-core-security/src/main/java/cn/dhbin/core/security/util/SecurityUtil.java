package cn.dhbin.core.security.util;

import cn.dhbin.core.security.component.MinionUser;
import cn.hutool.core.convert.Convert;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * @author donghaibin
 * @date 2020/3/12
 */
public class SecurityUtil {

    @Nullable
    public static OAuth2Authentication getOAuth2Authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            return (OAuth2Authentication) authentication;
        }
        return null;
    }

    @Nullable
    public static String getUsername() {
        OAuth2Authentication oAuth2Authentication = getOAuth2Authentication();
        if (oAuth2Authentication != null) {
            return oAuth2Authentication.getName();
        }
        return null;
    }

    @Nullable
    public static MinionUser getUser() {
        OAuth2Authentication oAuth2Authentication = getOAuth2Authentication();
        if (oAuth2Authentication != null) {
            return (MinionUser) oAuth2Authentication.getPrincipal();
        }
        return null;
    }

    @Nullable
    public static Long getUserId() {
        if (getUser() != null) {
            return Convert.toLong(getUser().getId());
        }
        return null;
    }
}
