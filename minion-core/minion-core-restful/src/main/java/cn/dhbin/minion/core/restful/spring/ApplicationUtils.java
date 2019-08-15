/*
 * Copyright 2018~2018 DHB(xx158@qq.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cn.dhbin.minion.core.restful.spring;

import cn.dhbin.minion.core.restful.config.props.MinionConfigProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Spring工具类，提供Spring ioc的一些操作
 *
 * @author donghaibin
 * @date 2019-08-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationUtils {

    /**
     * 全局的ApplicationContext
     */
    private final static ApplicationContext APPLICATION_CONTEXT = ApplicationContextRegister.getApplicationContext();

    /**
     * 系统配置
     */
    @Setter
    private static volatile MinionConfigProperties minionConfigProperties;

    /**
     * 获取ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }


    /**
     * 获取spring bean
     *
     * @param beanName     bean名称
     * @param requiredType 类型
     * @param <T>          类型
     * @return 对应的bean
     */
    public static <T> T getBean(String beanName, Class<T> requiredType) {
        if (containsBean(beanName)) {
            return APPLICATION_CONTEXT.getBean(beanName, requiredType);
        }
        return null;
    }

    /**
     * 获取spring bean
     *
     * @param requiredType bean类型
     * @param <T>          类型
     * @return 对应的bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }

    /**
     * 获取spring bean
     *
     * @param beanName bean名称
     * @param <T>      类型
     * @return 对应的bean
     */
    public static <T> T getBean(String beanName) {
        if (containsBean(beanName)) {
            Class<T> type = getType(beanName);
            return APPLICATION_CONTEXT.getBean(beanName, type);
        }
        return null;
    }

    /**
     * 依赖spring框架获取HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = null;
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (Objects.nonNull(requestAttributes)) {
                request = requestAttributes.getRequest();
            }
        } catch (Exception ignored) {
        }
        return request;
    }

    /**
     * ApplicationContext是否包含该Bean
     *
     * @param name bean名称
     * @return 是否包含
     */
    public static boolean containsBean(String name) {
        return APPLICATION_CONTEXT.containsBean(name);
    }

    /**
     * ApplicationContext该Bean是否为单例
     *
     * @param name bean名称
     * @return 是否为单例
     */
    public static boolean isSingleton(String name) {
        return APPLICATION_CONTEXT.isSingleton(name);
    }

    /**
     * 获取该Bean的Class
     *
     * @param name bean名称
     * @return Class类型
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getType(String name) {
        return (Class<T>) APPLICATION_CONTEXT.getType(name);
    }


    /**
     * 是否开发环境
     *
     * @return 是否开发环境
     */
    public static Boolean isDev() {
        return getMinionConfigProperties().getDev();
    }

    /**
     * 获取系统配置
     *
     * @return 系统配置
     */
    public static MinionConfigProperties getMinionConfigProperties() {
        /*
         * 这里可能会出现重复赋值的情况，但getBean方法保证了单例，不加锁效率更高
         * */
        if (minionConfigProperties == null) {
            MinionConfigProperties minionConfigProperties = getBean(MinionConfigProperties.class);
            setMinionConfigProperties(minionConfigProperties);
        }
        return minionConfigProperties;
    }

}
