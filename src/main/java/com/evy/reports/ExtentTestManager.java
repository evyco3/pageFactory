package com.evy.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
    private static final ThreadLocal<ExtentTest>EXTENT_TEST_THREAD_LOCAL=new ThreadLocal<>();
    private ExtentTestManager(){}

    public static void setExtentTest(ExtentTest test){
        EXTENT_TEST_THREAD_LOCAL.set(test);
    }
    public static ExtentTest getExtentTest(){
        return EXTENT_TEST_THREAD_LOCAL.get();
    }
    public static void unloadExtentTest(){
        EXTENT_TEST_THREAD_LOCAL.remove();
    }
}
