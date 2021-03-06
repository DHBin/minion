package cn.dhbin.minion.core.dubbo.web;

import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.dhbin.minion.core.dubbo.web.service.impl.RequestMappingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Value;
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
public class DubboRequestMappingServiceExporter {

    private final Supplier<ProtocolConfig> protocolConfigSupplier;

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    private final List<RegistryConfig> registryConfig;

    @Value("${spring.application.name:${dubbo.application.name:application}}")
    private String currentApplicationName;

    /**
     * The ServiceConfig of RequestMappingService to be exported, can be nullable.
     */
    private ServiceConfig<RequestMappingService> serviceConfig;


    public void export() {
        if (serviceConfig == null || !serviceConfig.isExported()) {

            serviceConfig = new ServiceConfig<>();

            serviceConfig.setInterface(RequestMappingService.class);
            // Use RequestMappingService.VERSION as the Dubbo Service version
            serviceConfig.setVersion(RequestMappingService.VERSION);
            // Use Application Name as the Group name
            serviceConfig.setGroup(currentApplicationName);
            serviceConfig.setRef(buildRequestMappingService());
            serviceConfig.setProtocol(protocolConfigSupplier.get());
            serviceConfig.setMerger(Boolean.TRUE.toString());
            serviceConfig.setRegistries(registryConfig);
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

}
