package cn.dhbin.minion.core.common.model;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/5/1
 */
@Data
@Accessors(chain = true)
public class Page<T> implements Convert {

    private static final long serialVersionUID = -5919346434805713208L;


    private Integer size;

    private Integer current;

    private Integer total;

    private List<T> records;

    @SuppressWarnings("unchecked")
    public <R> Page<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getRecords().stream().map(mapper).collect(Collectors.toList());
        ((Page<R>) this).setRecords(collect);
        return (Page<R>) this;
    }

}
