package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.core.restful.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author donghaibin
 * @date 2019/12/25
 */
@RestController
@Api(tags = "测试")
public class TestController extends RestfulController {

    @GetMapping("/test")
    @ApiOperation("测试文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "关键字")
    })
    public ApiResponse<String> test(String key) {
        return success(key);
    }

}
