package ru.popovash.api;

import ru.popovash.api.language.LanguageManager;
import ru.popovash.api.language.PLanguage;
import ru.popovash.api.language.impl.PLanguageManager;
import ru.popovash.api.scheduler.Scheduler;
import ru.popovash.api.scheduler.impl.PScheduler;

import java.io.File;

public class PopovashAPI {
    private static LanguageManager<PLanguage> languageManager;
    private static Scheduler scheduler;

    public static LanguageManager<PLanguage> getLanguageManager() {
        return languageManager == null ? languageManager = new PLanguageManager() : languageManager;
    }

    public static Scheduler getScheduler() {
        return scheduler == null ? scheduler = new PScheduler() : scheduler;
    }

    public static String buildUserPath(String... path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.getProperty("user.home"));
        for (String s : path) {
            stringBuilder.append(File.separator + s);
        }
        return stringBuilder.toString();
    }
}
