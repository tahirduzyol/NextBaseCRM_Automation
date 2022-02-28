package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //go to "https://login2.nextbasecrm.com/stream/"
        driver.get("https://login2.nextbasecrm.com/");

        //enter valid userName : hr46@cydeo.com
        String userName = "hr46@cydeo.com";
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys(userName);
        BrowserUtils.sleep(3);
        //enter valid password: UserUser
        String password = "UserUser";
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password);
        BrowserUtils.sleep(3);
        //click Log In button
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }
    @Test(priority = 1)
    public void makeAnnouncement() {

        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();
        WebElement announcement = driver.findElement(By.xpath("//span[.='Announcement'][@class='menu-popup-item-text']"));
        announcement.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageBox = driver.findElement(By.xpath("//body"));

        String announcementmessage = "Sampiyon Besiktas";
        messageBox.sendKeys(announcementmessage);
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
    }

    @Test(priority = 2)
    public void errorMessage(){

        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();
        WebElement announcement = driver.findElement(By.xpath("//span[.='Announcement'][@class='menu-popup-item-text']"));
        announcement.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageBox = driver.findElement(By.xpath("//body"));


        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        String actualMessage = driver.findElement(By.xpath("//span[@class='feed-add-info-text']")).getText();
        String expectedMessage = "The message title is not specified";

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }


}
