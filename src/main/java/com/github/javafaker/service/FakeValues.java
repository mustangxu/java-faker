package com.github.javafaker.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.yaml.snakeyaml.Yaml;

public class FakeValues implements FakeValuesInterface {
    private final Locale locale;
    private final String filename;
    private final String path;
    private Map<String, Map<String, ?>> values;

    FakeValues(Locale locale) {
        this(locale, getFilename(locale), getFilename(locale));
    }

    private static String getFilename(Locale locale) {
        final var filename = new StringBuilder(language(locale));
        if (!"".equals(locale.getCountry())) {
            filename.append("-").append(locale.getCountry());
        }
        return filename.toString();
    }

    /**
     * If you new up a locale with "he", it gets converted to "iw" which is old.
     * This addresses that unfortunate condition.
     */
    private static String language(Locale l) {
        if ("iw".equals(l.getLanguage())) {
            return "he";
        }
        return l.getLanguage();
    }

    FakeValues(Locale locale, String filename, String path) {
        this.locale = locale;
        this.filename = filename;
        this.path = path;
    }

    @Override
    public Map<String, ?> get(String key) {
        if (this.values == null) {
            this.values = this.loadValues();
        }

        return this.values == null ? null
            : (Map<String, ?>) this.values.get(key);
    }

    private Map<String, Map<String, ?>> loadValues() {
        var pathWithLocaleAndFilename = "/" + this.locale.getLanguage() + "/" + this.filename;
        var pathWithFilename = "/" + this.filename + ".yml";
        var pathWithLocale = "/" + this.locale.getLanguage() + ".yml";

        var op = Stream
                .of(pathWithLocaleAndFilename, pathWithFilename, pathWithLocale)
                .map(this::findStream).filter(Objects::nonNull).findFirst();

        if (op.isEmpty()) {
            return null;
        }

        try (var stream = op.get();) {
            final Map<String, Map<String, Map<String, Map<String, ?>>>> valuesMap = new Yaml()
                    .loadAs(stream, Map.class);
            var localeBased = valuesMap.get(this.locale.getLanguage());
            if (localeBased == null) {
                localeBased = valuesMap.get(this.filename);
            }

            return localeBased.get("faker");
        }catch (IOException ex){
            return null;
        }
    }

    private InputStream findStream(String filename) {
        var streamOnClass = this.getClass().getResourceAsStream(filename);
        if (streamOnClass != null) {
            return streamOnClass;
        }
        return this.getClass().getClassLoader().getResourceAsStream(filename);
    }

    boolean supportsPath(String path) {
        return this.path.equals(path);
    }
}
