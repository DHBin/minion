package cn.dhbin.core.security.server;

import cn.dhbin.core.security.component.MinionTokenEnhancer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Token
 *
 * @author donghaibin
 * @date 2020/3/12
 */
@Configuration
@RequiredArgsConstructor
public class TokenConfiguration {

    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public TokenEnhancer minionTokenEnhancer() {
        return new MinionTokenEnhancer();
    }


}
