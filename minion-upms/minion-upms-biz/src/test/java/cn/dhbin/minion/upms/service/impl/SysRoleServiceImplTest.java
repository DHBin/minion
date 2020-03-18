package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.upms.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@SpringBootTest
class SysRoleServiceImplTest {

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    public SysRole buildSysRole() {
        SysRole sysRole = new SysRole();
        sysRole.setName("dhb");
        sysRole.setRoleKey("dhb");
        sysRole.setDescription("dhb");
        return sysRole;
    }

    @Test
    public void testCache() {
        for (int i = 0; i < 1; i++) {
            SysRole sysRole = buildSysRole();
            sysRoleService.save(sysRole);
            System.out.println(sysRole);
            sysRole.setName("xxxxxxx");
            sysRoleService.updateByIdAndReturn(sysRole);

            SysRole sysRole1 = sysRoleService.getById(sysRole.getId());
            System.out.println(sysRole1);
        }

    }

}