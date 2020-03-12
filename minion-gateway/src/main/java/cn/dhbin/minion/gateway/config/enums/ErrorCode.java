package cn.dhbin.minion.gateway.config.enums;

import cn.dhbin.minion.core.common.response.IErrorCode;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2020/1/18
 */
@RequiredArgsConstructor
public enum ErrorCode implements IErrorCode<Object> {

    /**
     * 验证码为空
     */
    CODE_IS_BLACK(101_001_01, "验证码为空"),

    /**
     * 验证码错误
     */
    CODE_ILLEGAL(101_001_02, "验证码错误");

    private final Integer status;

    private final String msg;


    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Object convert() {
        return null;
    }
}
