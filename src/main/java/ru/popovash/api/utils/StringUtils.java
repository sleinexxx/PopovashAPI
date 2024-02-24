package ru.popovash.api.utils;

import lombok.NonNull;

import java.io.ByteArrayOutputStream;

public class StringUtils {
    public static @NonNull String getString(@NonNull String[] args, @NonNull String delimiter) {
        int size = 0;
        StringBuilder string = new StringBuilder();
        for (String arg : args) {
            if (size > 0) {
                string.append(delimiter);
            }
            string.append(arg);
            size++;
        }
        return string.toString();
    }

    public static @NonNull String getString(@NonNull String[] args, @NonNull String delimiter, int start) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i >= start) {
                if (i > start) {
                    string.append(delimiter);
                }
                string.append(args[i]);
            }
        }
        return string.toString();
    }

    public static boolean startsWithIgnoreCase(@NonNull String text, @NonNull String startsWith) {
        return text.toLowerCase().startsWith(startsWith.toLowerCase());
    }

    public static boolean endsWithIgnoreCase(@NonNull String text, @NonNull String endsWith) {
        return text.toLowerCase().endsWith(endsWith.toLowerCase());
    }

    public static byte[] stringArToByteAr(@NonNull String... strAr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (String string : strAr) {
            byteArrayOutputStream.writeBytes(string.getBytes());
            byteArrayOutputStream.writeBytes(System.lineSeparator().getBytes());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean isInt(@NonNull String type) {
        try {
            int iType = Integer.parseInt(type);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isLong(@NonNull String type) {
        try {
            long l = Long.parseLong(type);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(@NonNull String type) {
        try {
            double d = Double.parseDouble(type);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(@NonNull String type) {
        try {
            float f = Float.parseFloat(type);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
