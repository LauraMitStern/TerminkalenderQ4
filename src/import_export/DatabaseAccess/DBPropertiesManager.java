package import_export.DatabaseAccess;

import dbconfig.ConfigEnum;
import dbconfig.RequiredKeysEnum;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Laura Pein
 */
public class DBPropertiesManager {

    public final static String CONFIGPATH = "src";
    private final Map<String, String> propertiesMap = new HashMap();

    public static DBPropertiesManager getInstance() {
        return DBPropertiesManagerHolder.INSTANCE;
    }

    private static class DBPropertiesManagerHolder {

        private static final DBPropertiesManager INSTANCE = new DBPropertiesManager();
    }

    public void createProperties(ConfigEnum config) throws Exception {
        load(CONFIGPATH + File.separator + config.getFilename());
    }

    public void load(String filename) throws Exception {
        File file = new File(filename);
        String filepath = file.getAbsolutePath();

        try (BufferedReader buffy = new BufferedReader(new FileReader(new File(filepath))))
        {
            String line;
            while ((line = buffy.readLine()) != null) {
                System.out.println(line);
                String[] token = line.split("=");
                propertiesMap.put(token[0], token[1]);
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public String getUrl() {
        return propertiesMap.get(RequiredKeysEnum.URL.getKey());
    }

    public String getDriver() {
        return propertiesMap.get(RequiredKeysEnum.DRIVER.getKey());
    }

    public String getUsername() {
        return propertiesMap.get(RequiredKeysEnum.USERNAME.getKey());
    }

    public String getPassword() {
        return propertiesMap.get(RequiredKeysEnum.PASSWORD.getKey());
    }

    @Override
    public String toString() {
        return "DBPropertiesManager{" + "propertiesMap=" + propertiesMap + '}';
    }
}
