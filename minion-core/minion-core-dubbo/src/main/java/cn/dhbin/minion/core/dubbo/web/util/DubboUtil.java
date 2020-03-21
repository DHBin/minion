package cn.dhbin.minion.core.dubbo.web.util;

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

    public static List<RegistryConfig> resolveRegistryConfigs(List<RegistryConfig> allRegistryConfigs, ConfigurableEnvironment environment) {
        List<RegistryConfig> registryConfigs = new ArrayList<>(allRegistryConfigs.size());

        Map<String, Object> singleProperties = getPrefixedProperties(
                environment.getPropertySources(), "dubbo.registry");
        singleProperties.forEach((key, o) -> {
            String value = String.valueOf(o);
            if (key.endsWith("address") || key.endsWith("protocol")) {
                for (RegistryConfig config : allRegistryConfigs) {
                    if (value.startsWith(config.getProtocol()) && !registryConfigs.contains(config)) {
                        registryConfigs.add(config);
                    }
                }
            }
        });

        Map<String, Object> multiProperties = getPrefixedProperties(
                environment.getPropertySources(), "dubbo.registries");
        multiProperties.forEach((key, o) -> {
            String value = String.valueOf(o);
            if (key.endsWith(".address") || key.endsWith(".protocol")) {
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
