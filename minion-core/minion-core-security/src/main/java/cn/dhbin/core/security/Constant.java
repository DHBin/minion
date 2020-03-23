package cn.dhbin.core.security;

/**
 * 常量
 *
 * @author donghaibin
 * @date 2020/3/23
 */
public interface Constant {

    /**
     * token返回的用户id key
     */
    String USER_ID_KEY = "id";

    /**
     * token返回的用户名 key
     */
    String USER_NAME_KEU = "username";

    /**
     * 排除swagger文档路径
     */
    String SWAGGER_DOC_PATH = "/v2/api-docs";

    /**
     * 监控接口
     */
    String ACTUATOR_PATH = "/actuator/**";
}
