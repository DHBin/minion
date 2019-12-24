package cn.dhbin.minion.core.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donghaibin
 * @date 2019/12/24
 */
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 是否开启swagger
     */
    private Boolean enabled;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * termsOfServiceUrl
     */
    private String termsOfServiceUrl;

    /**
     * 版本
     */
    private String version;

    /**
     * basePackage
     */
    private String basePackage;

    /**
     * 排除路径
     */
    private List<String> excludePath = new ArrayList<>();

}
