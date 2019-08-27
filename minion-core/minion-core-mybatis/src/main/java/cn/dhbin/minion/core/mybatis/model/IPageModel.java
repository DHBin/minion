package cn.dhbin.minion.core.mybatis.model;

/**
 * 分页模型接口
 *
 * @author donghaibin
 * @date 2019/8/27
 */
public interface IPageModel<T> {

    /**
     * 获取分页大小
     *
     * @return 页大小
     */
    long getSize();

    /**
     * 获取当前页
     *
     * @return 当前页
     */
    long getCurrent();

    /**
     * model -> T
     *
     * @return 转换类型
     */
    T convert();
}
