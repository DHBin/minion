package cn.dhbin.minion.upms.controller;

import cn.dhbin.core.security.util.SecurityUtil;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.model.dto.MenuDto;
import cn.dhbin.minion.upms.service.SysMenuService;
import cn.dhbin.minion.upms.service.SysUserService;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/12
 */
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController extends RestfulController {

    private final StringRedisTemplate redisTemplate;

    private static final String TOP_MENU_KEY = "upms::topMenu";

    private static final String MENU_KEY = "upms::menu";

    private final SysMenuService sysMenuService;

    private final SysUserService sysUserService;


    @GetMapping("/getTopMenu")
    @ApiOperation(value = "获取顶部菜单")
    public ApiResponse<?> getTopMenu() {
        String topMenu = redisTemplate.opsForValue().get(TOP_MENU_KEY);
        if (StrUtil.isBlank(topMenu)) {
            return ok();
        }
        return ok(JSON.parseArray(topMenu));
    }

    @GetMapping("/getMenu")
    @ApiOperation(value = "获取左侧菜单")
    public ApiResponse<?> getMenu(@RequestParam(required = false, defaultValue = "-1") Integer parentId) {
        String username = SecurityUtil.getUsername();
        SysUser sysUser = sysUserService.getByUsername(username);
        List<MenuDto> menuDtos = sysMenuService.getMenuByUserId(sysUser.getId(), parentId);
        return ok(menuDtos);
    }


}
