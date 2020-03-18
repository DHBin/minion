package cn.dhbin.minion.core.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
public interface IMinionService<T> extends IService<T> {

    /**
     * 更新
     *
     * @param entity entity
     * @return 更新后的entity，如果失败返回null
     */
    T updateByIdAndReturn(T entity);

}
