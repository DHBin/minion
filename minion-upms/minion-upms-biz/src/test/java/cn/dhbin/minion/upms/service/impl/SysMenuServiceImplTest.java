package cn.dhbin.minion.upms.service.impl;

import cn.dhbin.minion.upms.model.dto.MenuDto;
import cn.dhbin.minion.upms.service.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@SpringBootTest
class SysMenuServiceImplTest {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    void getMenuByUserId() {
        List<MenuDto> menuDtos = sysMenuService.getMenuByUserId(1240192515995959297L, -1);
        System.out.println(menuDtos);
    }
}