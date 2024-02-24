package ru.popovash.api.configuration;

import lombok.NonNull;
import ru.popovash.api.utils.StringUtils;

import java.util.*;

public abstract class AbstractConfiguration implements Configuration {
    protected LinkedHashMap<String, Object> map;

    public AbstractConfiguration() {
        map = new LinkedHashMap<>();
    }

    @Override
    public @NonNull Set<String> getKeys() {
        return map.keySet();
    }

    @Override
    public @NonNull Collection<Object> getValues() {
        return map.values();
    }

    @Override
    public @NonNull Map<String, Object> get() {
        return map;
    }

    @Override
    public boolean containsKey(@NonNull String key) {
        return map.containsKey(key);
    }

    @Override
    public Object get(@NonNull String key) {
        return map.getOrDefault(key, null);
    }

    @Override
    public <T> T getOrDef(@NonNull String key, T def) {
        return (T) map.getOrDefault(key, def);
    }

    @Override
    public String getString(@NonNull String key) {
        return (String) map.get(key);
    }

    @Override
    public boolean isString(@NonNull String key) {
        return true;
    }

    @Override
    public int getInt(@NonNull String key) {
        return (int) map.get(key);
    }

    @Override
    public boolean isInt(@NonNull String key) {
        return StringUtils.isInt(getString(key));
    }

    @Override
    public boolean getBoolean(@NonNull String key) {
        return (boolean) map.get(key);
    }

    @Override
    public boolean isBoolean(@NonNull String key) {
        try {
            getBoolean(key);
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    @Override
    public double getDouble(@NonNull String key) {
        return (double) map.get(key);
    }

    @Override
    public boolean isDouble(@NonNull String key) {
        return StringUtils.isDouble(getString(key));
    }

    @Override
    public long getLong(@NonNull String key) {
        return (long) map.get(key);
    }

    @Override
    public boolean isLong(@NonNull String key) {
        return StringUtils.isLong(getString(key));
    }

    @Override
    public List<?> getList(@NonNull String key) {
        return (List<?>) map.get(key);
    }

    @Override
    public boolean isList(@NonNull String key) {
        try {
            getList(key);
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getStringList(@NonNull String key) {
        return (List<String>) map.get(key);
    }

    @Override
    public List<Integer> getIntegerList(@NonNull String key) {
        return (List<Integer>) map.get(key);
    }

    @Override
    public void set(@NonNull String key, Object obj) {
        if (obj == null) {
            map.remove(key);
        } else {
            map.put(key, obj);
        }
    }
}
