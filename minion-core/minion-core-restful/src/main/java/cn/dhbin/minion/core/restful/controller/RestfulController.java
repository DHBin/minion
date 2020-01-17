package cn.dhbin.minion.core.restful.controller;

import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.common.response.SuccessResponse;

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

    protected <T> SuccessResponse<T> ok(T object) {
        return ApiResponse.ok(object);
    }

    protected SuccessResponse<Void> ok() {
        return ApiResponse.ok();
    }

    protected <T> SuccessResponse<T> created(T object) {
        return ApiResponse.created(object);
    }

    protected SuccessResponse<Void> created() {
        return ApiResponse.created();
    }

    protected <T> SuccessResponse<T> noContent(T object) {
        return ApiResponse.noContent(object);
    }

    protected SuccessResponse<Void> noContent() {
        return ApiResponse.noContent();
    }

}
