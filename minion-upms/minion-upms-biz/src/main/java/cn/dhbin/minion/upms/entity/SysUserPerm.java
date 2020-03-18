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
@TableName(value = "sys_user_perm")
public class SysUserPerm extends BaseEntity {

    private static final long serialVersionUID = -7876603981538297623L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "uid")
    private Long uid;

    /**
     * 权限 id
     */
    @TableField(value = "pid")
    private String pid;


}