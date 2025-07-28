package com.exercise.framework.listeners;

import com.exercise.framework.reports.Reports;
import com.exercise.framework.base.BasePage;
import com.exercise.framework.webcommons.WebCommons;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListeners extends Reports implements ITestListener {
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        startReporting(testName);
        Reports.logger.info("Test Case Execution Started: " + testName);
    }

    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Reports.logger.pass("Test Case Execution Passed: " + testName);
        stopReporting();
    }

    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Reports.logger.fail("Test Case Execution Failed: " + testName);
        Reports.logger.fail("Test Case Execution Failed due to Error: " + result.getThrowable().getLocalizedMessage());
        try {
            Reports.logger.addScreenCaptureFromPath(WebCommons.windowScreenshot(BasePage.getDriver(), testName));
        } catch (IOException e) {
            // its not  a syntax or runtime error,
            e.printStackTrace();
        }
        stopReporting();
    }


}
