package cn.dhbin.minion.core.dubbo.web;

import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.dhbin.minion.core.dubbo.web.service.impl.RequestMappingServiceImpl;
import cn.dhbin.minion.core.dubbo.web.util.DubboUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author donghaibin
 * @date 2020/3/14
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class DubboRequestMappingServiceExporter implements ApplicationContextAware {

    private final ApplicationConfig applicationConfig;

    private final Supplier<ProtocolConfig> protocolConfigSupplier;

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    private final List<RegistryConfig> registryConfig;

    @Value("${spring.application.name:${dubbo.application.name:application}}")
    private String currentApplicationName;

    /**
     * The ServiceConfig of RequestMappingService to be exported, can be nullable.
     */
    private ServiceConfig<RequestMappingService> serviceConfig;

    private ApplicationContext context;


    public void export() {
        if (serviceConfig == null || !serviceConfig.isExported()) {

            serviceConfig = new ServiceConfig<>();

            serviceConfig.setInterface(RequestMappingService.class);
            // Use RequestMappingService.VERSION as the Dubbo Service version
            serviceConfig.setVersion(RequestMappingService.VERSION);
            // Use Application Name as the Group name
            serviceConfig.setGroup(currentApplicationName);
            serviceConfig.setRef(buildRequestMappingService());
            serviceConfig.setApplication(applicationConfig);
            serviceConfig.setProtocol(protocolConfigSupplier.get());
            serviceConfig.setMerger(Boolean.TRUE.toString());
            ConfigurableEnvironment environment = (ConfigurableEnvironment) context
                    .getEnvironment();
            serviceConfig.setRegistries(DubboUtil.resolveRegistryConfigs(registryConfig, environment));
            serviceConfig.export();

            if (log.isInfoEnabled()) {
                log.info("The Dubbo RequestMappingService[{}] has been exported.",
                        serviceConfig.toString());
            }
        }
    }

    public RequestMappingService buildRequestMappingService() {
        return RequestMappingServiceImpl.builder()
                .mapping(requestMappingHandlerMapping)
                .owm(currentApplicationName)
                .build();
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
