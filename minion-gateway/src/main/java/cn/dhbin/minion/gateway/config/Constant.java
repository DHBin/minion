package cn.dhbin.minion.gateway.config;

/**
 * 常量
 *
 * @author donghaibin
 * @date 2020/1/17
 */
public interface Constant {

    /**
     * 授权url，路由到minion-auth模块，如果修改该模块路由前缀，这里也要
     * 同步修改
     */
    String OAUTH_URL = "/auth/oauth/token";

    /**
     * 获取图形验证码url
     */
    String CODE_IMAGE_URL = "/code";
}
