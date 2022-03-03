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

public class US3 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");

    }

    @Test
    public void logout_link_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");

        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the logout link on the landing page using index id in xpath
        //since class value is same for other menu link
        WebElement logoutLink = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]"));

        //click on log out link
        logoutLink.click();

        //Get the title of the opening page
        String afterLogoutTitle = driver.getTitle();

        //assign expected and actual values into variable respectively
        String expectedAfterLogoutTitle = "Authorization";
        String actualAfterLogoutTitle = afterLogoutTitle;


        Assert.assertEquals(actualAfterLogoutTitle, expectedAfterLogoutTitle);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }

}