package cn.dhbin.minion.core.mybatis.mapper;

import cn.dhbin.minion.core.mybatis.enums.StatusEnum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
public interface MinionMapper<T> extends BaseMapper<T> {

    /**
     * 改变状态
     *
     * @param id     id
     * @param status 状态
     * @return 是否成功
     */
    boolean changeStatusById(@Param("id") Serializable id, @Param("status") StatusEnum status);

}
