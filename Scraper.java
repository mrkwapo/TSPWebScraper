package com.Dracodess;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface Scraper {
    void navigateToPage();

    //This method handles, entering the date range and clicking the button to retrieve data of the selected date range
    void inputDateRange();

    //Getter
    List<WebElement> getShareData();
}
