package cn.dhbin.minion.core.tool.converter;

import java.io.Serializable;

/**
 * @author donghaibin
 */
public interface Convert extends Serializable {

    /**
     * 获取自动转换后的JavaBean对象
     *
     * @param clazz class类型
     * @param <T>   类型
     * @return 对象
     */
    default <T> T convert(Class<T> clazz) {
        return BeanConverter.convert(clazz, this);
    }
}
