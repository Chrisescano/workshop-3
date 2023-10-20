package org.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        LocalDateTime timeRightNow = LocalDateTime.now(); //getting the time

        //print
        //mm/dd/yyyy
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(timeRightNow.format(timeFormatter));

        //yyyy-mm-dd
        timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(timeRightNow.format(timeFormatter));

        //month day, year
        timeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(timeRightNow.format(timeFormatter));

        //dayofweek, month day, year  time
        timeFormatter = DateTimeFormatter.ofPattern("EEEE, MM dd, yyyy  HH:mm");
        System.out.println(timeRightNow.format(timeFormatter));

        //challenge
        //hour:minutes on dd-month-year - in my time zone
        //String myTimeZoneID = ZoneId.systemDefault().getId(); //will be America/New_York
        ZonedDateTime zonedTimeRightNow = timeRightNow.atZone(ZoneId.systemDefault());
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm 'on' dd-MM-yyyy");
        System.out.println("\n" + zonedTimeRightNow.format(timeFormatter));
    }
}
