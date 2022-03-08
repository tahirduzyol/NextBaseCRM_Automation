package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class US8_OZGE {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
       CRM_Utilities.crm_login(driver);
        //locating Chat and Calls module and clicking
        WebElement chatAndCalls = driver.findElement(By.partialLinkText("Chat and Calls"));
        chatAndCalls.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //There should be four sub-modules once the user clicks the Chat and Calls module:
    //Message
  @Test
    public void message(){
        //locating message element
        WebElement messageButton = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-im']"));
        //Verifying is it visible
        Assert.assertTrue(messageButton.isDisplayed());
    }
    //Notifications
    @Test
    public void notification(){
        //locating notification element
        WebElement notificationButton = driver.findElement(By.xpath("//div[@class='bx-desktop-tab-icon bx-desktop-tab-icon-notify']"));
        //Verifying is it visible
        Assert.assertTrue(notificationButton.isDisplayed());
    }
}
