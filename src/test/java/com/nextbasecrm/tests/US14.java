package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class US14 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");

    }

    @Test
    public void image_verify(){

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");

        //Locate the MacOS logo on the landing page
        WebElement macosLogoImage = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-macos']/following-sibling::span[1]"));
        String macosText = macosLogoImage.getText();

        //Assign expected and actual text values into variable respectively
        String expectedMacOSText = "MAC OS";
        String actualMacOSText = macosText;

        Assert.assertEquals(actualMacOSText, expectedMacOSText);

        //Locate the Windows logo on the landing page
        WebElement windowsLogoImage = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-windows']/following-sibling::span[1]"));
        String windowsText = windowsLogoImage.getText();

        //Assign expected and actual text values into variable respectively
        String expectedWindowsText = "WINDOWS";
        String actualWindowsText = windowsText;

        Assert.assertEquals(actualWindowsText, expectedWindowsText);

        //Locate the Linux logo on the landing page
        WebElement linuxLogoImage = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-linux']/following-sibling::span[1]"));
        String linuxText = linuxLogoImage.getText();

        //Assign expected and actual text values into variable respectively
        String expectedLinuxText = "LINUX";
        String actualLinuxText = linuxText;

        Assert.assertEquals(actualLinuxText, expectedLinuxText);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }


}