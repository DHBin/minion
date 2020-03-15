package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.upms.dto.UserInfo;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
public interface RemoteUserService {

    /**
     * 根据用户名获取信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo getByUsername(String username);


}
