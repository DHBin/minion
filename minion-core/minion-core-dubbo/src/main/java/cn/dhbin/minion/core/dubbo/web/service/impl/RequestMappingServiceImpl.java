package cn.dhbin.minion.core.dubbo.web.service.impl;

import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/14
 */
@Slf4j
@Builder
public class RequestMappingServiceImpl implements RequestMappingService {


    private final String owm;

    /**
     * 请求映射信息
     * <p>
     * {@link org.springframework.web.bind.annotation.RequestMapping}
     * {@link org.springframework.stereotype.Controller}
     * {@link org.springframework.web.bind.annotation.RestController}
     */
    private final RequestMappingHandlerMapping mapping;


    @Override
    public List<cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo> all() {
        List<cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo> requestMappingInfos = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo info = new cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo();
            info.setOwn(owm);

            // 设置路径
            PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
            info.setPath(patternsCondition.getPatterns().toArray(new String[]{}));

            // 设置请求方法
            RequestMethodsRequestCondition methodsCondition = requestMappingInfo.getMethodsCondition();
            info.setMethod(methodsCondition.getMethods().stream().map(Enum::toString).toArray(String[]::new));

            // 设置名称、描述、权限信息等
            ApiOperation apiOperation = handlerMethod.getMethodAnnotation(ApiOperation.class);
            if (apiOperation != null) {
                info.setName(apiOperation.value());
                info.setDescription(apiOperation.notes());
                List<String> authorizations = Arrays.stream(apiOperation.authorizations())
                        .map(Authorization::value)
                        .collect(Collectors.toList());
                info.setAuthorizations(String.join(StrUtil.COMMA, authorizations));
            }

            // md5(own + method[] + path[])
            String own = info.getOwn();
            String methods = String.join(StrUtil.COMMA, info.getMethod());
            String paths = String.join(StrUtil.COMMA, info.getPath());
            String id = SecureUtil.md5(own + methods + paths);
            info.setId(id);
            requestMappingInfos.add(info);
        });
        return requestMappingInfos.stream().distinct().collect(Collectors.toList());
    }


}
