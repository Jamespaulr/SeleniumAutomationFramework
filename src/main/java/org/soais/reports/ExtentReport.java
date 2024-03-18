package org.soais.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport
{
    private ExtentReport(){}
    private static ExtentReports extent;

    public static void initReports()
    {if (Objects.isNull(extent)) {
        extent = new ExtentReports();
        final File CONF = new File("extentconfig.xml");
        ExtentHtmlReporter Html = new ExtentHtmlReporter("index.html");
        Html.loadXMLConfig(CONF);
        extent.attachReporter(Html);
        extent.setSystemInfo("Author","James Paul R");
    }

    }
    public static void flushReports() throws IOException {
        if(Objects.nonNull(extent)){
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());}
    }
    public static void createTest(String testcase)
    {
        ExtentManager.setExtentTest(extent.createTest(testcase));
    }
}
