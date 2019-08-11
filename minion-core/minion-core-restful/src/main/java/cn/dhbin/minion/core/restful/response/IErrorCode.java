package cn.dhbin.minion.core.restful.response;

/**
 * 错误代码
 *
 * @author donghaibin
 */
public interface IErrorCode<T> {

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getStatus();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMsg();

    /**
     * 是否显示在前端
     *
     * @return 是否显示
     */
    Boolean isShow();

    /**
     * 转换实体对象
     *
     * @return T
     */
    T convert();
}
