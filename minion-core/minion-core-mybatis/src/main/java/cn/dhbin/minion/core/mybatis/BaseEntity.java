package cn.dhbin.minion.core.mybatis;

import cn.dhbin.minion.core.mybatis.enums.StatusEnum;
import cn.dhbin.minion.core.tool.converter.Convert;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据表基类
 *
 * @author donghaibin
 */
@Getter
@Setter
public class BaseEntity implements Convert {

    private static final long serialVersionUID = 3438025469197953344L;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUid;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUid;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    /**
     * 状态，1-正常，0-禁用
     */
    private StatusEnum status;

    /**
     * 如果状态为空进行赋值
     *
     * @param status 状态
     */
    public void setStatusIfNull(StatusEnum status) {
        if (this.getStatus() == null) {
            this.setStatus(status);
        }
    }
}
