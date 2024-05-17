package com.vignesh;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppTest{
    public static WebDriver driver;
	public final int IMPLICIT_WAIT_TIME=2000;
	public final int PAGE_LOAD_TIME=5000;

	@Test
    public void TestLocators() throws MalformedURLException, InterruptedException{
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.linkText("Laptops")).click();
		Thread.sleep(PAGE_LOAD_TIME);
		driver.findElement(By.linkText("MacBook air")).click();
		Thread.sleep(PAGE_LOAD_TIME);
		driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/a")).click();
		Thread.sleep(IMPLICIT_WAIT_TIME);
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(PAGE_LOAD_TIME);
     
    }

	@Test
	 public void loginTest() throws IOException, InterruptedException {
        
       
         driver = new ChromeDriver();

        driver.get("https://www.demoblaze.com/");

        WebElement loginOption = driver.findElement(By.id("login2"));
        loginOption.click();

        String username = null;
        String  password = null;
        String filePath = "C:/Users/vignesh/OneDrive/Documents/TestData.xlsx"; 
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0); 
        Row row = sheet.getRow(1); 
        Cell usernameCell = row.getCell(0);
        Cell passwordCell = row.getCell(1);

        username = usernameCell.getStringCellValue();
        password = passwordCell.getStringCellValue();

        
        System.out.println(username);
        System.out.println(password);
        WebElement usernameInput = driver.findElement(By.id("loginusername"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("loginpassword"));
        passwordInput.sendKeys(password);


        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        Thread.sleep(6000);
        WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[7]/a"));
        String welcomeText = welcomeMessage.getText();
        if (welcomeText.contains("Welcome " + username)) {
            System.out.println("Login Successful. Welcome message found: " + welcomeText);
        } else {
            System.out.println("Login Failed. Welcome message not found.");
        }

    
        driver.quit();
    }
}




