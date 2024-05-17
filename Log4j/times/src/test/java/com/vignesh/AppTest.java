package com.vignesh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AppTest {
    private static final Logger logger = LogManager.getLogger(AppTest.class);
    private WebDriver driver;

    @Test
    public void main() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        Thread.sleep(5000);

        logger.info("Test started");

        logger.info("Clicking on the top navigation link");
        driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]/a")).click();
        Thread.sleep(10000);

        logger.info("Scrolling down");
        JavascriptExecutor JS = (JavascriptExecutor) driver;
        JS.executeScript("window.scrollBy(0,800)", "");

        logger.info("Selecting AMC");
        driver.findElement(By.id("amcSelection")).click();
        Thread.sleep(5000);
        Select S = new Select(driver.findElement(By.id("amcSelection")));
        S.selectByVisibleText("Canara Robeco");
        Thread.sleep(5000);

        logger.info("Selecting scheme name");
        driver.findElement(By.id("schemenm")).click();
        Thread.sleep(5000);
        Select Se = new Select(driver.findElement(By.id("schemenm")));
        Se.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        Thread.sleep(5000);

        logger.info("Clicking on anchor");
        driver.findElement(By.id("anchor3")).click();
        Thread.sleep(15000);

        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                logger.info("Switched to new tab");
                break;
            }
        }

        logger.info("Selecting options from dropdown");
        WebElement dropdownContainer = driver
                .findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/span"));
        dropdownContainer.click();

        WebElement Options = dropdownContainer
                .findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]"));
        Options.click();
        Thread.sleep(2000);

        WebElement Container = driver
                .findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/span"));
        Container.click();

        WebElement Option = dropdownContainer.findElement(
                By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]/span"));
        Option.click();

        Thread.sleep(2000);

        WebElement Contain = driver
                .findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/span"));
        Contain.click();

        WebElement Opt = dropdownContainer.findElement(
                By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]/span"));
        Opt.click();

        logger.info("Clicking on returns tab");
        WebElement returns = driver.findElement(By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]"));
        returns.click();
        Thread.sleep(5000);

        logger.info("Getting text of printthis element");
        WebElement printthis = driver.findElement(By.xpath(
                "/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        logger.info("Text of printthis element: " + printthis.getText());
    }
}