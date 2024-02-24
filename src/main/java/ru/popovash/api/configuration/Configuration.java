package ru.popovash.api.configuration;

import lombok.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Configuration {
    @NonNull Set<String> getKeys();

    @NonNull Collection<Object> getValues();

    @NonNull Map<String, Object> get();

    boolean containsKey(@NonNull String key);

    Object get(@NonNull String key);

    <T> T getOrDef(@NonNull String key, T def);

    String getString(@NonNull String key);

    boolean isString(@NonNull String key);

    int getInt(@NonNull String key);

    boolean isInt(@NonNull String key);

    boolean getBoolean(@NonNull String key);

    boolean isBoolean(@NonNull String key);

    double getDouble(@NonNull String key);

    boolean isDouble(@NonNull String key);

    long getLong(@NonNull String key);

    boolean isLong(@NonNull String key);

    List<?> getList(@NonNull String key);

    boolean isList(@NonNull String key);

    List<String> getStringList(@NonNull String key);

    List<Integer> getIntegerList(@NonNull String key);

    void set(@NonNull String key, Object obj);
}
