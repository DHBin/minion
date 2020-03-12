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
import org.springframework.data.redis.core.StringRedisTemplate;
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

    private final StringRedisTemplate redisTemplate;

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

            String grantType = request.getQueryParams().getFirst(Constant.GRANT_TYPE);

            // 拦截授权url，验证图形验证码
            if (StrUtil.equals(requestPath, Constant.OAUTH_URL) && Constant.VALIDATE_CODE_GRANT_TYPE.contains(grantType)) {
                ServerHttpResponse response = exchange.getResponse();
                String code = request.getQueryParams().getFirst(Constant.CAPTCHA_PARAM_VALUE);
                String rand = request.getQueryParams().getFirst(Constant.CAPTCHA_PARAM_NAME);

                if (StrUtil.isBlank(code) || StrUtil.isBlank(rand)) {
                    return handleCodeIsBlack(response);
                } else {
                    if (!validateCode(response, code, rand)) {
                        return response.writeWith(Mono.just(
                                response.bufferFactory().wrap(
                                        JSON.toJSONBytes(
                                                ApiResponse.fail(ErrorCode.CODE_ILLEGAL))
                                )
                        ));
                    }
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

    /**
     * 验证图形码，不管验证是否通过都从redis中删除
     *
     * @param response response
     * @param code     图形码
     * @param rand     随机数
     * @return true 验证通过 false 不通过
     */
    private boolean validateCode(ServerHttpResponse response, String code, String rand) {
        String key = Constant.CODE_KEY_PREFIX + rand;
        String codeFormRedis = redisTemplate.opsForValue().get(key);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, ContentType.JSON.toString());
        redisTemplate.delete(key);
        return StrUtil.equals(codeFormRedis, code);
    }


}
