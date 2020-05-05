package cn.dhbin.minion.auth.api.model;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author donghaibin
 * @date 2020/4/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinionClientDetails implements Convert {


    private static final long serialVersionUID = -588717230165842184L;

    /**
     * 客户端 id (相当于用户)
     */
    private String clientId;

    /**
     * 客户端秘钥 （密码）
     */
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
    private Set<String> registeredRedirectUris;

    /**
     * 用户是否自动Approval操作
     */
    private Set<String> autoApproveScopes;

    /**
     * 设定客户端的access_token的有效时间值(单位:秒)
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 设定客户端的refresh_token的有效时间值(单位:秒)
     */
    private Integer refreshTokenValiditySeconds;


}
