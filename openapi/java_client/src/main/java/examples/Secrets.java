package Examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Secrets {

    /* Constructor */ 
    public Secrets(){
        
    }

    /* Helper method to open config.properties file */
    private Properties openFile() throws IOException{
        String filePath = "resources/config.properties";

        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        prop.load(input);
        input.close();
        return prop;
    }

    /* Getter method to get a the value corresponding to a given key from config.properties */
    public String get(String key ) throws IOException{
        Properties prop = openFile();
        return prop.getProperty(key);
    }

}
