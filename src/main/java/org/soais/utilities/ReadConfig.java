package org.soais.utilities;

import org.soais.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadConfig {
    private ReadConfig(){}
    public static String get(String key) throws IOException {
        Properties properties=new Properties();
        FileInputStream inputStream= new FileInputStream(FrameworkConstants.getConfigPropertyPath());
        properties.load(inputStream);
        return properties.getProperty(key);
    }

}
