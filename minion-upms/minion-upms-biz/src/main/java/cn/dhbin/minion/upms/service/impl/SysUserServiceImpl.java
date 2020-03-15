package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.mapper.SysUserMapper;
import cn.dhbin.minion.upms.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysUserServiceImpl extends MinionServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}

