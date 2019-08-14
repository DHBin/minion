package cn.dhbin.minion.core.restful.spring;

import cn.dhbin.minion.core.common.IEnum;
import cn.hutool.core.convert.Convert;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
public class IEnumConverterFactory implements ConverterFactory<String, IEnum> {

    /**
     * WeakHashMap 是一个散列表，它存储的内容也是键值对(key-value)映射，而且键和值都可以是null。
     * WeakHashMap的键是“弱键”。在WeakHashMap 中，当某个键不再正常使用时，会被从WeakHashMap中被自动移除。
     * 更精确地说，对于一个给定的键，其映射的存在并不阻止垃圾回收器对该键的丢弃，这就使该键成为可终止的，被终止，然后被回收。
     * 某个键被终止时，它对应的键值对也就从映射中有效地移除了。
     */
    private static final Map<Class, Converter> CONVERTER_MAP = new WeakHashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = CONVERTER_MAP.get(targetType);
        if (Objects.isNull(result)) {
            result = new IntegerStrToEnum<>(targetType);
            CONVERTER_MAP.put(targetType, result);
        }
        return result;
    }

    static class IntegerStrToEnum<T extends IEnum> implements Converter<String, T> {

        private final Map<String, T> enumMap = new HashMap<>();

        IntegerStrToEnum(Class<T> enumType) {
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                enumMap.put(Convert.toStr(e.getValue()), e);
            }
        }

        @Override
        public T convert(String source) {
            T result = enumMap.get(source);
            if (result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}