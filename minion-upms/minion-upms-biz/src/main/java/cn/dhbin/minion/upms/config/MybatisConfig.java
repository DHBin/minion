package cn.dhbin.minion.upms.config;

import cn.dhbin.minion.core.common.IUserInfoProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Configuration
public class MybatisConfig {

    @Bean
    public IUserInfoProvider userInfoProvider() {
        return () -> 1L;
    }

}
