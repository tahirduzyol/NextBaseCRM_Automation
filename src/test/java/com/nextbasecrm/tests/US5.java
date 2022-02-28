package com.nextbasecrm.tests;

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
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //go to "https://login2.nextbasecrm.com/stream/"
        driver.get("https://login2.nextbasecrm.com/");

        //enter valid userName : hr46@cydeo.com
        String userName = "hr46@cydeo.com";
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys(userName);

        //enter valid password: UserUser
        String password = "UserUser";
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password);

        //click Log In button
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void US5_TC1_verifyingSendMessageFunctionality() throws InterruptedException {

        //Users are on the homepage
        //Users click MESSAGE tab
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']/span")).click();

        //driver switch to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'bx-editor-iframe']")));
        //Users write test message
        WebElement textInputBox = driver.findElement(By.xpath("//body[@style = 'min-height: 184px;']"));
        textInputBox.sendKeys("Test Test");
        //driver switch to parent frame
        //Users click the SEND button
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//div[@class = 'feed-buttons-block']//button[@id = 'blog-submit-button-save']")).click();

        //Verify the message is displayed on the feed

        Thread.sleep(5000);


        WebElement messageText = driver.findElement(By.xpath("//div[@class = 'feed-post-text-block']//div[@class = ' feed-post-contentview feed-post-text-block-inner']/div"));
        System.out.println("messageText = " + messageText.getText());


        Assert.assertTrue(messageText.isDisplayed(), "Text is not displayed");


    }

    @Test
    public void messageTitleNotSpecified() {
        //Users are on the homepage
        //Users click MESSAGE tab
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-message']/span")).click();

        //Users click SEND button
        driver.findElement(By.xpath("//div[@class = 'feed-buttons-block']//button[@id = 'blog-submit-button-save']")).click();

        //Verify “The message title is not specified” warning message is displayed on the page
        WebElement titleNotSpecifiedMessage = driver.findElement(By.xpath("//span[@class = 'feed-add-info-text']"));
        Assert.assertTrue(titleNotSpecifiedMessage.isDisplayed());

    }

}
