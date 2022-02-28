
package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US6 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");
        CRM_Utilities.crm_login(driver, "hr46@cydeo.com", "UserUser");

    }

    @Test

    public void project() {


        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        System.out.println("More BUTTON is displayed " + moreButton.isDisplayed());
        moreButton.click();

        WebElement popupbutton1 = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[1]"));
        System.out.println("Pop up button  1 (File)   is displayed  = " + popupbutton1.isDisplayed());

        WebElement popupbutton2 = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]"));
        System.out.println("Pop up button  2 (Appreciation)  is displayed  = " + popupbutton2.isDisplayed());

        WebElement popupbutton3 = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[3]"));
        System.out.println("Pop up button 3 (Announcement)   is displayed  = " + popupbutton3.isDisplayed());

        WebElement popupbutton4 = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[4]"));
        System.out.println("Pop up button 4 (Workflow)  is displayed  = " + popupbutton4.isDisplayed());


    }
}

