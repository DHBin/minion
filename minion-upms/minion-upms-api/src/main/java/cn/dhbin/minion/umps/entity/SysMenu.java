package cn.dhbin.minion.umps.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单
 *
 * @author donghaibin
 * @date 2020/1/7
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 3931117250833698484L;

    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单拥有的权限
     */
    private String permission;

    /**
     * 路径，当类型非按钮时有效
     */
    private String path;

    /**
     * 父id，-1是root
     */
    private Long parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * vue组件
     */
    private String component;

    /**
     * 排序号
     */
    private Integer sortNum;

}
