package cn.dhbin.minion.upms.model.param;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/21
 */
@Data
public class UpdateRoleMenuParam implements Convert {

    private static final long serialVersionUID = 442779184952214582L;

    @NotNull
    private Long roleId;

    private List<Long> menuIds;

}
