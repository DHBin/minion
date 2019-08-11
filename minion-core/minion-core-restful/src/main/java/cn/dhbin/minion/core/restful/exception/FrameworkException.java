package cn.dhbin.minion.core.restful.exception;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
public class FrameworkException extends RuntimeException {


    private static final long serialVersionUID = 8494607405174661148L;

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(Throwable throwable) {
        super(throwable);
    }

    public FrameworkException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
