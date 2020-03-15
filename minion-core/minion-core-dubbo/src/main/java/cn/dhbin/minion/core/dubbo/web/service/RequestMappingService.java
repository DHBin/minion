package cn.dhbin.minion.core.dubbo.web.service;

import cn.dhbin.minion.core.dubbo.web.model.RequestMappingInfo;

import java.util.List;

/**
 * 请求接口
 *
 * @author donghaibin
 * @date 2020/3/14
 */
public interface RequestMappingService {

    String VERSION = "1.0.0";

    /**
     * 获取所有接口信息
     *
     * @return 所有接口信息
     */
    List<RequestMappingInfo> all();

}
