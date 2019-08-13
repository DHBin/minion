package cn.dhbin.minion.core.mybatis.config;

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
            mybatisPlusProperties.getGlobalConfig().setBanner(false);
            mybatisPlusProperties.setTypeEnumsPackage("cn.dhbin.minion.core.mybatis.enums");

        };
    }

    @Bean
    @ConditionalOnBean(IUserInfoProvider.class)
    public MetaObjectHandler metaObjectHandler(IUserInfoProvider userInfoProvider) {
        return new DefaultMetaObjectHandler(userInfoProvider);
    }

    @Bean
    public MinionSqlInjector minionSqlInjector() {
        return new MinionSqlInjector();
    }

}
