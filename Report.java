package com.Dracodess;

//The concern of this class is to handle displaying a report of retrieved shares
public class Report {
    private static Scraper scraper = new ScraperSpring2020();

    //This method displays share data of a specified date or date range
    public static void getSharePricesByDateRange() {
        var prices = scraper.getShareData();
        System.out.println();
        System.out.println("______________________");
        System.out.println("SHARE PRICE REPORT:");
        System.out.println("______________________");

        for (var item : prices)
            System.out.println(item.getText());
    }
}
