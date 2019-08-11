package cn.dhbin.minion.core.restful.log;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认日志处理
 *
 * @author donghaibin
 * @date 2019-08-10
 */
@Slf4j
public class DefaultLogHandler implements ILogHandler {


    @Override
    public void beforeRequest(HttpServletRequest request, String message) {
        log.info(message);
    }

    @Override
    public void afterRequest(HttpServletRequest request, String message) {
        log.info(message);
    }
}
