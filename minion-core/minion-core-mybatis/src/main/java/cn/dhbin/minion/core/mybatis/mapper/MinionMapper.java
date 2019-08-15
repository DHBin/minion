package cn.dhbin.minion.core.mybatis.mapper;

import cn.dhbin.minion.core.mybatis.enums.StatusEnum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
public interface MinionMapper<T> extends BaseMapper<T> {

    /**
     * 更新状态
     *
     * @param id     id
     * @param status 状态
     * @return 影响行数
     */
    int updateStatusById(@Param("id") Serializable id, @Param("status") StatusEnum status);

    /**
     * 更新状态
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    int updateStatus(@Param(Constants.ENTITY) T entity);

}
