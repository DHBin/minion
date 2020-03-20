package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysRole;
import cn.dhbin.minion.upms.model.dto.SysRoleDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    /**
     * 分页获取角色
     *
     * @param pageModel 分页
     * @return sysRole
     */
    IPage<SysRoleDto> list(PageModel<SysRole> pageModel);

    /**
     * 创建角色
     *
     * @param sysRole 角色
     * @param perms   权限
     */
    void create(SysRole sysRole, List<String> perms);

    /**
     * 更新角色
     *
     * @param sysRole 角色
     * @param perms   权限
     */
    void update(SysRole sysRole, List<String> perms);

}
