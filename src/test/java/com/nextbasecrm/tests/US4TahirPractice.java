package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class US4TahirPractice {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");

    }

    @Test (priority = 1)
    public void my_profile_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");

        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the My Profile link on the landing page using index ID of class ID in xpath
        //since class value is same for other menu link
        WebElement myprofileText = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[1]"));

        //assign expected and actual values into variable respectively
        String expectedMyprofileText = "My Profile";
        String actualMyprofileText = myprofileText.getText();


        Assert.assertEquals(expectedMyprofileText, actualMyprofileText);
        BrowserUtils.sleep(3);
    }

    @Test (priority = 2)
    public void edit_profile_settings_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");


        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the My Profile link on the landing page using index ID of class ID in xpath
        //since class value is same for other menu link
        WebElement EditProfileSettingsText = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]"));

        //assign expected and actual values into variable respectively
        String expectedEditProfileSettingsText = "Edit Profile Settings";
        String actualEditProfileSettingsText = EditProfileSettingsText.getText();


        Assert.assertEquals(expectedEditProfileSettingsText, actualEditProfileSettingsText);
        BrowserUtils.sleep(3);
    }

    @Test (priority = 3)
    public void themes_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");


        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the My Profile link on the landing page using index ID of class ID in xpath
        //since class value is same for other menu link
        WebElement ThemesText = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[3]"));

        //assign expected and actual values into variable respectively
        String expectedThemesText = "Themes";
        String actualThemesText = ThemesText.getText();


        Assert.assertEquals(expectedThemesText, actualThemesText);
        BrowserUtils.sleep(3);
    }

    @Test (priority = 4)
    public void configure_notifications_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");

        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the My Profile link on the landing page using index ID of class ID in xpath
        //since class value is same for other menu link
        WebElement ConfigurenotificationsText = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[4]"));

        //assign expected and actual values into variable respectively
        String expectedConfigurenotificationsText = "Configure notifications";
        String actualConfigurenotificationsText = ConfigurenotificationsText.getText();


        Assert.assertEquals(expectedConfigurenotificationsText, actualConfigurenotificationsText);
        BrowserUtils.sleep(3);
    }

    @Test (priority = 5)
    public void logout_verify() {
        //Go to : https://login1.nextbasecrm.com/

        //Calling utility method to login CRM
        CRM_Utilities.crm_login(driver, "hr43@cybertekschool.com", "UserUser");

        //Locate the profile name link on the landing page
        WebElement profileNameLink = driver.findElement(By.xpath("//span[@id='user-name']"));

        //click on profile name link on the landing page
        profileNameLink.click();

        //Locate the My Profile link on the landing page using index ID of class ID in xpath
        //since class value is same for other menu link
        WebElement logoutText = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]"));

        //assign expected and actual values into variable respectively
        String expectedLogoutText = "Log out";
        String actualLogoutTextText = logoutText.getText();


        Assert.assertEquals(expectedLogoutText, actualLogoutTextText);
        BrowserUtils.sleep(3);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }

}
