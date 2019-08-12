package cn.dhbin.minion.core.restful.controller;

import cn.dhbin.minion.core.restful.response.ApiResponse;
import cn.dhbin.minion.core.restful.response.SuccessResponse;

/**
 * Restful Controller
 *
 * @author donghaibin
 * @date 2019-08-10
 */
public class RestfulController {

    protected <T> SuccessResponse<T> success(T object) {
        return ApiResponse.success(object);
    }

    protected SuccessResponse<Void> success() {
        return ApiResponse.success(null);
    }

}
