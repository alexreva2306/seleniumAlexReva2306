package mentoringNikita.netflix;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public static String returnKey (String key) {


        File file = new File("/Users/SDET/IdeaProjects/Seleniumb10/src/main/java/mentoringz/mentoringzData.properties");

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);

    }
}
