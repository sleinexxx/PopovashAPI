package ru.popovash.api.language.config;

import lombok.NonNull;
import ru.popovash.api.configuration.yaml.YamlConfiguration;
import ru.popovash.api.language.Language;

import java.io.DataInput;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class YamlLanguage extends YamlConfiguration implements Language {
    public YamlLanguage(@NonNull File readFrom) {
        super(readFrom);
    }

    public YamlLanguage(@NonNull URL readFrom) {
        super(readFrom);
    }

    public YamlLanguage(@NonNull Reader readFrom) {
        super(readFrom);
    }

    public YamlLanguage(@NonNull InputStream readFrom) {
        super(readFrom);
    }

    public YamlLanguage(@NonNull DataInput readFrom) {
        super(readFrom);
    }

    public YamlLanguage(@NonNull byte[] readFrom) {
        super(readFrom);
    }

    @Override
    public @NonNull String getName() {
        return getMessage("NAME");
    }

    @Override
    public @NonNull String getLocalizedName() {
        return getMessage("LOCALIZED_NAME");
    }

    @Override
    public double getVersion() {
        return getDouble("VERSION");
    }

    @Override
    public @NonNull String getMessage(@NonNull String key) {
        return getOrDef(key, "Сообщение " + key + " не найдено");
    }
}
