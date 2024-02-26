package ru.popovash.api.language;

import ru.popovash.api.managers.Manager;

public abstract class LanguageManager<T extends Language> extends Manager<T> {
    @Override
    public T getDefaultItem() {
        return getItem(System.getProperty("user.language").toUpperCase());
    }
}
