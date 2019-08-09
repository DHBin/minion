package cn.dhbin.minion.core.tool.mvc;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 接口响应模型
 *
 * @author donghaibin
 */
public interface ApiResponse<T> extends Serializable {

    /**
     * 成功
     *
     * @param object 数据
     * @return 响应模型
     */
    default ApiResponse success(T object) {
        return SuccessResponse.builder()
                .status(0)
                .result(object)
                .build();
    }

    /**
     * 失败
     *
     * @param errorCode 错误代码
     * @return 响应模型
     */
    default ApiResponse fail(IErrorCode errorCode) {
        return FailResponse.builder()
                .msg(errorCode.getMsg())
                .status(errorCode.getStatus())
                .time(LocalDateTime.now())
                .show(errorCode.isShow())
                .build();
    }
}
