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
@TableName(value = "sys_api")
public class SysApi extends BaseEntity {

    private static final long serialVersionUID = -2255757251551166196L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 所属项目
     */
    @TableField(value = "own")
    private String own;

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
     * 路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 请求方法
     */
    @TableField(value = "method")
    private String method;

    /**
     * 权限标识
     */
    @TableField(value = "authorizations")
    private String authorizations;

}