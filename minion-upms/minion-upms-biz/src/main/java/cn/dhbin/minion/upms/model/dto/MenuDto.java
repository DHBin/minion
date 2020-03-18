package cn.dhbin.minion.upms.model.dto;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuDto implements Convert {

    private static final long serialVersionUID = -797162840129744190L;

    private String path;

    private String component;

    private List<MenuDto> children;

    private Object meta;

    private String icon;

    private String label;

    private Integer orderNum;

    private Integer parentNum;

    private Integer num;

}
