package cn.dhbin.minion.core.restful.log;

import javax.servlet.http.HttpServletRequest;

/**
 * @author donghaibin
 */
public interface ILogHandler {

    /**
     * 请求处理之前
     *
     * @param request 请求
     * @param message the message to log
     */
    void beforeRequest(HttpServletRequest request, String message);

    /**
     * 请求处理之后
     *
     * @param request 请求
     * @param message the message to log
     */
    void afterRequest(HttpServletRequest request, String message);

}
