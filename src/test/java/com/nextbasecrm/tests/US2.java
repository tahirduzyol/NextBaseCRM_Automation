package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US2 {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String environment = ConfigurationReader.getProperty("env2");
        driver.get(environment);
    }

    @Test
    public void checkBoxDisplayed(){
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertTrue(checkbox.isDisplayed());
    }
    @Test
    public void checkBoxChecked(){
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }
    @Test
    public void RememberMeOnThisComputerDisplayed(){
        WebElement rememberMeOnThisComputerText = driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']"));
        String actualText = rememberMeOnThisComputerText.getText();
        String expectedText = "Remember me on this computer";
        Assert.assertEquals(actualText,expectedText);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
