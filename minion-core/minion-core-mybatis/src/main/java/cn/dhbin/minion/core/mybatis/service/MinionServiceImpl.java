package cn.dhbin.minion.core.mybatis.service;

import cn.dhbin.minion.core.mybatis.BaseEntity;
import cn.dhbin.minion.core.mybatis.mapper.MinionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
public class MinionServiceImpl<M extends MinionMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements IMinionService<T> {


}
