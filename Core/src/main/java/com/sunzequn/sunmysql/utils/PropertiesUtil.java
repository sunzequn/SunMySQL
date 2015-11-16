package com.sunzequn.sunmysql.utils;

import com.sunzequn.sunmysql.exception.ConfigException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sloriac on 15/11/15.
 * <p>
 * The util class for reading properties files.
 */
public class PropertiesUtil {

    /**
     * The name of the default config file.
     */
    private static String defaultConfigFile = "config.properties";

    /**
     * Get the value by it`s key from the default config.
     *
     * @param key The value`s key.
     * @return the value if it is existed else return null.
     */
    public static String getValue(String key) {
        Properties properties = new Properties();

        try {
            ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(defaultConfigFile);
            if (inputStream == null) {
                throw new ConfigException("No config file founded.");
            }
            properties.load(inputStream);
            String value = properties.getProperty(key);
            if(StringUtils.isNotEmpty(value)){
                return value;
            }
            else {
                throw new ConfigException("The property: " + key + " is not defined.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
