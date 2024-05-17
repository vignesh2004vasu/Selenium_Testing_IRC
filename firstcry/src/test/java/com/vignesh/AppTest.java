package com.vignesh;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * AppTest
 * 
 * Test Case 01:
1. Open a web browser and navigate to the URL: https://www.firstcry.com/. 
2. In the top navigation bar, click on the search bar.
3. In the search bar, input the search value "Toys" which should be taken from an Excel sheet, and then perform the "Enter" action. 4. Verify the redirected result page by confirming that the URL contains the keyword 'kids-toys'.


Test Case 02:
1. Open a web browser and navigate to the URL: https://www.firstcry.com/.
2. In the top navigation bar, click on the search bar.
3. In the search bar, input the search value "Clothes," which should be taken from an Excel sheet, and then perform the ENTER action.
 4. You will be redirected to the results page. On the left side, under the FILTER BY section, click on the "Ethnic Wear" checkbox
5. The page will load with the applied filter. Verify that the "Ethnic Wear" filter is applied by confirming the presence of the label "Ethnic Wear" below the navigation bar.


Test Case 03:
1. Open a web browser and navigate to the URL: https://www.firstcry.com/.
2. In the top navigation bar, click on the search bar.
3. In the search bar, input the search value "Balloons," which should be taken from an Excel sheet, and then perform the ENTER action.
 4. You will be redirected to the search results page. Get the title text from the first displayed product and save it for future reference.
5. Click on the first displayed product "Balloon Table Holder. You will be redirected to a new window, verify the gettext value and displayed product value matching.
 */
public class AppTest {

    

    private ChromeDriver driver;
    @Test
    public void testCase1() throws Exception
    {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\firstcry\\src\\TestData.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0); 

        String searchValueToys = sheet.getRow(1).getCell(0).getStringCellValue();
        driver = new ChromeDriver();
        driver.get("https://www.firstcry.com/");
            WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/form/input"));
            searchBar.click();
            searchBar.sendKeys(searchValueToys);
            Thread.sleep(10000);
            searchBar.sendKeys(Keys.RETURN);
            Thread.sleep(10000);
            if (driver.getCurrentUrl().contains("kids-toys")) {
                System.out.println("Test Case 01 Passed");
            } else {
                System.out.println("Test Case 01 Failed");
            }
            Thread.sleep(5000);
            driver.close();
    }

    @Test
    public void testCase2() throws Exception
    {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\firstcry\\src\\TestData.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0); 
        String searchValueClothes = sheet.getRow(2).getCell(0).getStringCellValue();
   
        driver = new ChromeDriver();
        driver.get("https://www.firstcry.com/");
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/form/input"));
        searchBar.click();
            searchBar.sendKeys(searchValueClothes);
            Thread.sleep(10000);
            searchBar.sendKeys(Keys.RETURN);
            Thread.sleep(10000);
            WebElement ethnicWearFilter =driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/ul/li[4]"));

            ethnicWearFilter.click();
            Thread.sleep(5000);
            WebElement appliedFilterLabel = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[1]/div[1]/h1"));
            if (appliedFilterLabel.isDisplayed()) {
                System.out.println("Test Case 02 Passed");
            } else {
                System.out.println("Test Case 02 Failed");
            }
            Thread.sleep(5000);
            driver.close();
    }

    @Test
    public void testCase3() throws Exception
    {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\vignesh\\OneDrive\\Desktop\\Selenium\\firstcry\\src\\TestData.xlsx"));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0); 
        String searchValueBalloons = sheet.getRow(3).getCell(0).getStringCellValue();
        driver = new ChromeDriver();
        driver.get("https://www.firstcry.com/");
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/form/input"));
        searchBar.click();
            searchBar.sendKeys(searchValueBalloons);
            Thread.sleep(10000);
            searchBar.sendKeys(Keys.RETURN);
            Thread.sleep(10000);
            
            String firstProductTitle = driver.findElement(By.linkText("Balloon Table Holder")).getText();
            
            Thread.sleep(3000);
           
            WebElement balloon = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[1]/div[2]/div[16]/div"));
            Thread.sleep(5000);
		    balloon.click();
            Thread.sleep(10000);
            WebElement productTitleOnPage = driver.findElement(By.id("prod_name"));
            if (firstProductTitle.equals(productTitleOnPage.getText())) {
                System.out.println("Test Case 03 Passed");
            } else {
                System.out.println("Test Case 03 Failed");
            }
            Thread.sleep(10000);
            driver.close();
    }
}
