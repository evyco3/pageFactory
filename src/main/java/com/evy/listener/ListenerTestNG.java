package com.evy.listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.evy.reports.ExtentReportManager;
import com.evy.reports.ExtentTestLogger;
import com.evy.utils.ScreenshotUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG  implements ISuiteListener , ITestListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReportManager.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
     ExtentReportManager.flushReport();
    }
    @Override
    public void  onTestStart(ITestResult result){
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTestLogger.pass(result.getMethod().getMethodName()+" Pass");

    }
    @Override
    public void onTestFailure(ITestResult result){
        ExtentTestLogger.fail(result.getMethod().getMethodName()+"Failed");
        ExtentTestLogger.screenShotLogger();

    }
    @Override
    public void onTestSkipped(ITestResult result){
        ExtentTestLogger.skip(result.getMethod().getMethodName()+" Skip");
        ExtentTestLogger.screenShotLogger();
    }

}
