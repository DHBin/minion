package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.core.restful.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author donghaibin
 * @date 2020/1/4
 */
@RestController
@RequestMapping("user")
public class UserController extends RestfulController {

    @GetMapping("getByName")
    public ApiResponse<String> getByName(String username) {
        return success(username);
    }

}
