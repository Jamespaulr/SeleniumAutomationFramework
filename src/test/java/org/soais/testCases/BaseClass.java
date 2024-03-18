package org.soais.testCases;

import org.soais.driverClass.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass
{
    protected BaseClass(){}

    @BeforeMethod
    protected void setUp() throws IOException {
        Driver.initBrowser();
    }
    @AfterMethod
    protected void tearDown()
    {
        Driver.quitDriver();
    }

}
