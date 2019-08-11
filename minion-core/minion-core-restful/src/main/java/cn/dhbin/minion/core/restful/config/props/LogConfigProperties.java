package cn.dhbin.minion.core.restful.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
@ConfigurationProperties("log.http.request")
@Data
public class LogConfigProperties {

    /**
     * 开关
     */
    private Boolean enable = false;

    /**
     * payload
     */
    private Boolean includePayload = true;

    /**
     * 请求头
     */
    private Boolean includeHeaders = false;

    /**
     * client address and session id
     */
    private Boolean includeClientInfo = false;

    /**
     * query
     */
    private Boolean includeQueryString = true;
}
