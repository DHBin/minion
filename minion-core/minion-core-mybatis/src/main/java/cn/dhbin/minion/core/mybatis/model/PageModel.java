package cn.dhbin.minion.core.mybatis.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.ToString;

/**
 * 分页模型
 *
 * @author donghaibin
 * @date 2019/8/27
 */
@ToString
@Data
public class PageModel<T> implements IPageModel<Page<T>> {

    /**
     * 页大小
     */
    private Integer size = 10;

    /**
     * 当前页
     */
    private Integer current = 1;


    @Override
    public Page<T> convert() {
        return new Page<>(current, size);
    }
}
