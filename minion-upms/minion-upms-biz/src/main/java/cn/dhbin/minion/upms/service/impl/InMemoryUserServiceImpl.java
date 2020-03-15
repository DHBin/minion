package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.upms.Version;
import cn.dhbin.minion.upms.dto.UserInfo;
import cn.dhbin.minion.upms.service.RemoteUserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
@Service(version = Version.V_1_0_0)
public class InMemoryUserServiceImpl implements RemoteUserService {

    @Override
    public UserInfo getByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user");
        userInfo.setPassword("{noop}password");
        userInfo.setRoles(new String[]{"admin"});
        userInfo.setAuthorities(new String[]{"admin"});
        userInfo.setAuthorities(new String[]{"user::getByName"});
        return userInfo;
    }

}
