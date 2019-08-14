package cn.dhbin.minion.core.common;

/**
 * 用户id提供者
 *
 * @author donghaibin
 * @date 2019-08-12
 */
public interface IUserInfoProvider {

    /**
     * 获取用户id
     *
     * @return 用户id
     */
    Long getUid();
}
