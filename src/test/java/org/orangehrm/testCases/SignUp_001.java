package org.orangehrm.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SignUp_001 extends BaseClass
{

    @Test
    public void signUp()
    {
        driver.findElement(By.id("signin2")).click();
        WebElement username=driver.findElement(By.id("sign-username"));
        username.sendKeys("James Paul R");
        WebElement password = driver.findElement(By.id("sign-password"));
        password.sendKeys("Password", Keys.ENTER);

    }
}
