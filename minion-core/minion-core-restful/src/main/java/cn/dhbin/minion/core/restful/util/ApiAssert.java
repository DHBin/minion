package cn.dhbin.minion.core.restful.util;

import cn.dhbin.minion.core.restful.exception.ApiException;
import cn.dhbin.minion.core.restful.response.IErrorCode;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author donghaibin
 * @date 2019-08-10
 */
public class ApiAssert {


    /**
     * obj1 eq obj2
     *
     * @param obj1
     * @param obj2
     * @param errorCode
     */
    public static void equals(IErrorCode errorCode, Object obj1, Object obj2) {
        if (!Objects.equals(obj1, obj2)) {
            failure(errorCode);
        }
    }

    public static void isTrue(IErrorCode errorCode, boolean condition) {
        if (!condition) {
            failure(errorCode);
        }
    }

    public static void isFalse(IErrorCode errorCode, boolean condition) {
        if (condition) {
            failure(errorCode);
        }
    }

    public static void isNull(IErrorCode errorCode, Object... conditions) {
        if (ObjectUtils.allNotNull(conditions)) {
            failure(errorCode);
        }
    }

    public static void notNull(IErrorCode errorCode, Object... conditions) {
        if (!ObjectUtils.allNotNull(conditions)) {
            failure(errorCode);
        }
    }

    /**
     * <p>
     * 失败结果
     * </p>
     *
     * @param errorCode 异常错误码
     */
    public static void failure(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    public static void notEmpty(IErrorCode errorCode, Object[] array) {
        if (ObjectUtils.isEmpty(array)) {
            failure(errorCode);
        }
    }

    /**
     * Assert that an array has no null elements. Note: Does not complain if the
     * array is empty!
     * <p>
     * <pre class="code">
     * Assert.noNullElements(array, &quot;The array must have non-null elements&quot;);
     * </pre>
     *
     * @param array         the array to check
     * @param errorCode the exception message to use if the assertion fails
     * @throws ApiException if the object array contains a {@code null} element
     */
    public static void noNullElements(IErrorCode errorCode, Object[] array) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    failure(errorCode);
                }
            }
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <p>
     * <pre class="code">
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     *
     * @param collection    the collection to check
     * @param errorCode the exception message to use if the assertion fails
     * @throws ApiException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(IErrorCode errorCode, Collection<?> collection) {
        if (CollUtil.isEmpty(collection)) {
            failure(errorCode);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be {@code null} and
     * must have at least one entry.
     * <p>
     * <pre class="code">
     * Assert.notEmpty(map, &quot;Map must have entries&quot;);
     * </pre>
     *
     * @param map           the map to check
     * @param errorCode the exception message to use if the assertion fails
     * @throws ApiException if the map is {@code null} or has no entries
     */
    public static void notEmpty(IErrorCode errorCode, Map<?, ?> map) {
        if (MapUtil.isEmpty(map)) {
            failure(errorCode);
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <p>
     * <pre class="code">
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     *
     * @param collection    the collection to check
     * @param errorCode the exception message to use if the assertion fails
     * @throws cn.dhbin.minion.core.restful.exception.ApiException if the collection is {@code null} or has no elements
     */
    public static void isEmpty(IErrorCode errorCode, Collection<?> collection) {
        if (CollUtil.isNotEmpty(collection)) {
            failure(errorCode);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be {@code null} and
     * must have at least one entry.
     * <p>
     * <pre class="code">
     * Assert.notEmpty(map, &quot;Map must have entries&quot;);
     * </pre>
     *
     * @param map           the map to check
     * @param errorCode the exception message to use if the assertion fails
     * @throws ApiException if the map is {@code null} or has no entries
     */
    public static void isEmpty(IErrorCode errorCode, Map<?, ?> map) {
        if (CollUtil.isNotEmpty(map)) {
            failure(errorCode);
        }
    }

}
