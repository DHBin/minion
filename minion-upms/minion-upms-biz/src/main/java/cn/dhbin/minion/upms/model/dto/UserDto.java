package cn.dhbin.minion.upms.model.dto;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto implements Convert {

    private static final long serialVersionUID = -3110734043125819879L;

    private Long id;

    private String username;

    private String phone;

    private String email;

    private String password;

    private List<Long> roles;

}
