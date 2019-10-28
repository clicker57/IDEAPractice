package Tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Philip on 10/13/16.
 */
public class PropertiesTools {
    private static Properties prop;
    private static PropertiesTools instance;

    private void init(String name) {
        try {
            InputStream in = this.getClass().getResourceAsStream("/"+name+".properties");
            if (in == null) {
                in = this.getClass().getClassLoader().getResourceAsStream(name+".properties");
            }
            prop = new Properties();
            prop.load(in);
        } catch (IOException e) {
            System.out.println("Error: Read PropertiesTools.properties file failed!!!");
            e.printStackTrace();
        }
    }

    public static synchronized PropertiesTools getInstance(String name) {
        // Generate instance for the first time use.
        if (instance == null) {
            instance = new PropertiesTools();
            instance.init(name);
        }
        return instance;
    }

    public static String getProperty(String propertiesName, String key) {
        getInstance(propertiesName);

        return prop.getProperty(key);
    }

    public static String[] getAllParams(String propertiesName, String key) {
        getInstance(propertiesName);
        String paramStr = prop.getProperty(key);
        String[] paramArr = paramStr.split(",");

        return paramArr;
    }
}
