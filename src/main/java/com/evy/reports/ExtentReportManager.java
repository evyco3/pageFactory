package com.evy.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.evy.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReportManager {
    private static ExtentReports extent;
    private ExtentReportManager(){}

    public static void initReport(){
        if(Objects.isNull(extent)){
            extent=new ExtentReports();
            ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFile());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("qdPM report");
            spark.config().setDocumentTitle("qdPM title");

        }
    }

    public static void flushReport()  {
        if(Objects.nonNull(extent)){
            extent.flush();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFile()).toURI());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createTest(String testName){
        ExtentTestManager.setExtentTest(extent.createTest(testName));
    }
}
