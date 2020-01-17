package cn.dhbin.minion.core.common.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 失败响应模型
 *
 * @author donghaibin
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FailResponse<T> extends ApiResponse<T> {

    private static final long serialVersionUID = -370100022512444057L;

    /**
     * http 状态码
     */
    private Integer status;
    /**
     * 错误描述
     */
    private String msg;

    private String exception;

    /**
     * 当前时间戳
     */
    private LocalDateTime time;

}
