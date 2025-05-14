package org.gianfranco.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Config {

    private static final String PROPERTIES_FILE = "config.properties";
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (in == null) {
                throw new RuntimeException("No se encontró " + PROPERTIES_FILE + " en el classpath");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Error cargando " + PROPERTIES_FILE + ": " + e.getMessage());
        }
    }

    private Config(){}

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return PROPS.getProperty(key, defaultValue);
    }

    public static List<String> getAsList(String key) {
        return Arrays.stream(PROPS.getProperty(key).split(",")).map(String::trim).collect(Collectors.toList());
    }
}
