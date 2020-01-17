package cn.dhbin.minion.umps.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author donghaibin
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 6017646420864032631L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

}
