package cn.dhbin.minion.core.restful.enums;

import cn.dhbin.minion.core.restful.response.FailResponse;
import cn.dhbin.minion.core.restful.response.IErrorCode;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletResponse;

/**
 * @author donghaibin
 */
@RequiredArgsConstructor
public enum ErrorCodeEnum implements IErrorCode<FailResponse> {
    /**
     * 400
     */
    BAD_REQUEST(HttpServletResponse.SC_BAD_REQUEST, true, "请求参数错误或不完整"),
    /**
     * 更新数据失败
     */
    UPDATE_ERROR(HttpServletResponse.SC_BAD_REQUEST, true, "更新失败"),
    /**
     * 新建数据失败
     */
    CREATE_ERROR(HttpServletResponse.SC_BAD_REQUEST, true, "新建失败"),
    /**
     * 删除数据失败
     */
    DELETE_ERROR(HttpServletResponse.SC_BAD_REQUEST, true, "删除失败"),
    /**
     * JSON格式错误
     */
    JSON_FORMAT_ERROR(HttpServletResponse.SC_BAD_REQUEST, true, "JSON格式错误"),
    /**
     * 401
     */
    UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, true, "请先进行认证"),
    /**
     * 403
     */
    FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, true, "无权查看"),
    /**
     * 404
     */
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, true, "未找到该路径"),
    /**
     * 405
     */
    METHOD_NOT_ALLOWED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, true, "请求方式不支持"),
    /**
     * 406
     */
    NOT_ACCEPTABLE(HttpServletResponse.SC_NOT_ACCEPTABLE, true, "不可接受该请求"),
    /**
     * 411
     */
    LENGTH_REQUIRED(HttpServletResponse.SC_LENGTH_REQUIRED, true, "长度受限制"),
    /**
     * 415
     */
    UNSUPPORTED_MEDIA_TYPE(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, true, "不支持的媒体类型"),
    /**
     * 416
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, true, "不能满足请求的范围"),
    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, true, "服务器正在升级，请耐心等待"),
    /**
     * 503
     */
    SERVICE_UNAVAILABLE(HttpServletResponse.SC_SERVICE_UNAVAILABLE, true, "请求超时");

    /**
     * 状态码
     */
    private final Integer status;

    /**
     * 是否显示
     */
    private final Boolean show;

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
    public Boolean isShow() {
        return this.show;
    }

    @Override
    public FailResponse convert() {
        return FailResponse.builder()
                .msg(getMsg())
                .status(getStatus())
                .show(isShow())
                .build();
    }
}
