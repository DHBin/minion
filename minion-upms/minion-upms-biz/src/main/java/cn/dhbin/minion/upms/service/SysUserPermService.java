package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysUserPerm;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysUserPermService extends IMinionService<SysUserPerm> {


    /**
     * 获取用户-权限关联信息
     *
     * @param userId 用户id
     * @return 用户-权限关联信息
     */
    List<SysUserPerm> getByUserId(Long userId);

}
