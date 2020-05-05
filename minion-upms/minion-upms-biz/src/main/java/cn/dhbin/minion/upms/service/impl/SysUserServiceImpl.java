package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.core.restful.util.ApiAssert;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.mapper.SysUserMapper;
import cn.dhbin.minion.upms.model.dto.UserDto;
import cn.dhbin.minion.upms.model.enums.ErrorCode;
import cn.dhbin.minion.upms.service.SysRoleService;
import cn.dhbin.minion.upms.service.SysUserRoleService;
import cn.dhbin.minion.upms.service.SysUserService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends MinionServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final String CACHE_NAME = "sysUser";

    private final PasswordEncoder passwordEncoder;

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleService sysRoleService;

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#username")
    public SysUser getByUsername(String username) {
        return lambdaQuery().eq(SysUser::getUsername, username).one();
    }

    @Override
    public void createUser(SysUser sysUser) {
        SysUserService proxy = (SysUserService) AopContext.currentProxy();
        proxy.createUser(sysUser, null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = CACHE_NAME, key = "#sysUser.id")
    public void createUser(SysUser sysUser, List<Long> roles) {
        Integer count = this.lambdaQuery().eq(SysUser::getUsername, sysUser.getUsername()).count();
        ApiAssert.isFalse(ErrorCode.USERNAME_EXITED, count > 0);
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        save(sysUser);
        if (CollUtil.isNotEmpty(roles)) {
            this.sysUserRoleService.updateUserRole(roles, sysUser.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(SysUser sysUser, List<Long> roles) {
        Integer count = this.lambdaQuery().eq(SysUser::getUsername, sysUser.getUsername())
                .ne(SysUser::getId, sysUser.getId()).count();
        ApiAssert.isFalse(ErrorCode.USERNAME_EXITED, count > 0);
        sysUser.setPassword(null);
        this.sysUserRoleService.updateUserRole(roles, sysUser.getId());
        updateByIdAndReturn(sysUser);
    }

    @Override
    public IPage<UserDto> list(PageModel<SysUser> pageModel) {
        Page<SysUser> userPage = pageModel.convert();
        return this.page(userPage)
                .convert(sysUser -> {
                    UserDto dto = sysUser.convert(UserDto.class);
                    List<Long> roles = this.sysRoleService.getRoleByUserId(dto.getId()).stream()
                            .map(SysRole::getId)
                            .collect(Collectors.toList());
                    dto.setRoles(roles);
                    dto.setPassword("****");
                    return dto;
                });
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#entity.username")
    public SysUser updateByIdAndReturn(SysUser entity) {
        return super.updateByIdAndReturn(entity);
    }


}

