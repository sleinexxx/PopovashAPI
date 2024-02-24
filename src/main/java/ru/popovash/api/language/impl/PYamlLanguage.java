package ru.popovash.api.language.impl;

import lombok.NonNull;
import ru.popovash.api.language.PLanguage;
import ru.popovash.api.language.config.YamlLanguage;

import java.io.DataInput;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class PYamlLanguage extends YamlLanguage implements PLanguage {
    public PYamlLanguage(@NonNull File readFrom) {
        super(readFrom);
    }

    public PYamlLanguage(@NonNull URL readFrom) {
        super(readFrom);
    }

    public PYamlLanguage(@NonNull Reader readFrom) {
        super(readFrom);
    }

    public PYamlLanguage(@NonNull InputStream readFrom) {
        super(readFrom);
    }

    public PYamlLanguage(@NonNull DataInput readFrom) {
        super(readFrom);
    }

    public PYamlLanguage(@NonNull byte[] readFrom) {
        super(readFrom);
    }
}
