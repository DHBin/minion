package cn.dhbin.minion.core.tool.mvc;

/**
 * 错误代码
 *
 * @author donghaibin
 */
public interface IErrorCode {

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
}
