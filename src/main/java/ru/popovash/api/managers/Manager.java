package ru.popovash.api.managers;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Manager<T extends Item> {
    private final Map<String, T> items;
    @Getter
    @Setter
    protected T select;

    public Manager() {
        items = new ConcurrentHashMap<>();
        load();
        select = getDefaultItem();
    }

    protected abstract void load();

    public void loadItem(@NonNull T item) {
        items.put(item.getName(), item);
    }

    public @NonNull Map<String, T> getItems() {
        return items;
    }

    public abstract T getDefaultItem();

    public T getItem(@NonNull String name) {
        return items.get(name);
    }
}
