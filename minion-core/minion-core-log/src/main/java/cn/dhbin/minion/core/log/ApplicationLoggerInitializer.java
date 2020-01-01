package cn.dhbin.minion.core.log;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author donghaibin
 * @date 2020/1/1
 * <p>
 * 配置log
 * <p>
 * https://gitee.com/log4j/pig/blob/master/pig-common/pig-common-log/src/main/java/com/pig4cloud/pig/common/log/init/ApplicationLoggerInitializer.java
 */
public class ApplicationLoggerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();

        String appName = environment.getProperty("spring.application.name");

        String logBase = environment.getProperty("LOGGING_PATH", "logs");
        // spring boot admin 直接加载日志
        System.setProperty("logging.file", String.format("%s/%s/debug.log", logBase, appName));
    }

}
