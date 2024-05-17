package com.vignesh;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest
{

    @Test
    public void TestApp() throws Exception
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://skct892.examly.io/");
        Thread.sleep(5000);

        WebElement email = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/app-form-builder/div/form/div[1]/app-field-builder/div/div/email/div/div/span/input"));
        email.sendKeys("727822tucs239@skct.edu.in" );
        email.sendKeys(Keys.RETURN);

        Thread.sleep(5000);

        WebElement pwd = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-login/div/div/div[2]/app-dynamic/div[3]/div/div/app-form-builder/div/form/div[2]/app-field-builder/div/div/email/div/div/span/input"));
        pwd.sendKeys("vignesh");
        pwd.sendKeys(Keys.RETURN);
    }
}
