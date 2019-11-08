package cn.dhbin.minion.core.mybatis.config;

import cn.dhbin.minion.core.common.IUserInfoProvider;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author donghaibin
 * @date 2019-08-12
 */
@Configuration
public class MybatisPlusConfiguration {

    /**
     * 分页
     *
     * @return 分页插件
     */
    @Bean
    @ConditionalOnMissingBean(PaginationInterceptor.class)
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }

    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return mybatisPlusProperties -> {
            // 关闭banner
            mybatisPlusProperties.getGlobalConfig().setBanner(false);
        };
    }


    @Bean
    @ConditionalOnMissingBean(IUserInfoProvider.class)
    public IUserInfoProvider userInfoProvider() {
        return () -> 1L;
    }


    @Bean
    @ConditionalOnBean(IUserInfoProvider.class)
    public MetaObjectHandler metaObjectHandler(IUserInfoProvider userInfoProvider) {
        return new DefaultMetaObjectHandler(userInfoProvider);
    }
    
}
