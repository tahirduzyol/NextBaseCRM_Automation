package com.nextbasecrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9 {
    WebDriver driver;

    @BeforeMethod()
    public void setDriver() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing46@cydeo.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
        Thread.sleep(1000);
    }




    @AfterMethod()
    public void treadDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        Thread.sleep(1000);
    }
    @Test(priority = 1)
    public void activityStreamModuleTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_live_feed")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle="Portal";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);

    }
    @Test(priority = 2)
    public void tasksModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_tasks")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle="My tasks";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void chatAndCallsModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_im_messenger")).click();
        Assert.assertTrue(driver.findElement(By.id("im-workarea-content")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle="Chat and Calls";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 4)
    public void workgroupsModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_all_groups")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Workgroups and projects";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 5)
    public void driveModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_files")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "My Drive";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 6)
    public void calendarModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_calendar")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Marketing46 Cydeo: Calendar";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 7)
    public void mailModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_external_mail")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Mailbox Integration";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 8)
    public void contactCenterModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_contact_center")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Contact Center";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 9)
    public void crmModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_crm_favorite")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Leads";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 10)
    public void timeAndReportsModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_timeman_sect")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Absence Chart";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 11)
    public void employeesModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_company")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Company Structure";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 12)
    public void servicesModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_services_sect")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Meeting Rooms";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
    @Test(priority = 13)
    public void companyModuleTest() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.id("bx_left_menu_menu_about_sect")).click();
        Assert.assertTrue(driver.findElement(By.id("pagetitle")).isDisplayed());
        String actualTitle=driver.getTitle();
        String expectedTitle= "Company";
        Assert.assertEquals(actualTitle,expectedTitle,"invalid title");
        Thread.sleep(1000);
    }
}
