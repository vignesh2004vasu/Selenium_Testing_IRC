package com.vignesh;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testCase1() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[1]/div/input"));
        search.sendKeys("Shoe"+ Keys.RETURN);
        Thread.sleep(5000);

        WebElement resultText = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span"));
            if (resultText.getText().contains("Search results for: 'Shoe'")) {
                System.out.println("Search results verified.");
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\magento\\target\\search_results_shoe.png"));
            }


    }

    @Test
    public void testCase2() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[2]/div[2]/form/div[1]/div/input"));
        search.sendKeys("Hoodie"+ Keys.RETURN);
        Thread.sleep(5000);

        WebElement resultText = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span"));
            if (resultText.getText().contains("Search results for: 'Hoodie'")) {
                System.out.println("Search results verified.");
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\magento\\target\\search_results_Hoodie.png"));
            }

        Thread.sleep(10000);
    }

    @Test
    public void testCase3() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(10000);

        WebElement search2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div/a[2]/span[2]/span[2]"));
        search2.click();
        Thread.sleep(6000);

        WebElement findProd = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]"));
        findProd.click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[3]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div/div[2]")).click();
		// driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[1]/div/input"));
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[2]/button")).click();

        WebElement resultText = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[2]/div/div/div[1]/label/span"));
        System.out.println(resultText.getText());
        if (resultText.getText().contains("Qty")) {
            System.out.println("Quantity results verified.");
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\magento\\target\\search_results_Quantity.png"));
        }

        Thread.sleep(5000);
    }

     
}

