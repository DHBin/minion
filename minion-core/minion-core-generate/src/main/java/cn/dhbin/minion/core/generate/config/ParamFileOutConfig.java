package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
public class ParamFileOutConfig extends AbstractFileOutConfig {

    public ParamFileOutConfig(GlobalConfig globalConfig, PackageConfig packageConfig) {
        super(globalConfig, packageConfig);
        setTemplatePath("/templates/param.java.vm");
    }

    @Override
    public String getPackageKey() {
        return "paramPackage";
    }

    @Override
    public String getSubPackage() {
        return "model.param";
    }

    @Override
    public String getFileSuffix() {
        return "Param.java";
    }
}
