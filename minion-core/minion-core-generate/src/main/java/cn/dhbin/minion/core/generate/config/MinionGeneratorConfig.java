package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author donghaibin
 * @date 2020/4/9
 */
public class MinionGeneratorConfig {

    public static StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setSuperEntityClass("cn.dhbin.minion.core.common.entity.BaseEntity");
        strategyConfig.setSuperControllerClass("cn.dhbin.minion.core.restful.controller.RestfulController");
        strategyConfig.setSuperServiceClass("cn.dhbin.minion.core.mybatis.service.IMinionService");
        strategyConfig.setSuperServiceImplClass("cn.dhbin.minion.core.mybatis.service.MinionServiceImpl");
        strategyConfig.setSuperMapperClass("cn.dhbin.minion.core.mybatis.mapper.MinionMapper");
        strategyConfig.setSuperEntityColumns("create_time", "update_time", "create_uid", "update_uid");
        strategyConfig.setControllerMappingHyphenStyle(false);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        return strategyConfig;
    }

    public static GlobalConfig globalConfig(String author) {
        MinionGlobalConfig globalConfig = new MinionGlobalConfig();
        globalConfig.setServiceName("%sService");
        globalConfig.setSwagger2(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor(author);
        return globalConfig;
    }

    public static PackageConfig packageConfig(String parent, String moduleName) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parent);
        packageConfig.setModuleName(moduleName);
        return packageConfig;
    }

    public static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        return templateConfig;
    }


}
