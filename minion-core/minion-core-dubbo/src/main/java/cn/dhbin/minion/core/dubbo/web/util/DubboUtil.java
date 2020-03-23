package cn.dhbin.minion.core.dubbo.web.util;

import cn.hutool.core.util.StrUtil;
import lombok.experimental.UtilityClass;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.dubbo.config.spring.util.PropertySourcesUtils.getPrefixedProperties;

/**
 * @author donghaibin
 * @date 2020/3/21
 */
@UtilityClass
public class DubboUtil {

    /**
     * dubbo 注册中心地址 key
     */
    private static final String DUBBO_REGISTRY_ADDRESS_KEY = "address";

    /**
     * dubbo 注册中心协议
     */
    private static final String DUBBO_REGISTRY_PROTOCOL_KEY = "protocol";

    /**
     * dubbo 注册中心配置前缀
     */
    private static final String DUBBO_REGISTRY_PREFIX = "dubbo.registry";

    /**
     * dubbo 多注册中心配置前缀
     */
    private static final String DUBBO_REGISTRIES_PREFIX = "dubbo.registry";


    public static List<RegistryConfig> resolveRegistryConfigs(List<RegistryConfig> allRegistryConfigs, ConfigurableEnvironment environment) {
        List<RegistryConfig> registryConfigs = new ArrayList<>(allRegistryConfigs.size());

        Map<String, Object> singleProperties = getPrefixedProperties(
                environment.getPropertySources(), DUBBO_REGISTRY_PREFIX);
        singleProperties.forEach((key, o) -> {
            String value = String.valueOf(o);
            if (key.endsWith(DUBBO_REGISTRY_ADDRESS_KEY) || key.endsWith(DUBBO_REGISTRY_PROTOCOL_KEY)) {
                for (RegistryConfig config : allRegistryConfigs) {
                    if (value.startsWith(config.getProtocol()) && !registryConfigs.contains(config)) {
                        registryConfigs.add(config);
                    }
                }
            }
        });

        Map<String, Object> multiProperties = getPrefixedProperties(
                environment.getPropertySources(), DUBBO_REGISTRIES_PREFIX);
        multiProperties.forEach((key, o) -> {
            String value = String.valueOf(o);
            if (key.endsWith(StrUtil.DOT + DUBBO_REGISTRY_ADDRESS_KEY) || key.endsWith(StrUtil.DOT + DUBBO_REGISTRY_PROTOCOL_KEY)) {
                for (RegistryConfig config : allRegistryConfigs) {
                    if (value.startsWith(config.getProtocol()) && !registryConfigs.contains(config)) {
                        registryConfigs.add(config);
                    }
                }
            }
        });
        return registryConfigs;
    }
}
