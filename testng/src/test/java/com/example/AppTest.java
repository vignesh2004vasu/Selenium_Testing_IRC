package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

    public class AppTest 
{
   
    @Test
    public void testCase() throws Exception
    {
        ChromeDriver driver  =new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userId = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input"));
        userId.sendKeys("S@gmail.com");
        WebElement pwd = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/input"));
        pwd.sendKeys("P@ssword12");
        WebElement okButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"));
        okButton.click();
        Thread.sleep(5000);

        String keyword = "home";
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains(keyword)) {
            System.out.println("Test Passed: Redirected URL contains keyword \"" + keyword + "\"");
        } else {
            System.out.println("Test Failed: Redirected URL does not contain keyword \"" + keyword + "\"");
        }

        driver.close();
    }


    @Test
    public void testCase2() throws Exception
    {
        ChromeDriver driver  =new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userId = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input"));
        userId.sendKeys("S@gmail.com");
        WebElement pwd = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/input"));
        pwd.sendKeys("P@ssword12");
        WebElement okButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"));
        okButton.click();
        Thread.sleep(5000);

        WebElement depositOption = driver.findElement(By.linkText("Deposit"));
        depositOption.click();

        Thread.sleep(10000);

        Actions action = new Actions(driver);
            WebElement menMenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select"));
            action.moveToElement(menMenu).perform();
            WebElement hoodiesMenu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select/option[3]"));
            hoodiesMenu.click();
            Thread.sleep(10000);


        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys(String.valueOf("5000"));


        Thread.sleep(2000);

        WebElement submitButton2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]"));
        submitButton2.click();
        
        WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]"));
        String tableText = table.getText();
        
        if (tableText.contains(String.valueOf(5000))) {
            System.out.println("Test Passed: Amount " + 5000 + " is present in the table");
        } else {
            System.out.println("Test Failed: Amount " + 5000 + " is not present in the table");
        }

        driver.close();
    }


    @Test
    public void testCase3() throws Exception
    {
        ChromeDriver driver  =new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement userId = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[1]/input"));
        userId.sendKeys("S@gmail.com");
        WebElement pwd = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/input"));
        pwd.sendKeys("P@ssword12");
        WebElement okButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button"));
        okButton.click();
        Thread.sleep(5000);

        WebElement withdrawOption = driver.findElement(By.linkText("Withdraw"));
        withdrawOption.click();

        
        Actions action1 = new Actions(driver);
            WebElement menMenu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select"));
            action1.moveToElement(menMenu1).perform();
            WebElement hoodiesMenu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select/option[3]"));
            hoodiesMenu1.click();
            Thread.sleep(10000);

        // Enter withdrawal amount
        WebElement amountField1 = driver.findElement(By.id("amount"));
        amountField1.sendKeys(String.valueOf(5000));

        Thread.sleep(2000);
        WebElement submitButton2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]"));
        submitButton2.click();

        driver.close();
    }
}
