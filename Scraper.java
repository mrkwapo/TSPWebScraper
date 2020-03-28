package com.Dracodess;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.List;

/* The concern of this class is to handle scraping data */
public class Scraper {
    //Setting up and instantiating Chrome WebDriver to run in headless mode
    private String PATH = System.setProperty("webdriver.chrome.driver","C:/Users/YourPathHere/chromedriver.exe");
    private ChromeOptions options = new ChromeOptions().addArguments("--headless");
    private WebDriver driver = new ChromeDriver(options);

    //Using Selenium's Wait Class to handle timing
    private WebDriverWait wait = new WebDriverWait(driver, 20000);

    private void navigateToPage(){
        //Using Web Driver to Navigate to the TSP Page
        driver.get("https://www.tsp.gov/InvestmentFunds/FundPerformance/index.html");
    }

    //This method handles, entering the date range and clicking the button to retrieve data of the selected date range
    private void inputDateRange() throws ParseException {
        var startDateInputBox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startdate")));
        var endDateInputBox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enddate")));

        startDateInputBox.sendKeys(Keys.CONTROL + Keys.chord("a"), Console.getStartDate());
        endDateInputBox.sendKeys(Keys.CONTROL + Keys.chord("a"), Console.getEndDate());

        var retrieveSharesBtn = driver.findElement(By.id("retrieve"));
        retrieveSharesBtn.sendKeys(Keys.RETURN);
    }

    //Getter
    public List<WebElement> getShareData() throws ParseException {
        navigateToPage();
        inputDateRange();

        //Selecting Table Data
        List<WebElement> data = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tspStandard"))).findElements(By.tagName("td"));
        return data;
    }
}
