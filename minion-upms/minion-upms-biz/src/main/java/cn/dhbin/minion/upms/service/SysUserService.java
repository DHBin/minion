package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysUser;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysUserService extends IMinionService<SysUser> {


    /**
     * 通过用户名获取SysUser
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser getByUsername(String username);


    /**
     * 创建用户
     *
     * @param sysUser sysUser
     * @return 是否成功
     */
    boolean createUser(SysUser sysUser);

}
