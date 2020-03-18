package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@SpringBootTest
class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    void createUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("DHB");
        sysUser.setPhone("13800138000");
        sysUser.setEmail("xx158@qq.com");
        sysUser.setPassword("13800138000");
        sysUserService.createUser(sysUser);
    }
}