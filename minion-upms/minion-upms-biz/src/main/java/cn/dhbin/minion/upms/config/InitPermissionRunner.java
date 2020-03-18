package cn.dhbin.minion.upms.config;

import cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo;
import cn.dhbin.minion.core.dubbo.web.service.RequestMappingService;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.service.SysPermService;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@Component
@RequiredArgsConstructor
public class InitPermissionRunner implements CommandLineRunner {

    private final RequestMappingService requestMappingService;

    private final SysPermService sysPermService;

    @Override
    public void run(String... args) throws Exception {
        List<RequestMappingInfo> mappingInfos = requestMappingService.all();
        List<SysPerm> sysPermList = mappingInfos.stream().map(requestMappingInfo -> {
            SysPerm sysPerm = new SysPerm();
            sysPerm.setId(requestMappingInfo.getId());
            sysPerm.setOwn(requestMappingInfo.getOwn());
            sysPerm.setPath(String.join(StrUtil.COMMA, requestMappingInfo.getPath()));
            sysPerm.setMethod(String.join(StrUtil.COMMA, requestMappingInfo.getMethod()));
            sysPerm.setName(requestMappingInfo.getName());
            sysPerm.setDescription(requestMappingInfo.getDescription());
            sysPerm.setAuthorizations(requestMappingInfo.getAuthorizations());
            return sysPerm;
        }).collect(Collectors.toList());
        sysPermService.saveOrUpdateBatch(sysPermList);
    }

}
