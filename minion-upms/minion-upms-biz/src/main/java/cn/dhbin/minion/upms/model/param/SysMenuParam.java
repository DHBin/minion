package cn.dhbin.minion.upms.model.param;

import cn.dhbin.minion.core.tool.converter.Convert;
import cn.dhbin.minion.upms.model.enums.MenuType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenuParam implements Convert {
    private static final long serialVersionUID = 4209687835379582603L;

    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank
    private String path;

    private String component;

    private Object meta;

    private String icon;

    @NotBlank
    private String label;

    @NotNull
    private Integer orderNum;

    private Integer parentNum = -1;

    @NotNull
    private MenuType type;

    @NotBlank
    private Integer num;

    private List<String> perms;

    public interface Create {
    }

    public interface Update {
    }

}
