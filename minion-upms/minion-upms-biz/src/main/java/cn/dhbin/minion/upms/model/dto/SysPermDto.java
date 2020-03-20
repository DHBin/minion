package cn.dhbin.minion.upms.model.dto;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermDto implements Convert {

    private static final long serialVersionUID = -8282921479421736870L;

    private String id;

    private String own;

    private String name;

    private String description;

    private String path;

    private String method;

    private String authorizations;
}
