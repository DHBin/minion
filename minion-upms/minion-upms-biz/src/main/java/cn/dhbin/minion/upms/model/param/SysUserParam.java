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
public class SysUserParam implements Convert {

    private static final long serialVersionUID = -8140707513032044776L;

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    @NotBlank(groups = {CREATE.class})
    private String password;

    private List<Long> roles;

    public interface UPDATE {
    }

    public interface CREATE {
    }


}
