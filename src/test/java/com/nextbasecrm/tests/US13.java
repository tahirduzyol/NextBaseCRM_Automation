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

import java.util.concurrent.TimeUnit;

public class US13 {

    //US13: As a user, I should be able to Make Appreciation using the Appreciation tab
    //AC1: Users should be able to write messages in and send announcements by clicking the SEND button

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //Steps:
        // User goes to the CRM login homepage: https://login2.nextbasecrm.com/
        // User enters the credentials and password provided in the data section to login to the system

        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
        CRM_Utilities.crm_login(driver);
    }

    @Test
    public void sendingAppreciationMsgTest(){
        // User is on the homepage
        // Uses clicks MORE tab and select APPRECIATION
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")).click();
        driver.findElement(By.xpath("//span[.='Appreciation']")).click();

        // User writes an Appreciation message
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Good Job!");

        // User clicks the SEND button
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();

        // Verify the Appreciation is displayed on the feed
        WebElement feedMsg= driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String expected="Good Job!";
        String actual=feedMsg.getText();
        Assert.assertEquals(actual,expected);

    }

        //  AC2: When users attempt to make announcements without a message, there should be a
        // working message “The message title is not specified”
    @Test
    public void emptyMsgTest(){
        //  User is on the homepage
        //  User clicks MORE tab and select APPRECIATION
        driver.findElement(By.cssSelector("#feed-add-post-form-link-text")).click();
        driver.findElement(By.xpath("//span[.='Appreciation']")).click();

        // User clicks the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();

        // Verify “The message title is not specified” warning message is displayed on the page
        WebElement warningMsg=driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        String expectedText="The message title is not specified";
        String actualText=warningMsg.getText();
        Assert.assertEquals(actualText,expectedText,"Warning Message did not appear!");
    }













}
