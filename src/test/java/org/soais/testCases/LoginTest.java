package org.soais.testCases;

import org.soais.driverClass.DriverManager;
import org.soais.pageobjects.LoginPage;
import org.soais.utilities.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass
{
    @Test()
    public void loginTest() throws InterruptedException, IOException
    {
        LoginPage loginPage=new LoginPage();
       loginPage.enterUsername(ReadConfig.get("username")).enterPassword(ReadConfig.get("password")).clickButton();
       Boolean actualTitle= DriverManager.getDriver().getPageSource().contains("Dashboard");
       System.out.println(actualTitle);
       Assert.assertTrue(actualTitle,"Dashboard");
   }

    @Test(dataProvider = "LoginTestDataProvider")
    public void loginTest2(String username,String password) throws InterruptedException, IOException {

        LoginPage loginPage=new LoginPage();
        loginPage.enterUsername(username).enterPassword(password).clickButton();
        Boolean actualTitle= DriverManager.getDriver().getPageSource().contains("Dashboard");
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle,"Dashboard");
    }
    @DataProvider(name = "LoginTestDataProvider",parallel = true)
    public static Object[][] getData() {
        return new Object[][]{
                {"admin","admin123"},
                {"Admin","admin123"},
                {"Admin","Admin123"},
                {"",""},
        };
    }
}
