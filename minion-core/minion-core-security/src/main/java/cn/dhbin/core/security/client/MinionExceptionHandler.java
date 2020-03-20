package cn.dhbin.core.security.client;

import cn.dhbin.minion.core.common.enums.ErrorCodeEnum;
import cn.dhbin.minion.core.common.response.ApiResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author donghaibin
 * @date 2020/3/21
 */
@RestControllerAdvice
@Component
public class MinionExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ApiResponse<?> handleAccessDeniedException() {
        return ApiResponse.fail(ErrorCodeEnum.FORBIDDEN);
    }
}
