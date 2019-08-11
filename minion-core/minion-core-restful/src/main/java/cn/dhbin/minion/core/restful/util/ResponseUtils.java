package cn.dhbin.minion.core.restful.util;

import cn.dhbin.minion.core.restful.enums.ErrorCodeEnum;
import cn.dhbin.minion.core.restful.response.ApiResponse;
import cn.dhbin.minion.core.restful.response.FailResponse;
import cn.dhbin.minion.core.restful.response.IErrorCode;
import cn.dhbin.minion.core.restful.wrapper.ResponseWrapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ResponseUtils {

    /**
     * Portal输出json字符串
     *
     * @param response http响应
     * @param obj      需要转换JSON的对象
     */
    public static void writeValAsJson(HttpServletRequest request, ResponseWrapper response, Object obj) {
        if (!ObjectUtils.isEmpty(response) && !ObjectUtils.isEmpty(obj)) {
            response.writeValueAsJson(obj);
        }
    }

    /**
     * 获取异常信息
     *
     * @param exception 异常
     * @return {@link FailResponse}
     */
    public static FailResponse.FailResponseBuilder exceptionMsg(FailResponse.FailResponseBuilder failResponseBuilder, Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            StringBuilder builder = new StringBuilder("校验失败:");
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
            allErrors.stream().findFirst().ifPresent(error -> {
                builder.append(((FieldError) error).getField()).append("字段规则为").append(error.getDefaultMessage());
                failResponseBuilder.msg(error.getDefaultMessage());
            });
            failResponseBuilder.exception(builder.toString());
            return failResponseBuilder;
        } else if (exception instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException ex = (MissingServletRequestParameterException) exception;
            String builder = "参数字段" + ex.getParameterName() + "校验不通过";
            failResponseBuilder.exception(builder).msg(ex.getMessage());
            return failResponseBuilder;
        } else if (exception instanceof MissingPathVariableException) {
            MissingPathVariableException ex = (MissingPathVariableException) exception;
            String builder = "路径字段" + ex.getVariableName() + "校验不通过";
            failResponseBuilder.exception(builder).msg(ex.getMessage());
            return failResponseBuilder;
        } else if (exception instanceof ConstraintViolationException) {
            StringBuilder builder = new StringBuilder("方法.参数字段");
            ConstraintViolationException ex = (ConstraintViolationException) exception;
            Optional<ConstraintViolation<?>> first = ex.getConstraintViolations().stream().findFirst();
            if (first.isPresent()) {
                ConstraintViolation<?> constraintViolation = first.get();
                builder.append(constraintViolation.getPropertyPath().toString());
                builder.append("校验不通过");
                failResponseBuilder.exception(builder.toString()).msg(constraintViolation.getMessage());
            }
            return failResponseBuilder;
        }
        // 默认情况不返回exception信息
        failResponseBuilder.exception("");
        return failResponseBuilder;
    }


    /**
     * 发送错误信息
     *
     * @param request  请求
     * @param response 响应
     * @param code     错误代码
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, IErrorCode code) {
        sendFail(request, getWrapper(response, code), code, null);
    }

    public static void sendFail(HttpServletRequest request, HttpServletResponse response, IErrorCode code, Exception ex) {
        ResponseUtils.writeValAsJson(request, getWrapper(response, code), ApiResponse.fail(code, ex));
    }

    /**
     * 获取Response
     *
     * @return wrapper
     */
    public static ResponseWrapper getWrapper(HttpServletResponse response, IErrorCode errorCode) {
        return new ResponseWrapper(response, errorCode);
    }
}
