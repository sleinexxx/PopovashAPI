package ru.popovash.api.language.impl;

import ru.popovash.api.PopovashAPI;
import ru.popovash.api.configuration.yaml.YamlConfiguration;
import ru.popovash.api.language.LanguageManager;
import ru.popovash.api.language.PLanguage;
import ru.popovash.api.utils.FileUtils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class PLanguageManager extends LanguageManager<PLanguage> {
    @Override
    protected void loadLanguages() {
        URI resourceFolder;
        try {
            resourceFolder = PLanguageManager.class.getClassLoader().getResource("languages" + java.io.File.separator).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        File languages = new File(resourceFolder);

        for (File languageFile : languages.listFiles()) {
            File file = FileUtils.getFileWriter(PopovashAPI.buildUserPath("PopovashAPI", "languages", languageFile.getName())).createIfNotExists().writeToFile();
            PYamlLanguage language = new PYamlLanguage(file);
            if (!language.containsKey("VERSION")) {
                YamlConfiguration.save(new PYamlLanguage(PLanguageManager.class.getClassLoader().getResourceAsStream("languages" + java.io.File.separator + languageFile.getName())), file);
            }

            loadLanguage(language);
        }
    }
}
