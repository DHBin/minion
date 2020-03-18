package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysUserPerm;
import cn.dhbin.minion.upms.mapper.SysUserPermMapper;
import cn.dhbin.minion.upms.service.SysUserPermService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysUserPermServiceImpl extends MinionServiceImpl<SysUserPermMapper, SysUserPerm> implements SysUserPermService {

    @Override
    public List<SysUserPerm> getByUserId(Long userId) {
        return lambdaQuery().eq(SysUserPerm::getUid, userId).list();
    }

}
