package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysPerm;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysPermService extends IMinionService<SysPerm> {

    /**
     * 获取用户权限
     *
     * @param userId 用户id
     * @return 用户权限
     */
    List<SysPerm> getByUserId(Long userId);

}
