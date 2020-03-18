package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysRole;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysRoleService extends IMinionService<SysRole> {


    /**
     * 获取角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<SysRole> getRoleByUserId(Long userId);

}
