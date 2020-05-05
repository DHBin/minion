package cn.dhbin.minion.upms.model.dto;

import cn.dhbin.minion.auth.api.model.MinionClientDetails;
import cn.dhbin.minion.core.tool.converter.Convert;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.Set;

/**
 * @author donghaibin
 * @date 2020/4/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinionClientDetailsDto implements Convert {

    private static final long serialVersionUID = -3907128476382521022L;

    /**
     * 客户端 id (相当于用户)
     */
    @NotBlank
    private String clientId;

    /**
     * 客户端秘钥 （密码）
     */
    @NotBlank
    private String clientSecret;

    /**
     * 授权作用域
     */
    private Set<String> scope;

    /**
     * 可访问的资源（客户）端 id
     */
    private Set<String> resourceIds;

    /**
     * 授权方式
     */
    private Set<String> authorizedGrantTypes;

    /**
     * 重定向的uris
     */
    private String registeredRedirectUris;

    /**
     * 用户是否自动Approval操作
     */
    private String autoApproveScopes;

    /**
     * 设定客户端的access_token的有效时间值(单位:秒)
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 设定客户端的refresh_token的有效时间值(单位:秒)
     */
    private Integer refreshTokenValiditySeconds;

    public static MinionClientDetails dto2MinionClientDetails(@NonNull MinionClientDetailsDto clientDetailsDto) {
        MinionClientDetails clientDetails = new MinionClientDetails();
        clientDetails.setClientId(clientDetailsDto.getClientId());
        clientDetails.setClientSecret(clientDetailsDto.getClientSecret());
        clientDetails.setScope(clientDetailsDto.getScope());
        clientDetails.setResourceIds(clientDetailsDto.getResourceIds());
        clientDetails.setAuthorizedGrantTypes(clientDetailsDto.getAuthorizedGrantTypes());
        clientDetails.setRegisteredRedirectUris(str2Set(clientDetailsDto.getRegisteredRedirectUris()));
        clientDetails.setAutoApproveScopes(str2Set(clientDetailsDto.getAutoApproveScopes()));
        clientDetails.setAccessTokenValiditySeconds(clientDetailsDto.getAccessTokenValiditySeconds());
        clientDetails.setRefreshTokenValiditySeconds(clientDetailsDto.getRefreshTokenValiditySeconds());
        return clientDetails;
    }

    public static MinionClientDetailsDto minionClientDetails2Dto(@NonNull MinionClientDetails minionClientDetails) {
        MinionClientDetailsDto dto = new MinionClientDetailsDto();
        dto.setClientId(minionClientDetails.getClientId());
        dto.setClientSecret(minionClientDetails.getClientSecret());
        dto.setScope(minionClientDetails.getScope());

        dto.setResourceIds(minionClientDetails.getResourceIds());
        dto.setAuthorizedGrantTypes(minionClientDetails.getAuthorizedGrantTypes());
        dto.setRegisteredRedirectUris(set2Str(minionClientDetails.getRegisteredRedirectUris()));
        dto.setAutoApproveScopes(set2Str(minionClientDetails.getAutoApproveScopes()));

        dto.setAccessTokenValiditySeconds(minionClientDetails.getAccessTokenValiditySeconds());
        dto.setRefreshTokenValiditySeconds(minionClientDetails.getRefreshTokenValiditySeconds());
        return dto;
    }

    private static Set<String> str2Set(String str) {
        if (StrUtil.isBlank(str)) {
            return Collections.emptySet();
        }
        String[] strings = StrUtil.split(str, ",");
        return CollUtil.newHashSet(strings);
    }

    private static String set2Str(@NonNull Set<String> strings) {
        if (CollUtil.isEmpty(strings)) {
            return StrUtil.EMPTY;
        }
        return String.join(",", strings);
    }
}
