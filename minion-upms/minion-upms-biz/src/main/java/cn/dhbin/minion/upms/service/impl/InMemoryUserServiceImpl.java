package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.umps.dto.UserInfo;
import cn.dhbin.minion.umps.service.SysUserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
@Service(version = "1.0.0")
public class InMemoryUserServiceImpl implements SysUserService {

    @Override
    public UserInfo getByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user");
        userInfo.setPassword("{noop}password");
        userInfo.setAuthorities(new String[]{"user::getByName"});
        return userInfo;
    }

}
