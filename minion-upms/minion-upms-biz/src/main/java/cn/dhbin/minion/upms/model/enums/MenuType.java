package cn.dhbin.minion.upms.model.enums;

import cn.dhbin.minion.core.common.IEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@RequiredArgsConstructor
@Getter
public enum MenuType implements IEnum<Integer> {

    /**
     * 顶部菜单
     */
    TOP_MENU(1, "顶部菜单"),

    /**
     * 左侧菜单
     */
    MENU(2, "左侧菜单"),

    /**
     * 按钮
     */
    BUTTON(3, "按钮");

    @EnumValue
    private final Integer value;

    @JsonValue
    private final String desc;


}
