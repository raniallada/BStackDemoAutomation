package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try {

            FileInputStream fis =
                    new FileInputStream(
                            System.getProperty("user.dir")
                            + "/src/test/resources/config.properties");

            prop.load(fis);
        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getUrl() {

        return prop.getProperty("url");
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }
}