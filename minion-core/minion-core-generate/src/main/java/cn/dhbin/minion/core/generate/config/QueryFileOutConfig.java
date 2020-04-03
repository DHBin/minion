package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
public class QueryFileOutConfig extends AbstractFileOutConfig {

    public QueryFileOutConfig(GlobalConfig globalConfig, PackageConfig packageConfig) {
        super(globalConfig, packageConfig);
        setTemplatePath("/templates/query.java.vm");
    }

    @Override
    public String getPackageKey() {
        return "queryPackage";
    }

    @Override
    public String getSubPackage() {
        return "model.query";
    }

    @Override
    public String getFileSuffix() {
        return "Query.java";
    }
}
