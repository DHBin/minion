package cn.dhbin.minion.core.restful.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 暴露ApplicationContext
 *
 * @author donghaibin
 * @date 2019-08-10
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    static ApplicationContext getApplicationContext() {
        Assert.notNull(applicationContext, "ApplicationContextRegister未注入ioc容器");
        return applicationContext;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextRegister.applicationContext = applicationContext;
    }

}
