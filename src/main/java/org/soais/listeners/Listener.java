package org.soais.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.soais.driverClass.DriverManager;
import org.soais.reports.ExtentManager;
import org.soais.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener
{
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
            ExtentManager.unload();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getExtentTest().pass("Test Passed");
        try {
            ExtentManager.getExtentTest().pass("",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getExtentTest().fail("Test failed");
        try {
            ExtentManager.getExtentTest().log(Status.FAIL,"Failed",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getExtentTest().skip("Test Skipped");
    }
    public String getBase64()
    {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
