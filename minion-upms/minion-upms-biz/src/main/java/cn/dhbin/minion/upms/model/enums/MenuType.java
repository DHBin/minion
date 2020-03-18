package cn.dhbin.minion.upms.model.enums;

import cn.dhbin.minion.core.common.IEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
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
    MENU(2, "左侧菜单");

    @EnumValue
    private final Integer value;

    private final String desc;


}
