package cn.dhbin.minion.upms.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 4437547257991502950L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 说明
     */
    @TableField(value = "description")
    private String description;

    /**
     * 1-顶部菜单 2-左侧菜单
     */
    @TableField(value = "type")
    private Boolean type;

    /**
     * 前端页面路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 前端组件路径
     */
    @TableField(value = "component")
    private String component;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 编号
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 父级编码
     */
    @TableField(value = "parent_num")
    private Integer parentNum;

    /**
     * 顺序
     */
    @TableField(value = "order_num")
    private Integer orderNum;


}