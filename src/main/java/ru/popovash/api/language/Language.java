package ru.popovash.api.language;

import lombok.NonNull;
import ru.popovash.api.managers.Item;

public interface Language extends Item {
    @NonNull String getLocalizedName();

    double getVersion();

    @NonNull String getMessage(@NonNull String key);
}
