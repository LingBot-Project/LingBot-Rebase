import org.lingBotTeam.lingBot.utils.configs.IniConfig;
import org.lingBotTeam.lingBot.utils.configs.ini.Section;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File(Test.class.getResource("test.ini").getFile());
        IniConfig config = new IniConfig(file);
        Section section = config.getSection("Section1");
//        System.out.println(section.getProperty("key1"));
//        System.out.println(section.getProperty("key2"));
//        System.out.println(section.getProperty("key3"));
        System.out.println(config);
//        section = config.getSection("Section2");
//        System.out.println(section.getProperty("abs"));
//        section = config.getSection("Section3");
//        System.out.println(section.getProperty("key1"));
    }
}
