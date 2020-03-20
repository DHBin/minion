package cn.dhbin.minion.upms.model.enums;

import cn.dhbin.minion.core.common.response.IErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@RequiredArgsConstructor
@Getter
public enum ErrorCode implements IErrorCode<Object> {

    /**
     * 用户已存在
     */
    USERNAME_EXITED(10_00_01, "用户已存在");

    private final Integer status;

    private final String msg;


    @Override
    public Object convert() {
        return null;
    }
}
