package com.Dracodess;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Scraper {
    //This method should handle navigation to the web page to be scraped
    void navigateToPage();

    //This method should handle, entering the date range and clicking the button to retrieve data of the selected date range
    void inputDateRange();

    //This getter should return WebElements containing share data
    List<WebElement> getShareData();
}
