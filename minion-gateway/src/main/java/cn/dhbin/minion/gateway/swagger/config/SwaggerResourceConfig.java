package cn.dhbin.minion.gateway.swagger.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donghaibin
 * @date 2019/12/24
 */
@Slf4j
@Component
@Primary
@AllArgsConstructor
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    private static final String SWAGGER_VERSION = "2.0";

    private static final String SWAGGER_ENABLED_KEY = "swagger";

    private static final String SWAGGER_TITLE_KEY = "swagger_title";


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        gatewayProperties.getRoutes().stream()
                .filter(
                        routeDefinition -> routes.contains(routeDefinition.getId())
                        && routeDefinition.getMetadata().entrySet().stream()
                        .anyMatch(stringObjectEntry ->
                              SWAGGER_ENABLED_KEY.equals(stringObjectEntry.getKey()) && "true".equals(stringObjectEntry.getValue())
                        )
                )
                .forEach(
                        route -> route.getPredicates().stream()
                                .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                                .forEach(predicateDefinition -> resources.add(swaggerResource(determineSwaggerName(route),
                                        predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                                .replace("**", "v2/api-docs"))))
                );

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("name:{},location:{}", name, location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(SWAGGER_VERSION);
        return swaggerResource;
    }

    private String determineSwaggerName(RouteDefinition route) {
        return route.getMetadata().containsKey(SWAGGER_TITLE_KEY) ? route.getMetadata().get(SWAGGER_TITLE_KEY).toString() : route.getId();
    }

}
