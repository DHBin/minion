package cn.dhbin.minion.gateway.filter;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.gateway.config.Constant;
import cn.dhbin.minion.gateway.config.enums.ErrorCode;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 拦截授权url，判断验证码是否正确
 *
 * @author donghaibin
 * @date 2020/1/17
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ValidateCodeGateWayFilter extends AbstractGatewayFilterFactory<Object> {

    /**
     * @param config 不需要配置
     * @return GatewayFilter
     */
    @Override
    @SneakyThrows
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String requestPath = request.getPath().value();

            // 拦截授权url，验证图形验证码
            if (StrUtil.equals(requestPath, Constant.OAUTH_URL)) {
                ServerHttpResponse response = exchange.getResponse();
                String code = request.getQueryParams().getFirst("code");
                if (StrUtil.isBlank(code)) {
                    return handleCodeIsBlack(response);
                }
            }
            return chain.filter(exchange);
        };
    }

    /**
     * 处理验证码为空
     *
     * @param response response
     * @return Mono
     */
    private Mono<Void> handleCodeIsBlack(ServerHttpResponse response) {
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, ContentType.JSON.toString());
        return response.writeWith(Mono.just(response.bufferFactory().
                wrap(
                        JSON.toJSONBytes(ApiResponse.fail(ErrorCode.CODE_IS_BLACK))
                )
        ));
    }


}
