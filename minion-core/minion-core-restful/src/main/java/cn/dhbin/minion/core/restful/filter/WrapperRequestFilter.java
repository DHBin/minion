package cn.dhbin.minion.core.restful.filter;

import cn.dhbin.minion.core.restful.config.props.LogConfigProperties;
import cn.dhbin.minion.core.restful.log.ILogHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
@RequiredArgsConstructor
public class WrapperRequestFilter extends AbstractRequestLoggingFilter {

    private final ILogHandler logHandler;
    private final LogConfigProperties logConfigProperties;

    @PostConstruct
    public void init() {
        setIncludeClientInfo(logConfigProperties.getIncludeClientInfo());
        setIncludeQueryString(logConfigProperties.getIncludeQueryString());
        setIncludeHeaders(logConfigProperties.getIncludeHeaders());
        setIncludePayload(logConfigProperties.getIncludePayload());
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logHandler.beforeRequest(request, message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        logHandler.afterRequest(request, message);
    }

}
