package DataReaders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {

    Properties properties = null;

    public PropertiesFileReader(String propertiesFilePath){
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(new File(propertiesFilePath));
            properties.load(fis);
            fis.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String getPropertyValue(String propertyKey){
        return properties.getProperty(propertyKey);
    }
}
