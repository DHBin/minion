package cn.dhbin.minion.core.mybatis.config;

import cn.dhbin.minion.core.common.IUserInfoProvider;
import cn.hutool.core.util.StrUtil;
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
     * 基础枚举包名
     */
    private final static String BASE_ENUM_PACKAGE = "cn.dhbin.minion.core.mybatis.enums";

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
            String typeEnumsPackage = mybatisPlusProperties.getTypeEnumsPackage();
            // 拼接基础枚举包
            if (StrUtil.length(typeEnumsPackage) > 0) {
                mybatisPlusProperties.setTypeEnumsPackage(typeEnumsPackage + "," + BASE_ENUM_PACKAGE);
            } else {
                mybatisPlusProperties.setTypeEnumsPackage(BASE_ENUM_PACKAGE);
            }
        };
    }

    @Bean
    @ConditionalOnBean(IUserInfoProvider.class)
    public MetaObjectHandler metaObjectHandler(IUserInfoProvider userInfoProvider) {
        return new DefaultMetaObjectHandler(userInfoProvider);
    }

}
