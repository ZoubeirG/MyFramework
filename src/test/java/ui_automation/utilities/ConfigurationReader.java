package ui_automation.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader {
    //Encapsulation Logic
    private static Properties properties;
    public static String getProperty(String fileName, String key) {
        try {
            String path = "src/test/resources/"+ fileName;
            //FileInputStream is the Java class and will read file as Stream
            FileInputStream stream = new FileInputStream(path);
            //Properties class is having ability to load stream and get value based on KEY
            properties = new Properties();
            properties.load(stream);
            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); }

    //Overloading concept
    public static String getProperty(String key) {
        try {
            String path = "src/test/resources/ui-config.properties";
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();
            properties.load(stream);
            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); }
}