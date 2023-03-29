package com.evy.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.evy.utils.ScreenshotUtils;
import org.openqa.selenium.devtools.v111.media.Media;

public final class ExtentTestLogger {
    private ExtentTestLogger(){}

    public static void info(String m){
        ExtentTestManager.getExtentTest().info(m);
    }
    public static void pass(String m){
        ExtentTestManager.getExtentTest().pass(m);
    }
    public static void fail(String m){
        ExtentTestManager.getExtentTest().fail(m);
    }
    public static void skip(String m){
        ExtentTestManager.getExtentTest().skip(m);
    }
    public static void screenShotLogger(){
        ExtentTestManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImg()).build());
    }

}
