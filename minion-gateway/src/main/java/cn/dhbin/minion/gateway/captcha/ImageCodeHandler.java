package cn.dhbin.minion.gateway.captcha;

import com.wf.captcha.ArithmeticCaptcha;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

import static cn.dhbin.minion.gateway.config.Constant.CAPTCHA_PARAM_NAME;
import static cn.dhbin.minion.gateway.config.Constant.CODE_KEY_PREFIX;

/**
 * 验证码处理逻辑
 *
 * @author donghaibin
 * @date 2020/1/17
 */
@AllArgsConstructor
@Component
@Slf4j
public class ImageCodeHandler implements HandlerFunction<ServerResponse> {

    private final StringRedisTemplate redisTemplate;

    /**
     * 验证码宽度
     */
    private static final int CAPTCHA_WIDTH = 130;

    /**
     * 验证码高度
     */
    private static final int CAPTCHA_HEIGHT = 48;

    /**
     * 验证码有效期60秒
     */
    private static final long CAPTCHA_TIMEOUT_TIME = 60;


    @Override
    @NonNull
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Optional<String> rand = serverRequest.queryParam(CAPTCHA_PARAM_NAME);
        if (rand.isPresent()) {
            ArithmeticCaptcha captcha = new ArithmeticCaptcha(CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
            String text = captcha.text();
            redisTemplate.opsForValue().set(CODE_KEY_PREFIX + rand.get(), text, Duration.ofSeconds(CAPTCHA_TIMEOUT_TIME));
            FastByteArrayOutputStream os = new FastByteArrayOutputStream();
            captcha.out(os);
            return ServerResponse.ok()
                    .contentType(MediaType.IMAGE_GIF)
                    .body(BodyInserters.fromResource(new ByteArrayResource(os.toByteArray())));
        }
        // rand随机码为空，不处理
        if (log.isDebugEnabled()) {
            log.debug("rand参数为空，请求验证码需要添加rand参数，如：/code?rand=xxx");
        }
        return Mono.empty();
    }

}
