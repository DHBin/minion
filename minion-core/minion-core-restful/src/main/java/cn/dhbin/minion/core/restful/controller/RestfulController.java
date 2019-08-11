package cn.dhbin.minion.core.restful.controller;

import cn.dhbin.minion.core.restful.response.ApiResponse;
import cn.dhbin.minion.core.restful.response.FailResponse;
import cn.dhbin.minion.core.restful.response.IErrorCode;
import cn.dhbin.minion.core.restful.response.SuccessResponse;

import java.time.LocalDateTime;

/**
 * Restful Controller
 *
 * @author donghaibin
 * @date 2019-08-10
 */
public class RestfulController {

    protected <T> SuccessResponse<T> success(T object) {
        return SuccessResponse.<T>builder()
                .status(0)
                .result(object)
                .build();
    }

}
