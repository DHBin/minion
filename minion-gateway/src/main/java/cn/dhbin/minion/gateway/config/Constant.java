package cn.dhbin.minion.gateway.config;

import java.util.Collections;
import java.util.List;

/**
 * 常量
 *
 * @author donghaibin
 * @date 2020/1/17
 */
public interface Constant {

    /**
     * 授权url
     */
    String OAUTH_URL = "/oauth/token";

    /**
     * 授权方式
     */
    String GRANT_TYPE = "grant_type";

    /**
     * 需要验证图形验证码的grant_type
     */
    List<String> VALIDATE_CODE_GRANT_TYPE = Collections.singletonList("password");

    /**
     * 获取图形验证码url
     */
    String CODE_IMAGE_URL = "/code";

    /**
     * 验证码缓存key前缀
     */
    String CODE_KEY_PREFIX = "code_key::";

    /**
     * 验证码随机数参数
     */
    String CAPTCHA_PARAM_NAME = "rand";

    /**
     * 验证码
     */
    String CAPTCHA_PARAM_VALUE = "code";
}
