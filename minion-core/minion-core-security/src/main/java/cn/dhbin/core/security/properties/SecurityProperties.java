package cn.dhbin.core.security.properties;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/26
 */
@Data
@ConfigurationProperties(prefix = "security")
@Configuration
public class SecurityProperties implements Convert {


    private static final long serialVersionUID = 2164021165813891047L;

    /**
     * 排除url，不用鉴权
     */
    private List<String> ignoreUrl = Collections.emptyList();


}
