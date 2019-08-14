package cn.dhbin.minion.core.restful.response;

import cn.dhbin.minion.core.restful.spring.ApplicationUtils;

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
     * 成功-无特殊含义
     */
    private static final int COMMON_SUCCESS = 0;
    /**
     * 获取数据成功[GET]
     */
    private static final int OK = 200;
    /**
     * 创建或修改数据成功[POST|PUT|PATCH]
     */
    private static final int CREATED = 201;
    /**
     * 删除成功[DELETE]
     */
    private static final int NOT_CONTENT = 204;


    /**
     * 成功
     *
     * @param object 数据
     * @return 响应模型
     */
    public static <T> SuccessResponse<T> success(T object) {
        return success(object, COMMON_SUCCESS);
    }

    /**
     * 成功
     *
     * @param object 数据
     * @param status 状态码
     * @param <T>    数据类型
     * @return 响应模型
     */
    public static <T> SuccessResponse<T> success(T object, int status) {
        return SuccessResponse.<T>builder()
                .status(status)
                .result(object)
                .build();
    }

    /**
     * 200
     *
     * @return 200
     */
    public static SuccessResponse<Void> ok() {
        return ok(null);
    }

    /**
     * 200
     *
     * @param object 数据
     * @param <T>    数据类型
     * @return 200
     */
    public static <T> SuccessResponse<T> ok(T object) {
        return success(object, OK);
    }

    /**
     * 201
     *
     * @return 201
     */
    public static SuccessResponse<Void> created() {
        return created(null);
    }

    /**
     * 201
     *
     * @param object 数据
     * @param <T>    数据类型
     * @return 201
     */
    public static <T> SuccessResponse<T> created(T object) {
        return success(object, CREATED);
    }

    /**
     * 204
     *
     * @return 204
     */
    public static SuccessResponse<Void> noContent() {
        return noContent(null);
    }


    /**
     * 204
     *
     * @param object 数据
     * @param <T>    数据类型
     * @return 204
     */
    public static <T> SuccessResponse<T> noContent(T object) {
        return success(object, NOT_CONTENT);
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
        if (e != null && ApplicationUtils.isDev()) {
            responseBuilder.exception(e.getMessage());
        }
        return responseBuilder.build();
    }
}
