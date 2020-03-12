package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/getTopMenu")
    public ApiResponse<?> getTopMenu() {
        String topMenu = redisTemplate.opsForValue().get(TOP_MENU_KEY);
        if (StrUtil.isBlank(topMenu)) {
            return ok();
        }
        return ok(JSON.parseArray(topMenu));
    }

    @GetMapping("/getMenu")
    public ApiResponse<?> getMenu(int type) {
        String menu = redisTemplate.opsForValue().get(MENU_KEY);
        if (StrUtil.isBlank(menu)) {
            return ok();
        }
        JSONArray menuTree = JSON.parseArray(menu);
        if (menuTree == null) {
            return ok();
        }
        return ok(menuTree.getJSONArray(type));
    }


}
