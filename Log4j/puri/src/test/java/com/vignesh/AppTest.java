package com.vignesh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AppTest {

    private static final Logger logger = LogManager.getLogger(AppTest.class);
    private WebDriver driver;

    @Test(priority = 0)
    public void test1() throws Exception {

        driver = new ChromeDriver();
        driver.get("https://www.puriholidayresort.com/");
        Thread.sleep(10000);
        logger.info("Starting test1");
        Thread.sleep(3000);
        logger.info("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(10000);

        logger.info("Opening date picker");
        driver.findElement(By.xpath("//input[@id='arr_datepicker']")).click();
        Thread.sleep(3000);
        logger.info("Selecting date 30");
        driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'30')]")).click();

        Thread.sleep(3000);
        logger.info("Clicking on custom button");
        driver.findElement(By.xpath("//button[@class='custom-btn']")).click();
        logger.info("test1 completed");
    }

    @Test(priority = 1)
    public void test2() throws Exception {
        logger.info("Starting test2");
        Thread.sleep(3000);
        logger.info("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        logger.info("Moving to 'Rooms & Suites' menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[2]/a[contains(text(),'Rooms & Suites')]"))).build()
                .perform();
        Thread.sleep(3000);
        logger.info("Clicking on 'Royal Suite'");
        driver.findElement(By.xpath("//a[contains(text(),'Royal Suite')]")).click();

        Thread.sleep(3000);
        logger.info("Clicking on 'AMENITIES'");
        driver.findElement(By.xpath("//h3[contains(text(),'AMENITIES')]")).click();
        logger.info("test2 completed");
    }

    @Test(priority = 2)
    public void test3() throws Exception {
        logger.info("Starting test3");
        Thread.sleep(3000);
        By continLocator = By.xpath(
                "//textarea[contains(text(),'Title your review - Describe your stay in one sentence or less. ')]");
        Thread.sleep(3000);
        logger.info("Clicking on the button");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        Thread.sleep(3000);
        logger.info("Moving to 'About Puri' menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//li[1]/a[contains(text(),'About Puri')]"))).build()
                .perform();

        Thread.sleep(3000);
        logger.info("Clicking on 'Chilika Lake'");
        driver.findElement(By.xpath("//a[contains(text(),'Chilika Lake')]")).click();

        Thread.sleep(4000);
        logger.info("Entering review text");
        driver.findElement(continLocator).click();
        driver.findElement(continLocator).sendKeys("Excellent");

        Thread.sleep(3000);
        logger.info("Clicking on 'Continue'");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                logger.info("Switching to new window");
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(3000);
        logger.info("Selecting 'Family'");
        driver.findElement(By.xpath("//span[contains(text(),'Family')]")).click();
        logger.info("test3 completed");
    }
}
