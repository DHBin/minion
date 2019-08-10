package cn.dhbin.minion.core.tool.converter;

import cn.dhbin.minion.core.tool.modelmapper.jdk8.Jdk8Module;
import cn.dhbin.minion.core.tool.modelmapper.jsr310.Jsr310Module;
import cn.dhbin.minion.core.tool.modelmapper.jsr310.Jsr310ModuleConfig;
import cn.hutool.core.collection.CollUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换工具类
 *
 * @author Caratacus
 */
public class BeanConverter {

    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
        Jsr310ModuleConfig config = Jsr310ModuleConfig.builder()
                // default is yyyy-MM-dd HH:mm:ss
                .dateTimePattern("yyyy-MM-dd HH:mm:ss")
                // default is yyyy-MM-dd
                .datePattern("yyyy-MM-dd")
                // default is ZoneId.systemDefault()
                .zoneId(ZoneOffset.UTC)
                .build();
        MODEL_MAPPER.registerModule(new Jsr310Module(config)).registerModule(new Jdk8Module());
        MODEL_MAPPER.getConfiguration().setFullTypeMatchingRequired(true);
        MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * 获取 modelMapper
     *
     * @return modelMapper
     */
    public static ModelMapper getModelMapper() {
        return MODEL_MAPPER;
    }


    /**
     * 列表转换
     *
     * @param clazz the clazz
     * @param list  the list
     */
    public static <T> List<T> convert(Class<T> clazz, List<?> list) {
        return CollUtil.isEmpty(list) ? Collections.emptyList() : list.stream().map(e -> convert(clazz, e)).collect(Collectors.toList());
    }

    /**
     * 单个对象转换
     *
     * @param targetClass 目标对象
     * @param source      源对象
     * @return 转换后的目标对象
     */
    public static <T> T convert(Class<T> targetClass, Object source) {
        return getModelMapper().map(source, targetClass);
    }

}
