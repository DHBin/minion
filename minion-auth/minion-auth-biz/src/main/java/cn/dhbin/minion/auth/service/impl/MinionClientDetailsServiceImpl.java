package cn.dhbin.minion.auth.service.impl;


import cn.dhbin.core.security.server.MinionClientRegistrationService;
import cn.dhbin.minion.auth.api.MinionClientDetailsService;
import cn.dhbin.minion.auth.api.model.MinionClientDetails;
import cn.dhbin.minion.core.common.model.Page;
import cn.dhbin.minion.upms.Version;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/4/27
 */
@Service(version = Version.V_1_0_0)
@Slf4j
@RequiredArgsConstructor
@Component
public class MinionClientDetailsServiceImpl implements MinionClientDetailsService {

    private final MinionClientRegistrationService clientRegistrationService;

    @Override
    public boolean addClientDetails(MinionClientDetails minionClientDetails) {
        try {
            clientRegistrationService.addClientDetails(buildClientDetails(minionClientDetails));
        } catch (ClientAlreadyExistsException e) {
            log.warn("client id 已存在", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeClientDetails(String clientId) {
        try {
            clientRegistrationService.removeClientDetails(clientId);
        } catch (NoSuchClientException e) {
            log.warn("client id 不存在", e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateClientDetails(MinionClientDetails minionClientDetails) {
        try {
            clientRegistrationService.updateClientDetails(buildClientDetails(minionClientDetails));
            if (StrUtil.isNotBlank(minionClientDetails.getClientSecret())) {
                clientRegistrationService.updateClientSecret(minionClientDetails.getClientId(), minionClientDetails.getClientSecret());
            }
        } catch (NoSuchClientException e) {
            log.warn("client id 不存在", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateClientSecret(String clientId, String clientSecret) {
        try {
            clientRegistrationService.updateClientSecret(clientId, clientSecret);
            return true;
        } catch (NoSuchClientException e) {
            log.warn("client id : {}", clientId, e);
            return false;
        }
    }

    @Override
    public List<MinionClientDetails> listClientDetails() {
        return clientRegistrationService.listClientDetails().stream().map(clientDetails -> {
            MinionClientDetails details = new MinionClientDetails();
            BeanUtils.copyProperties(clientDetails, details);
            return details;
        }).collect(Collectors.toList());
    }

    @Override
    public Page<MinionClientDetails> page(Integer current, Integer size) {
        Assert.notNull(current, "current 不能为null");
        Assert.notNull(size, "size 不能为null");
        return clientRegistrationService.pageClientDetails(current - 1, size)
                .convert(clientDetails -> {
                    MinionClientDetails details = new MinionClientDetails();
                    BeanUtils.copyProperties(clientDetails, details);
                    return details;
                });
    }

    private ClientDetails buildClientDetails(MinionClientDetails minionClientDetails) {
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(minionClientDetails.getClientId());
        clientDetails.setClientSecret(minionClientDetails.getClientSecret());
        clientDetails.setScope(minionClientDetails.getScope());
        if (CollUtil.isNotEmpty(minionClientDetails.getAutoApproveScopes())) {
            clientDetails.setAutoApproveScopes(minionClientDetails.getAutoApproveScopes());
        }
        if (CollUtil.isNotEmpty(minionClientDetails.getResourceIds())) {
            clientDetails.setResourceIds(minionClientDetails.getResourceIds());
        }
        if (CollUtil.isNotEmpty(minionClientDetails.getAuthorizedGrantTypes())) {
            clientDetails.setAuthorizedGrantTypes(minionClientDetails.getAuthorizedGrantTypes());
        }
        clientDetails.setRegisteredRedirectUri(minionClientDetails.getRegisteredRedirectUris());
        clientDetails.setAccessTokenValiditySeconds(minionClientDetails.getAccessTokenValiditySeconds());
        clientDetails.setRefreshTokenValiditySeconds(minionClientDetails.getRefreshTokenValiditySeconds());
        return clientDetails;
    }
}
