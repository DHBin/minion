package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.mapper.SysUserMapper;
import cn.dhbin.minion.upms.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends MinionServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final String CACHE_NAME = "sysUser";

    private final PasswordEncoder passwordEncoder;

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#username")
    public SysUser getByUsername(String username) {
        return lambdaQuery().eq(SysUser::getUsername, username).one();
    }

    @Override
    public boolean createUser(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        return save(sysUser);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#entity.username")
    public SysUser updateByIdAndReturn(SysUser entity) {
        return super.updateByIdAndReturn(entity);
    }


}

