package cn.dhbin.minion.core.restful.response;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 接口响应模型
 *
 * @author donghaibin
 */
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 5464910662322777161L;

    /**
     * 成功
     *
     * @param object 数据
     * @return 响应模型
     */
    public static <T> SuccessResponse<T> success(T object) {
        return SuccessResponse.<T>builder()
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
    public static ApiResponse fail(IErrorCode errorCode) {
        return FailResponse.builder()
                .msg(errorCode.getMsg())
                .status(errorCode.getStatus())
                .time(LocalDateTime.now())
                .show(errorCode.isShow())
                .build();
    }

    /**
     * 失败
     *
     * @param errorCode 错误代码
     * @param e         异常
     * @return 响应模型
     */
    public static ApiResponse fail(IErrorCode errorCode, Exception e) {
        FailResponse.FailResponseBuilder responseBuilder = FailResponse.builder()
                .msg(errorCode.getMsg())
                .status(errorCode.getStatus())
                .time(LocalDateTime.now())
                .show(errorCode.isShow());
        if (e != null) {
            responseBuilder.exception(e.getMessage());
        }
        return responseBuilder.build();
    }
}
