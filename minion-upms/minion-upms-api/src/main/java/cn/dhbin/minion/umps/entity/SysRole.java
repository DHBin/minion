package cn.dhbin.minion.umps.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 *
 * @author donghaibin
 * @date 2020/1/7
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1748196401681546890L;

    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 标识
     */
    private String code;

}
