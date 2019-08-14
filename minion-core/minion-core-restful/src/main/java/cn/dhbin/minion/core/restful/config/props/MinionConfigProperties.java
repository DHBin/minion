package cn.dhbin.minion.core.restful.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
@Data
@ConfigurationProperties("minion")
public class MinionConfigProperties {

    /**
     * 是否开发环境
     */
    private Boolean dev = false;

}
