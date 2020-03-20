package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysUser;
import cn.dhbin.minion.upms.model.dto.UserDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysUserService extends IMinionService<SysUser> {


    /**
     * 通过用户名获取SysUser
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser getByUsername(String username);


    /**
     * 创建用户
     *
     * @param sysUser sysUser
     * @return 是否成功
     */
    void createUser(SysUser sysUser);

    /**
     * 创建用户并关联角色
     *
     * @param sysUser sysUser
     * @param roles   角色id
     * @return 是否成功
     */
    void createUser(SysUser sysUser, List<Long> roles);

    /**
     * 更新用户
     *
     * @param sysUser sysUser
     * @param roles   角色id
     */
    void updateUser(SysUser sysUser, List<Long> roles);


    /**
     * 分页获取用户
     *
     * @param pageModel 分页
     * @return SysUser
     */
    IPage<UserDto> list(PageModel<SysUser> pageModel);


}
