package ru.popovash.api.configuration.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.popovash.api.configuration.AbstractConfiguration;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;

public class YamlConfiguration extends AbstractConfiguration {
    @SneakyThrows
    public YamlConfiguration(@NonNull File readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public YamlConfiguration(@NonNull URL readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public YamlConfiguration(@NonNull Reader readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public YamlConfiguration(@NonNull InputStream readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public YamlConfiguration(@NonNull DataInput readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public YamlConfiguration(@NonNull byte[] readFrom) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            map = objectMapper.readValue(readFrom, LinkedHashMap.class);
        } catch (MismatchedInputException e) {

        }
    }

    @SneakyThrows
    public static void save(@NonNull YamlConfiguration configuration, @NonNull File saveTo) {
        new ObjectMapper(new YAMLFactory()).writeValue(saveTo, configuration.map);
    }

    @SneakyThrows
    public static void save(@NonNull YamlConfiguration configuration, @NonNull DataOutput saveTo) {
        new ObjectMapper(new YAMLFactory()).writeValue(saveTo, configuration.map);
    }

    @SneakyThrows
    public static void save(@NonNull YamlConfiguration configuration, @NonNull Writer saveTo) {
        new ObjectMapper(new YAMLFactory()).writeValue(saveTo, configuration.map);
    }

    @SneakyThrows
    public static void save(@NonNull YamlConfiguration configuration, @NonNull OutputStream saveTo) {
        new ObjectMapper(new YAMLFactory()).writeValue(saveTo, configuration.map);
    }
}
