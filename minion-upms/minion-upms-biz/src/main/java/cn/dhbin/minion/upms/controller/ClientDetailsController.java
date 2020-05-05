package cn.dhbin.minion.upms.controller;

import cn.dhbin.minion.auth.api.MinionClientDetailsService;
import cn.dhbin.minion.auth.api.Version;
import cn.dhbin.minion.core.common.model.Page;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.upms.model.dto.MinionClientDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.dhbin.minion.upms.model.dto.MinionClientDetailsDto.dto2MinionClientDetails;

/**
 * @author donghaibin
 * @date 2020/4/27
 */
@Api(tags = {"授权管理"})
@RequestMapping("/client")
@RestController
@RequiredArgsConstructor
public class ClientDetailsController extends RestfulController {

    @Reference(version = Version.V_1_0_0)
    private MinionClientDetailsService clientDetailsService;

    @PostMapping
    @ApiOperation(value = "添加Client", authorizations = @Authorization("auth_client_create"))
    @PreAuthorize("hasAuthority('auth_client_create')")
    public ApiResponse<Boolean> addClientDetails(@Validated @RequestBody MinionClientDetailsDto clientDetailsDto) {
        return created(clientDetailsService.addClientDetails(dto2MinionClientDetails(clientDetailsDto)));
    }

    @DeleteMapping("/{clientId}")
    @ApiOperation(value = "删除Client", authorizations = @Authorization("auth_client_delete"))
    @PreAuthorize("hasAuthority('auth_client_delete')")
    public ApiResponse<Boolean> removeClientDetails(@PathVariable String clientId) {
        return noContent(clientDetailsService.removeClientDetails(clientId));
    }

    @PutMapping
    @ApiOperation(value = "更新Client", authorizations = @Authorization("auth_client_update"))
    @PreAuthorize("hasAuthority('auth_client_update')")
    public ApiResponse<Boolean> updateClientDetails(@Validated @RequestBody MinionClientDetailsDto clientDetailsDto) {
        return noContent(clientDetailsService.updateClientDetails(dto2MinionClientDetails(clientDetailsDto)));
    }

    @GetMapping
    @ApiOperation(value = "获取Client列表", authorizations = @Authorization("auth_client_list"))
    @PreAuthorize("hasAuthority('auth_client_list')")
    public ApiResponse<Page<MinionClientDetailsDto>> list(PageModel<ClientDetails> pageModel) {
        return ok(clientDetailsService.page(pageModel.getCurrent(), pageModel.getSize())
                .convert(MinionClientDetailsDto::minionClientDetails2Dto)
        );
    }

}
