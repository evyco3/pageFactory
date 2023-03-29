package com.evy.utils;

import com.evy.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private static final Map<String, String> MAP = new HashMap<>();
    private PropertyUtils() {
    }

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyUtilsFile());
            Properties properties=new Properties();
            properties.load(fis);
            for(Object key:properties.keySet()){
                MAP.put(String.valueOf(key),String.valueOf(properties.get(key)).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    public static String get(String key){
        if(Objects.isNull(key) ||Objects.isNull(MAP.get(key))){
            throw new RuntimeException("Property Name "+key+" is not found.");
        }
        return MAP.get(key);
    }


}
