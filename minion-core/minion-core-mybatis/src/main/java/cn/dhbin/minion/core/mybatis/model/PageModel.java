package cn.dhbin.minion.core.mybatis.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.ToString;

/**
 * 分页模型
 *
 * @author donghaibin
 * @date 2019/8/27
 */
@ToString
public class PageModel<T> implements IPageModel<Page<T>> {

    /**
     * 页大小
     */
    private long size = 10;

    /**
     * 当前页
     */
    private long current = 1;

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    @Override
    public Page<T> convert() {
        return new Page<>(current, size);
    }
}
