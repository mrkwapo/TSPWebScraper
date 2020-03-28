package com.Dracodess;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* The concern of this class is to handle user input from the console */
public class Console {

    //Declaring fields to handle getting start and end dates from the user in console
    private static String startDate;
    private static String endDate;

    //Setting the date format
    private final static String DATE_FORMAT = "MM/dd/yyyy";
    //Instantiating Scanner Class
    private static Scanner scanner = new Scanner(System.in);

    //METHODS
    //This method prompts user for dates
    private static String readDate(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.next();
            if(isDateValid(value))
                break;
            System.out.println("Enter a valid date (MM/dd/yyyy)");
        }
        return value;
    }

    //This method validates user input is in a valid date format
    private static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    //Getters
    //To handle date range, this method uses the isDateValid method to obtain a valid start date from the user
    public static String getStartDate() throws ParseException {
        startDate = Console.readDate("Start Date: ");
        return startDate;
    }

    //To handle date range, this method uses the isDateValid method to obtain a valid end date from the user
    public static String getEndDate() throws ParseException {

        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        var start = df.parse(startDate);

        //Validates the end date is after or equal to the start date
        while (true) {
            String end = Console.readDate("End Date: ");
            if (start.before(df.parse(end)) || start.equals(df.parse(end))) {
                endDate = end;
                break;
            }
            System.out.println("End Date cannot be before Start Date");
        }
        return endDate;
    }
}
