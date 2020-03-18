package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.mapper.SysApiMapper;
import cn.dhbin.minion.upms.service.SysPermService;
import cn.dhbin.minion.upms.service.SysUserPermService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysPermServiceImpl extends MinionServiceImpl<SysApiMapper, SysPerm> implements SysPermService {

    private final SysUserPermService sysUserPermService;


    @Override
    public List<SysPerm> getByUserId(Long userId) {
        return sysUserPermService.getByUserId(userId)
                .stream()
                .map(sysUserPerm -> lambdaQuery().eq(SysPerm::getId, sysUserPerm.getPid()).one())
                .collect(Collectors.toList());
    }


}
