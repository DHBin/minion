package cn.dhbin.minion.core.restful.wrapper;

import cn.dhbin.minion.core.restful.response.ApiResponse;
import cn.dhbin.minion.core.restful.response.IErrorCode;
import cn.dhbin.minion.core.restful.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * http Response
 *
 * @author donghaibin
 * @date 2019-08-10
 */
@Slf4j
public class ResponseWrapper extends HttpServletResponseWrapper {

    private IErrorCode errorCode;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ResponseWrapper(HttpServletResponse response, IErrorCode errorCode) {
        super(response);
        setErrorCode(errorCode);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

    private void setErrorCode(IErrorCode errorCode) {
        if (Objects.nonNull(errorCode)) {
            this.errorCode = errorCode;
            // 默认返回200
            super.setStatus(HttpServletResponse.SC_OK);
        }
    }

    /**
     * 异常输出
     *
     * @param e 异常
     */
    public void writeErrorMsg(Exception e) {
        if (Objects.isNull(errorCode)) {
            log.warn("Warn: ErrorCodeEnum cannot be null, Skip the implementation of the method.");
            return;
        }
        writeValueAsJson(ApiResponse.fail(this.errorCode));
    }

    /**
     * 向外输出json对象
     *
     * @param obj 输出的对象
     */
    public void writeValueAsJson(Object obj) {
        if (super.isCommitted()) {
            log.warn("Warn: Response isCommitted, Skip the implementation of the method.");
            return;
        }
        super.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        super.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = super.getWriter()) {
            writer.print(JacksonUtils.toJson(obj));
            writer.flush();
        } catch (IOException e) {
            log.warn("Error: Response printJson failed, stackTrace: ", e.fillInStackTrace());
        }
    }

}
