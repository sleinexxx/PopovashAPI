package ru.popovash.api.language.impl;

import ru.popovash.api.PopovashAPI;
import ru.popovash.api.configuration.yaml.YamlConfiguration;
import ru.popovash.api.language.LanguageManager;
import ru.popovash.api.language.PLanguage;
import ru.popovash.api.utils.FileUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PLanguageManager extends LanguageManager<PLanguage> {
    @Override
    protected void load() {
        URL url = PopovashAPI.class.getClassLoader().getResource("languages/");

        File languages;
        try {
            languages = new File(new URI(url.toString().replace(" ","%20")).getSchemeSpecificPart());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        for (File languageFile : languages.listFiles()) {
            System.out.println(languageFile.getName());
            File file = FileUtils.getFileWriter(PopovashAPI.buildUserPath("PopovashAPI", "languages", languageFile.getName())).createIfNotExists().writeToFile();
            PYamlLanguage language = new PYamlLanguage(file);
            if (!language.containsKey("VERSION")) {
                YamlConfiguration.save(new PYamlLanguage(PLanguageManager.class.getClassLoader().getResourceAsStream("languages/" + languageFile.getName())), file);
                language = new PYamlLanguage(file);
            }

            loadItem(language);
        }
    }
}
