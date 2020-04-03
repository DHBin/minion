package cn.dhbin.minion.core.generate.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.RequiredArgsConstructor;

import java.io.File;

/**
 * @author donghaibin
 * @date 2020/4/8
 */
@RequiredArgsConstructor
public abstract class AbstractFileOutConfig extends FileOutConfig {

    private final GlobalConfig globalConfig;

    private final PackageConfig packageConfig;


    /**
     * 获取包路径
     *
     * @return 包路径
     */
    public String getPackagePath() {
        return joinPackage(packageConfig.getParent(), getSubPackage());
    }


    /**
     * 获取文件路径
     *
     * @return 文件路径
     */
    public String getFilePath() {
        return joinPath(globalConfig.getOutputDir(), getPackagePath());
    }

    /**
     * package key
     *
     * @return key
     */
    public abstract String getPackageKey();

    /**
     * 获取文件子路径
     *
     * @return 文件子路径
     */
    public abstract String getSubPackage();

    /**
     * 获取文件后缀
     *
     * @return 文件后缀
     */
    public abstract String getFileSuffix();


    /**
     * 输出文件路径，默认是 {@link AbstractFileOutConfig#getFilePath()} + "/" + entityName + fileSuffix
     *
     * @param tableInfo tableInfo
     * @return 输出文件路径
     */
    @Override
    public String outputFile(TableInfo tableInfo) {
        return getFilePath() + "/" + tableInfo.getEntityName() + getFileSuffix();
    }

    /**
     * 连接路径字符串
     *
     * @param parentDir   路径常量字符串
     * @param packageName 包名
     * @return 连接后的路径
     */
    protected String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }


    /**
     * 连接父子包名
     *
     * @param parent     父包名
     * @param subPackage 子包名
     * @return 连接后的包名
     */
    protected String joinPackage(String parent, String subPackage) {
        if (StringUtils.isBlank(parent)) {
            return subPackage;
        }
        return parent + StringPool.DOT + subPackage;
    }


}
