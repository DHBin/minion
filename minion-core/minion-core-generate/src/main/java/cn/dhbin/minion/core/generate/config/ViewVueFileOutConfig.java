package cn.dhbin.minion.core.generate.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * @author donghaibin
 * @date 2020/4/19
 */
public class ViewVueFileOutConfig extends FileOutConfig {

    private final MinionGlobalConfig globalConfig;

    private final PackageConfig packageConfig;

    public ViewVueFileOutConfig(MinionGlobalConfig globalConfig, PackageConfig packageConfig) {
        this.globalConfig = globalConfig;
        this.packageConfig = packageConfig;
        setTemplatePath("templates/view.vue.vm");
    }

    @Override
    public String outputFile(TableInfo tableInfo) {
        return globalConfig.getFrontPath() + "/views/" + packageConfig.getModuleName()
                + "/" + StrUtil.lowerFirst(tableInfo.getEntityName()) + ".vue";
    }


}
