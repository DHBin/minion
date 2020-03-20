package cn.dhbin.minion.upms.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Data
@TableName(value = "sys_menu_perm")
public class SysMenuPerm extends BaseEntity {

    private static final long serialVersionUID = -7386067535622281715L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 菜单id
     */
    @TableField(value = "mid")
    private Long mid;

    /**
     * 权限id
     */
    @TableField(value = "pid")
    private String pid;

}