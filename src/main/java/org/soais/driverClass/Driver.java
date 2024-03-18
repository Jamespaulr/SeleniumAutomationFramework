package org.soais.driverClass;

import org.openqa.selenium.edge.EdgeDriver;
import org.soais.constants.FrameworkConstants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.soais.utilities.ReadConfig;

import java.io.IOException;
import java.util.Objects;

public final class Driver
{
    private Driver(){}

    public static void initBrowser() throws IOException {
        if(Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getEdgeDriverPath().trim());
            DriverManager.setDriver(new EdgeDriver());
//            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(ReadConfig.get("url"));
        }

    }
    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
