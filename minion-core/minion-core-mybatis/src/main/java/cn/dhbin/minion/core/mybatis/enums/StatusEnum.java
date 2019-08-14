package cn.dhbin.minion.core.mybatis.enums;

import cn.dhbin.minion.core.tool.common.enums.IEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
@RequiredArgsConstructor
@Getter
public enum StatusEnum implements IEnum<Integer> {

    /**
     * 禁用
     */
    DISABLE(0, "禁用"),

    /**
     * 正常
     */
    NORMAL(1, "正常");

    @EnumValue
    private final Integer status;

    @JsonValue
    private final String msg;


    @Override
    public Integer getValue() {
        return this.status;
    }


}
