package cn.dhbin.minion.upms.model.param;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleParam implements Convert {

    private static final long serialVersionUID = 2816556975675989486L;

    @NotNull(groups = UPDATE.class)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String roleKey;

    @NotBlank
    private String description;

    private List<String> perms;

    public interface CREATE {
    }

    public interface UPDATE {
    }

}
