package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
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

public class US5 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //go to "https://login2.nextbasecrm.com/stream/"
        driver.get(ConfigurationReader.getProperty("env"));

        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password") );

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    //As a user, I should be able to send simple text messages using the message tab.

    //1. When users click the MESSAGE tab, they should be able to write the message body and
    //send a message successfully to the feed.
    @Test
    public void US5_TC1_verifyingSendMessageFunctionality() throws InterruptedException {

        //Users are on the homepage
        //Users click MESSAGE tab
        WebElement messageTab = driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']/span"));
        messageTab.click();

        //driver switch to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'bx-editor-iframe']")));
        //Users write test message
        WebElement textInputBox = driver.findElement(By.xpath("//body[@style = 'min-height: 184px;']"));
        textInputBox.sendKeys("Test Test");
        //driver switch to parent frame
        //Users click the SEND button
        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//div[@class = 'feed-buttons-block']//button[@id = 'blog-submit-button-save']"));
        sendButton.click();

        //Verify the message is displayed on the feed
        Thread.sleep(5000);
        WebElement messageText = driver.findElement(By.xpath("//div[@class = 'feed-post-text-block']//div[@class = ' feed-post-contentview feed-post-text-block-inner']/div"));
        System.out.println("messageText = " + messageText.getText());

        Assert.assertTrue(messageText.isDisplayed(), "Text is not displayed");
    }
//2. “The message title is not specified”. Should be displayed when users send a message
//without a content.
    @Test
    public void messageTitleNotSpecified() {
        //Users are on the homepage
        //Users click MESSAGE tab
        WebElement messageTab = driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']/span"));
        messageTab.click();

        //Users click SEND button
        WebElement sendButton = driver.findElement(By.xpath("//div[@class = 'feed-buttons-block']//button[@id = 'blog-submit-button-save']"));
        sendButton.click();

        //Verify “The message title is not specified” warning message is displayed on the page
        WebElement titleNotSpecifiedMessage = driver.findElement(By.xpath("//span[@class = 'feed-add-info-text']"));
        Assert.assertTrue(titleNotSpecifiedMessage.isDisplayed());

    }

}
