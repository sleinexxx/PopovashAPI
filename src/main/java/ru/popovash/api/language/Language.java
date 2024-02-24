package ru.popovash.api.language;

import lombok.NonNull;

public interface Language {
    @NonNull String getName();

    @NonNull String getLocalizedName();

    double getVersion();

    @NonNull String getMessage(@NonNull String key);
}
