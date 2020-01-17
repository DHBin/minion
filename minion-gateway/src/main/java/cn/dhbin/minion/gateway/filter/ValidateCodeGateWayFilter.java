package cn.dhbin.minion.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * 拦截授权url，判断验证码是否正确
 *
 * @author donghaibin
 * @date 2020/1/17
 */
@Component
public class ValidateCodeGateWayFilter extends AbstractGatewayFilterFactory<Object> {

    /**
     * @param config 不需要配置
     * @return GatewayFilter
     */
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }

}
