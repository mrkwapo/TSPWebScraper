package com.Dracodess;

import java.text.ParseException;

//The concern of this class is to display a report of requested shares
public class Report {

   private static Scraper scraper = new Scraper();

    public Report(Scraper scraper) {
        this.scraper = scraper;
    }

    //This method displays share data of a specified date or date range
    public static void getSharePricesByDateRange() throws ParseException {
        var prices = scraper.getShareData();
        System.out.println();
        System.out.println("______________________");
        System.out.println("SHARE PRICE REPORT:");
        System.out.println("______________________");

        for (var item : prices)
            System.out.println(item.getText());
    }
}
