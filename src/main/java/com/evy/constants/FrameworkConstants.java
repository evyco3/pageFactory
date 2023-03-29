package com.evy.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    private static final String PROPERTY_UTILS_FILE=System.getProperty("user.dir")+"/src/main/resources/config.properties";
    private static final String EXTENT_REPORT_FILE=System.getProperty("user.dir")+"/output/index.html";

    public static String getPropertyUtilsFile() {
        return PROPERTY_UTILS_FILE;
    }

    public static String getExtentReportFile() {
        return EXTENT_REPORT_FILE;
    }
}
