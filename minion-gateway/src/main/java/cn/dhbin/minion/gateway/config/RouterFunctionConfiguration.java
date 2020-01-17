package cn.dhbin.minion.gateway.config;

import cn.dhbin.minion.gateway.captcha.ImageCodeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author donghaibin
 * @date 2020/1/17
 */
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
public class RouterFunctionConfiguration {

    private final ImageCodeHandler imageCodeHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path(Constant.CODE_IMAGE_URL), imageCodeHandler
        );
    }
}
