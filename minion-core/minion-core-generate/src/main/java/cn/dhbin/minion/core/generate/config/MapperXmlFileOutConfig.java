package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * Mapper xml 文件配置
 *
 * @author donghaibin
 * @date 2020/4/8
 */
public class MapperXmlFileOutConfig extends FileOutConfig {


    private final MinionGlobalConfig globalConfig;

    private final PackageConfig packageConfig;

    public MapperXmlFileOutConfig(MinionGlobalConfig globalConfig, PackageConfig packageConfig) {
        this.globalConfig = globalConfig;
        this.packageConfig = packageConfig;
        setTemplatePath("/templates/mapper.xml.vm");
    }


    @Override
    public String outputFile(TableInfo tableInfo) {
        return globalConfig.getResourcesPath() + "/mapper/" + packageConfig.getModuleName()
                + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
    }
}
