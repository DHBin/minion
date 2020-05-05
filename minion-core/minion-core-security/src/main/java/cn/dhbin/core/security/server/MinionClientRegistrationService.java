package cn.dhbin.core.security.server;

import cn.dhbin.minion.core.common.model.Page;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationService;

/**
 * @author donghaibin
 * @date 2020/5/1
 */
public interface MinionClientRegistrationService extends ClientRegistrationService {


    /**
     * 分页获取{@link ClientDetails}
     *
     * @param current 当前页
     * @param size    页大小
     * @return {@link ClientDetails}
     */
    Page<ClientDetails> pageClientDetails(Integer current, Integer size);


}
