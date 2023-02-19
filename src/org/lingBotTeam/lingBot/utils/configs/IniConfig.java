package org.lingBotTeam.lingBot.utils.configs;

import org.lingBotTeam.lingBot.utils.configs.ini.Section;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.regex.Pattern;

// ini config reader
public class IniConfig {
    protected final LinkedHashMap<String, Section> sectionsMap = new LinkedHashMap<>();
    private File file = null;
    private static final Pattern sectionPatten = Pattern.compile("\\[.*]");
    public IniConfig(String path) throws IOException {
        this(new File(path));
    }

    public IniConfig(File file) throws IOException {
        this(new FileInputStream(file));
        this.file = file;
    }

    public IniConfig(InputStream stream) throws IOException {
        load(stream);
    }

    public void load(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            Iterator<String> lines = reader.lines().iterator();
            while (lines.hasNext()) {
                String line = lines.next();
                sb.append(line);
                sb.append('\n');
            }
        }
        readFromString(sb.toString());
    }

    public Section getSection(String key) {
        return sectionsMap.get(key);
    }

    public void saveConfig() {
        if (file == null) return;


        try {
            try (FileOutputStream stream = new FileOutputStream(file)) {
                try (OutputStreamWriter writer = new OutputStreamWriter(stream, StandardCharsets.UTF_8)) {
                    writer.write(this.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromString(String ini) {
        if (ini == null) return;
        String[] lines = ini.split("\n");
        StringBuilder sb = new StringBuilder();
        Section section = new Section("Default");
        for (String line : lines) {
            if (isIniNotes(line)) continue;
            if (isSection(line)) {
                if (sb.length() > 0) section.readFromString(sb.toString());
                sectionsMap.put(section.getSectionName(), section);
                section = new Section(splitSection(line));
                continue;
            }
            sb.append(line);
            sb.append('\n');
        }
        section.readFromString(sb.toString());;
        sectionsMap.put(section.getSectionName(), section);
    }

    private boolean isIniNotes(String line) {
        return line.startsWith(";") || line.startsWith("#") || line.startsWith(" ") || line.length() == 0;
    }

    private boolean isSection(String line) {
        return sectionPatten.matcher(line).matches();
    }

    private String splitSection(String line) {
        return line.replace("[", "").replace("]", "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Section value : sectionsMap.values()) {
            sb.append(value.toString());
            sb.append('\n');
        }

        return sb.toString();
    }
}
