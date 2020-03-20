package cn.dhbin.minion.core.common.enums;

import cn.dhbin.minion.core.common.response.FailResponse;
import cn.dhbin.minion.core.common.response.IErrorCode;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 */
@RequiredArgsConstructor
public enum ErrorCodeEnum implements IErrorCode<FailResponse<?>> {
    /**
     * 400
     */
    BAD_REQUEST(400, "请求参数错误或不完整"),
    /**
     * 更新数据失败
     */
    UPDATE_ERROR(400, "更新失败"),
    /**
     * 新建数据失败
     */
    CREATE_ERROR(400, "新建失败"),
    /**
     * 删除数据失败
     */
    DELETE_ERROR(400, "删除失败"),
    /**
     * JSON格式错误
     */
    JSON_FORMAT_ERROR(400, "JSON格式错误"),
    /**
     * 401
     */
    UNAUTHORIZED(401, "请先进行认证"),
    /**
     * 403
     */
    FORBIDDEN(403, "无权查看"),
    /**
     * 404
     */
    NOT_FOUND(404, "未找到该路径"),
    /**
     * 405
     */
    METHOD_NOT_ALLOWED(405, "请求方式不支持"),
    /**
     * 406
     */
    NOT_ACCEPTABLE(406, "不可接受该请求"),
    /**
     * 411
     */
    LENGTH_REQUIRED(411, "长度受限制"),
    /**
     * 415
     */
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    /**
     * 416
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "不能满足请求的范围"),
    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(500, "服务器正在升级，请耐心等待"),
    /**
     * 503
     */
    SERVICE_UNAVAILABLE(503, "请求超时");

    /**
     * 状态码
     */
    private final Integer status;

    /**
     * 错误信息
     */
    private final String msg;

    @Override
    public Integer getStatus() {
        return this.status;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public FailResponse<?> convert() {
        return FailResponse.builder()
                .msg(getMsg())
                .status(getStatus())
                .build();
    }
}
