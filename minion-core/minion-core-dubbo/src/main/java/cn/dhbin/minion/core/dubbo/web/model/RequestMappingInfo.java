package cn.dhbin.minion.core.dubbo.web.model;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author donghaibin
 * @date 2020/3/14
 */
@Data
@Accessors(chain = true)
public class RequestMappingInfo implements Convert {


    private static final long serialVersionUID = 6983644763719031093L;

    /**
     * id
     */
    private String id;

    /**
     * 所属项目
     */
    private String own;

    /**
     * 路径
     */
    private String[] path;

    /**
     * 请求方法
     */
    private String[] method;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 权限
     */
    private String authorizations;


}
