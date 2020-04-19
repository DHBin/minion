package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MinionGlobalConfig extends GlobalConfig {

    @Setter(value = AccessLevel.PRIVATE)
    private String rootPath = System.getProperty("user.dir") + "/generate";

    /**
     * java文件的输出目录
     */
    private String outputDir = rootPath + "/src/main/java";

    /**
     * 资源文件路径
     */
    private String resourcesPath = rootPath + "/src/main/resources";

    /**
     * 前端文件路径
     */
    private String frontPath = rootPath + "/front/src";


}
