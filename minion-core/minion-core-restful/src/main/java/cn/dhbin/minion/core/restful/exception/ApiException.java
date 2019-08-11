package cn.dhbin.minion.core.restful.exception;

import cn.dhbin.minion.core.restful.response.IErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
@Getter
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -3217927419037792893L;

    /**
     * 错误码
     */
    private final IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }


    /**
     * 获取ErrorCode
     *
     * @return ErrorCode
     */
    public IErrorCode getErrorCode() {
        return errorCode;
    }

}
