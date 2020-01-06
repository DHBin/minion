package cn.dhbin.minion.umps.service;

import cn.dhbin.minion.umps.dto.UserInfo;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
public interface SysUserService {

    /**
     * 根据用户名获取信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo getByUsername(String username);


}
