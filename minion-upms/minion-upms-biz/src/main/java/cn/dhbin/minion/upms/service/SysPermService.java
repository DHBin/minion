package cn.dhbin.minion.upms.service;

import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.IMinionService;
import cn.dhbin.minion.upms.entity.SysPerm;
import cn.dhbin.minion.upms.model.dto.SysPermDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysPermService extends IMinionService<SysPerm> {

    /**
     * 获取用户权限
     *
     * @param roleId 角色id
     * @return 用户权限
     */
    List<SysPerm> getByRoleId(Long roleId);

    /**
     * 获取用户权限
     *
     * @param menuId 菜单id
     * @return 用户权限
     */
    List<SysPerm> getByMenuId(Long menuId);

    /**
     * 获取所有
     *
     * @return sysPermDto
     */
    List<SysPermDto> all();

    /**
     * 分页
     *
     * @param pageModel 分页
     * @return sysPermDto
     */
    IPage<SysPermDto> page(PageModel<SysPerm> pageModel);

}
