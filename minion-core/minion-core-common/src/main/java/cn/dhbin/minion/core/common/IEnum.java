package cn.dhbin.minion.core.common;

import java.io.Serializable;

/**
 * 通用枚举
 *
 * @author donghaibin
 * @date 2019-08-10
 */
public interface IEnum<T extends Serializable> {

    /**
     * 获取枚举值
     *
     * @return obj
     */
    T getValue();


}
