package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo;
import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author donghaibin
 * @date 2019/12/25
 */
@RestController
@Api(tags = "测试")
@RequiredArgsConstructor
public class TestController extends RestfulController {

    private final RequestMappingService requestMappingService;

    @GetMapping("/test")
    @ApiOperation(value = "测试文档-获取api", authorizations = {@Authorization("user:test")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "关键字")
    })
    public ApiResponse<List<RequestMappingInfo>> test() {
        List<RequestMappingInfo> mappingInfos = requestMappingService.all();
        System.out.println(mappingInfos);
        return success(mappingInfos);
    }

}
