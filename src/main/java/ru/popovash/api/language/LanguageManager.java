package ru.popovash.api.language;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class LanguageManager<T extends Language> {
    private Map<String, T> languages;
    @Getter @Setter
    protected Language selectLanguage;

    public LanguageManager() {
        languages = new ConcurrentHashMap<>();
        loadLanguages();
    }

    protected abstract void loadLanguages();

    public void loadLanguage(@NonNull T language) {
        languages.put(language.getName(), language);
    }

    public @NonNull Map<String, T> getLanguages() {
        return languages;
    }

    public Language getDefaultLanguage() {
        return getLanguage(System.getProperty("user.language").toUpperCase());
    }

    public Language getLanguage(@NonNull String name) {
        return languages.get(name);
    }
}
