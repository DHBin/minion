package cn.dhbin.minion.auth.api;

/**
 * Token相关接口
 *
 * @author donghaibin
 * @date 2020/3/12
 */
public interface TokenService {

    /**
     * 通过用户名移除token
     *
     * @param clientId 客户端id
     * @param username 用户名
     * @return 是否移除成功
     */
    Boolean removeToken(String clientId, String username);

}
