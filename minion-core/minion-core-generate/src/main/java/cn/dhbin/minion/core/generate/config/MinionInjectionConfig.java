package cn.dhbin.minion.core.generate.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
public class MinionInjectionConfig extends InjectionConfig {

    public MinionInjectionConfig(MinionGlobalConfig globalConfig, PackageConfig packageConfig) {
        initFileOutConfigList(globalConfig, packageConfig);
    }

    private void initFileOutConfigList(MinionGlobalConfig globalConfig, PackageConfig packageConfig) {
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        fileOutConfigs.add(new MapperXmlFileOutConfig(globalConfig, packageConfig));
        fileOutConfigs.add(new DtoFileOutConfig(globalConfig, packageConfig));
        fileOutConfigs.add(new ParamFileOutConfig(globalConfig, packageConfig));
        fileOutConfigs.add(new QueryFileOutConfig(globalConfig, packageConfig));
        setFileOutConfigList(fileOutConfigs);
    }

    @Override
    public void initMap() {
        Map<String, Object> map = new HashMap<>(getFileOutConfigList().size());
        for (FileOutConfig fileOutConfig : getFileOutConfigList()) {
            if (fileOutConfig instanceof AbstractFileOutConfig) {
                AbstractFileOutConfig config = (AbstractFileOutConfig) fileOutConfig;
                if (StrUtil.isNotBlank(config.getPackageKey())) {
                    map.put(config.getPackageKey(), config.getPackagePath());
                }
            }
        }
        setMap(map);
    }


}
