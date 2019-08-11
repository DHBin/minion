package cn.dhbin.minion.core.restful.util;

import cn.dhbin.minion.core.restful.exception.FrameworkException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonUtils {

    private final static ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = initObjectMapper();
    }

    /**
     * 转换Json
     *
     * @param object o
     * @return json字符串
     */
    public static String toJson(Object object) {
        if (isCharSequence(object)) {
            return (String) object;
        }
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new FrameworkException(e);
        }
    }

    /**
     * 获取ObjectMapper
     *
     * @return ObjectMapper
     */
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * 初始化 ObjectMapper
     *
     * @return ObjectMapper
     */
    public static ObjectMapper initObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .featuresToEnable(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
                .featuresToEnable(MapperFeature.PROPAGATE_TRANSIENT_MARKER)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .createXmlMapper(false)
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")))
                .serializerByType(Long.class, ToStringSerializer.instance)
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")))
                .serializerByType(Long.class, ToStringSerializer.instance)
                .modules(
                        new JavaTimeModule(),
                        new ParameterNamesModule(),
                        new Jdk8Module()
                ).build();
    }

    /**
     * 包装 MappingJackson2HttpMessageConverter
     */
    public static Consumer<HttpMessageConverter<?>> wrapperObjectMapper() {
        return converter -> {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter httpMessageConverter = (MappingJackson2HttpMessageConverter) converter;
                httpMessageConverter.setObjectMapper(initObjectMapper());
            }
        };
    }

    /**
     * <p>
     * 是否为CharSequence类型
     * </p>
     *
     * @param object o
     * @return bool
     */
    public static Boolean isCharSequence(Object object) {
        return !Objects.isNull(object) && object.getClass().equals(CharSequence.class);
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json json字符串
     * @return 对象
     */
    public static Object parse(String json) {
        Object object = null;
        try {
            object = getObjectMapper().readValue(json, Object.class);
        } catch (Exception ignored) {
        }
        return object;
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json  json字符串
     * @param clazz 转换的对象Class
     * @param <T>   转换的对象类型
     * @return 对象
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        T t = null;
        try {
            t = getObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * Json转换为对象 转换失败返回null
     *
     * @param json         json字符串
     * @param valueTypeRef valueTypeRef
     * @param <T>          转换的对象类型
     * @return 对象
     */
    public static <T> T readValue(String json, TypeReference valueTypeRef) {
        T t = null;
        try {
            t = getObjectMapper().readValue(json, valueTypeRef);
        } catch (Exception ignored) {
        }
        return t;
    }

}
