package cn.dhbin.minion.core.restful.response;

import lombok.*;

/**
 * 成功响应模型
 *
 * @author donghaibin
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SuccessResponse<T> extends ApiResponse<T> {

    private static final long serialVersionUID = -5169649996163409698L;


    /**
     * 状态码
     */
    private Integer status;

    /**
     * 实体数据
     */
    private T result;

}
