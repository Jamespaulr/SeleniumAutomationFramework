package org.soais.pageobjects;

import com.mongodb.assertions.Assertions;
import org.soais.driverClass.DriverManager;
import org.openqa.selenium.By;
import org.soais.reports.ExtentManager;
import org.testng.Assert;

public final class LoginPage
{
    private final By loginUsername=By.xpath("//input[@name='username']");
    private final By loginPassword=By.xpath("//input[@name='password']");
    private final By loginButton=By.xpath("//button[@type='submit']");

    public LoginPage enterUsername(String username) throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.getDriver().findElement(loginUsername).sendKeys(username);
        ExtentManager.getExtentTest().info("Entered Username");
        return this;
    }
    public LoginPage enterPassword(String password) throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.getDriver().findElement(loginPassword).sendKeys(password);
        ExtentManager.getExtentTest().info("Entered Password");
        return this;
    }
    public LoginPage clickButton()
    {
        DriverManager.getDriver().findElement(loginButton).click();
        ExtentManager.getExtentTest().info("Login Button Clicked");
        return this;
    }



}
