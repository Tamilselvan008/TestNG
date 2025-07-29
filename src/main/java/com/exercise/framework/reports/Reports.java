package com.exercise.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeSuite;

public class Reports {
    public static ExtentSparkReporter html;
    public static ExtentReports extent;

    /** Represents the ExtentTest instance used to log test details. */
    public static ExtentTest logger; // ink

    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        html = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\AutomationTestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(html);
    }

    public static void startReporting(String testName) {
        logger = extent.createTest(testName);
    }

    public static void stopReporting() {
        extent.flush();
    }


}
