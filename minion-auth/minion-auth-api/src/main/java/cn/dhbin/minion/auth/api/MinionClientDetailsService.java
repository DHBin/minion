package cn.dhbin.minion.auth.api;

import cn.dhbin.minion.auth.api.model.MinionClientDetails;
import cn.dhbin.minion.core.common.model.Page;

import java.util.List;

/**
 * Client Details
 *
 * @author donghaibin
 */
public interface MinionClientDetailsService {

    /**
     * add client details
     *
     * @param minionClientDetails client details
     * @return 添加成功 true，否则 false
     */
    boolean addClientDetails(MinionClientDetails minionClientDetails);

    /**
     * remove client details
     *
     * @param clientId client id
     * @return 删除成功 true，否则 false
     */
    boolean removeClientDetails(String clientId);


    /**
     * update client details
     *
     * @param minionClientDetails client details
     * @return 更新成功 true，否则 false
     */
    boolean updateClientDetails(MinionClientDetails minionClientDetails);

    /**
     * update client secret
     *
     * @param clientId     client id
     * @param clientSecret client secret
     * @return 更新密码成功 true 否则 false
     */
    boolean updateClientSecret(String clientId, String clientSecret);


    /**
     * get client details list
     *
     * @return client details list
     */
    List<MinionClientDetails> listClientDetails();

    /**
     * 分页获取
     *
     * @param current 当前页
     * @param size    页大小
     * @return {@link MinionClientDetails}
     */
    Page<MinionClientDetails> page(Integer current, Integer size);

}
