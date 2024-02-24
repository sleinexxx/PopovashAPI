package ru.popovash.api.utils;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    @SneakyThrows
    public static byte[] readFileBytes(@NonNull File file) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = bufferedInputStream.readAllBytes();
        bufferedInputStream.close();
        return bytes;
    }

    public static @NonNull List<String> readFileText(@NonNull File file) {
        List<String> stringAr = new ArrayList<>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : readFileBytes(file)) {
            if (b == '\n') {
                stringAr.add(byteArrayOutputStream.toString());
                byteArrayOutputStream.reset();
                continue;
            }
            byteArrayOutputStream.write(b);
        }
        return stringAr;
    }

    public static @NonNull FileWriter getFileWriter(@NonNull File file) {
        return new FileWriter(file);
    }

    public static @NonNull FileWriter getFileWriter(@NonNull File dir, @NonNull String file) {
        return new FileWriter(new File(dir, file));
    }

    public static @NonNull FileWriter getFileWriter(@NonNull URI uri) {
        return new FileWriter(new File(uri));
    }

    public static @NonNull FileWriter getFileWriter(@NonNull String file) {
        return new FileWriter(new File(file));
    }

    public static class FileWriter {
        private final File file;
        private final ByteArrayOutputStream outputStream;

        private FileWriter(File file) {
            this.file = file;
            outputStream = new ByteArrayOutputStream();
        }

        @SneakyThrows
        public FileWriter writeOld() {
            return write(FileUtils.readFileBytes(file));
        }

        @SneakyThrows
        public FileWriter createIfNotExists() {
            if (!file.exists()) {
                File parent = file.getParentFile();
                if (parent != null) parent.mkdirs();
                file.createNewFile();
            }
            return this;
        }

        @SneakyThrows
        public @NonNull File writeToFile() {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(outputStream.toByteArray());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return file;
        }

        @SneakyThrows
        public @NonNull FileWriter append(@NonNull String text) {
            return write(text.getBytes());
        }

        @SneakyThrows
        public @NonNull FileWriter write(@NonNull String... text) {
            return write(StringUtils.stringArToByteAr(text));
        }

        @SneakyThrows
        public @NonNull FileWriter write(@NonNull List<String> lines) {
            return write(lines.toArray(new String[0]));
        }

        @SneakyThrows
        public @NonNull FileWriter write(int b) {
            outputStream.write(b);
            return this;
        }

        @SneakyThrows
        public @NonNull FileWriter write(@NonNull byte[] bytes, int off, int len) {
            outputStream.write(bytes, off, len);
            return this;
        }

        @SneakyThrows
        public @NonNull FileWriter write(@NonNull byte[] bytes) {
            outputStream.write(bytes);
            return this;
        }
    }
}
