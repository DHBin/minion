package cn.dhbin.minion.upms.config;

import cn.dhbin.core.security.util.SecurityUtil;
import cn.dhbin.minion.core.common.IUserInfoProvider;
import cn.dhbin.minion.core.mybatis.plugins.PerformanceInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
        return SecurityUtil::getUserId;
    }

    @Bean
    @ConditionalOnProperty(prefix = "minion", name = "dev", havingValue = "true")
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
