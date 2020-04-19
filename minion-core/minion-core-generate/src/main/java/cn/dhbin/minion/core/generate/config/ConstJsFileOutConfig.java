package cn.dhbin.minion.core.generate.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * @author donghaibin
 * @date 2020/4/19
 */
public class ConstJsFileOutConfig extends FileOutConfig {

    private final MinionGlobalConfig globalConfig;

    private final PackageConfig packageConfig;

    public ConstJsFileOutConfig(MinionGlobalConfig globalConfig, PackageConfig packageConfig) {
        this.globalConfig = globalConfig;
        this.packageConfig = packageConfig;
        setTemplatePath("templates/const.js.vm");
    }

    @Override
    public String outputFile(TableInfo tableInfo) {
        return globalConfig.getFrontPath() + "/const/" + packageConfig.getModuleName()
                + "/" + StrUtil.lowerFirst(tableInfo.getEntityName()) + ".js";
    }

}
