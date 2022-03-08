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


import java.util.List;
import java.util.concurrent.TimeUnit;

public class US7_OZGE {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CRM_Utilities.crm_login(driver);
    }

    //1. Users can select one answer and click the “VOTE” button to vote for a poll.
    @Test
    public void voteOnPoll(){
        //locating poll button and clicking
        WebElement poll = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        poll.click();

        //locating poll question and answer inputs
        WebElement question = driver.findElement(By.xpath("//input[@placeholder='Question ']"));
        WebElement answer1 = driver.findElement(By.xpath("//input[@placeholder='Answer  1']"));
        WebElement answer2 = driver.findElement(By.xpath("//input[@placeholder='Answer  2']"));

        //entering text
        String pollQuestion = ConfigurationReader.getProperty("pollQuestion");
        question.sendKeys(pollQuestion);
        answer1.sendKeys(ConfigurationReader.getProperty("pollAnswer1"));
        answer2.sendKeys(ConfigurationReader.getProperty("pollAnswer2"));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement body = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        //entering text
        String pollTitle = ConfigurationReader.getProperty("pollTitle");
        body.sendKeys(pollTitle);

        driver.switchTo().defaultContent();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //locating send button and creating poll
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //selecting first answer
        List<WebElement> answers = driver.findElements(By.xpath("//div[.='" + pollQuestion + "']/..//span[@class='bx-vote-block-input-wrap bx-vote-block-radio-wrap']"));
        answers.get(0).click();

        //locating vote button
        WebElement voteButton = driver.findElement(By.xpath("//div[.='" + pollQuestion +"']/../../../../..//button[@data-bx-vote-button='actVoting']"));
        voteButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Verifying - if percent is displayed then test was successful
        //WebElement boxPercent = driver.findElement(By.xpath("//div[.='Favorite drink']/../../../../..//span[@class='bx-vote-data-percent']"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(voteButton.isDisplayed());

    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}

