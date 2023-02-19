package org.lingBotTeam.lingBot.utils.configs.ini;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class Section {
    private final Properties properties = new Properties();
    private final String name;
    public Section(String name) {
        this.name = name;
    }

    public void readFromString(String property) {
        try {
            properties.load(new StringReader(property));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object get(Object key) {
        return properties.get(key);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Object getOrDefault(Object key, Object defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    public String getPropertyOrDefault(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Set<Object> keySet() {
        return properties.keySet();
    }

    public Collection<Object> values() {
        return properties.values();
    }

    public boolean containsKey(Object key) {
        return properties.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return properties.containsValue(value);
    }

    @Override
    public String toString() {
        if (properties.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(name).append(']').append('\n');

        for (Object o : properties.keySet()) {
            sb.append(o).append('=').append(properties.get(o)).append('\n');
        }

        return sb.toString();
    }

    public String getSectionName() {
        return name;
    }
}
