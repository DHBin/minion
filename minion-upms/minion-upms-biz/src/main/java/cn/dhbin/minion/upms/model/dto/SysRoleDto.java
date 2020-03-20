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
public class SysRoleDto implements Convert {

    private static final long serialVersionUID = -2786978520047548391L;

    private Long id;

    private String name;

    private String roleKey;

    private String description;

    private List<String> perms;


}
