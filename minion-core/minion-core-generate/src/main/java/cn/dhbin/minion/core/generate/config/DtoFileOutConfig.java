package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
public class DtoFileOutConfig extends AbstractFileOutConfig {


    public DtoFileOutConfig(GlobalConfig globalConfig, PackageConfig packageConfig) {
        super(globalConfig, packageConfig);
        setTemplatePath("/templates/dto.java.vm");
    }

    @Override
    public String getPackageKey() {
        return "dtoPackage";
    }

    @Override
    public String getSubPackage() {
        return "model.dto";
    }

    @Override
    public String getFileSuffix() {
        return "Dto.java";
    }

}
