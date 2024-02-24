package ru.popovash.api.utils;

import lombok.NonNull;

public class DateUtils {
    public static @NonNull String getTimeInSeconds(long s) {
        if (s == -1L) {
            return "никогда";
        }
        if (s < 60L) {
            return formatSeconds(s % 60L);
        }
        if (s < 3600L) {
            return formatMinutes(s / 60L % 60L) + ((s % 60L == 0L) ? "" : (" " + formatSeconds(s % 60L)));
        }
        if (s < 86400L) {
            return formatHours(s / 60L / 60L) + ((s / 60L % 60L == 0L) ? "" : (" " + formatMinutes(s / 60L % 60L))) + ((s % 60L == 0L) ? "" : (" " + formatSeconds(s % 60L)));
        }
        return formatDays(s / 60L / 60L / 24L) + ((s / 60L / 60L % 24L == 0L) ? "" : (" " + formatHours(s / 60L / 60L % 24L))) + ((s / 60L % 60L == 0L) ? "" : (" " + formatMinutes(s / 60L % 60L))) + ((s % 60L == 0L) ? "" : (" " + formatSeconds(s % 60L)));
    }

    public static @NonNull String formatHours(long h) {
        if (h % 100L < 20L && h % 100L >= 10L) {
            return h + " часов";
        }
        if (h % 10L == 1L) {
            return h + " час";
        }
        if (h % 10L == 2L || h % 10L == 3L || h % 10L == 4L) {
            return h + " часа";
        }
        return h + " часов";
    }

    public static @NonNull String formatDays(long h) {
        if (h % 100L < 20L && h % 100L >= 10L) {
            return h + " дней";
        }
        if (h % 10L == 1L) {
            return h + " день";
        }
        if (h % 10L == 2L || h % 10L == 3L || h % 10L == 4L) {
            return h + " дня";
        }
        return h + " дней";
    }

    public static @NonNull String formatMinutes(long h) {
        if (h % 100L < 20L && h % 100L >= 10L) {
            return h + " минут";
        }
        if (h % 10L == 1L) {
            return h + " минуту";
        }
        if (h % 10L == 2L || h % 10L == 3L || h % 10L == 4L) {
            return h + " минуты";
        }
        return h + " минут";
    }

    public static @NonNull String formatSeconds(long h) {
        if (h % 100L < 20L && h % 100L >= 10L) {
            return h + " секунд";
        }
        if (h % 10L == 1L) {
            return h + " секунда";
        }
        if (h % 10L == 2L || h % 10L == 3L || h % 10L == 4L) {
            return h + " секунды";
        }
        return h + " секунд";
    }
}
