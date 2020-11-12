package com.shunteng.test05;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Function;

/**
 * @Description 判断vo，构造params
 * @Author GCL
 * @Date 2020/11/5 下午4:48
 */
public class OptionalUtils<T> {

    private static final OptionalUtils<?> EMPTY = new OptionalUtils<>();

    private final T value;

    private OptionalUtils(T value) {
        this.value = Objects.requireNonNull(value);
    }

    private OptionalUtils() {
        this.value = null;
    }

    public boolean isPresent() {
        return value != null;
    }

    public static <T> OptionalUtils<T> ofNullable(T value) {
        return value == null ? empty() : (StringUtils.isNotBlank(value.toString()) ? of(value) : empty());
    }

    public static <T> OptionalUtils<T> of(T value) {
        return new OptionalUtils<>(value);
    }

    public static <T> OptionalUtils<T> empty() {
        @SuppressWarnings("unchecked")
        OptionalUtils<T> t = (OptionalUtils<T>) EMPTY;
        return t;
    }

    public <U> void map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (isPresent()) {
            OptionalUtils.ofNullable(mapper.apply(value));
        }
    }

}