package cn.dhbin.minion.upms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author donghaibin
 * @date 2020/1/6
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 7176409747200426250L;

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

    /**
     * 权限
     */
    private String[] authorities;

    /**
     * 角色
     */
    private String[] roles;

}
