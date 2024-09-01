/* Program Name: MyDate.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/1/2024
 * Purpose: To store a date, and have multiple constructors, getters, and one setter function.
 */

import java.util.GregorianCalendar;

public class MyDate {
    // attributes of MyDate class
    private int year = 1970;
    private int month = 0; // month is zero based, 0 for January
    private int day = 1;

    // methods of MyDate class

    /* No argument constructor that creates a MyDate object for the current date. */
    public MyDate() {
        // initialize variables
        GregorianCalendar gc = new GregorianCalendar();
        
        // get year, month, and day from GregorianCalendar
        this.year = gc.get(GregorianCalendar.YEAR);
        this.month = gc.get(GregorianCalendar.MONTH);
        this.day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }
    /*A constructor that constructs a MyDate object with a specified elapsed time
    since midnight, January 1, 1970, in milliseconds. */
    public MyDate(long elapsedTime) {
        // initialize variables
        GregorianCalendar gc = new GregorianCalendar();

        // set time in milliseconds using elapsedTime
        gc.setTimeInMillis(elapsedTime);

        // get year, month, and day from GregorianCalendar
        this.year = gc.get(GregorianCalendar.YEAR);
        this.month = gc.get(GregorianCalendar.MONTH);
        this.day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /*A constructor that constructs a MyDate object with the specified year, month,
    and day. */
    public MyDate(int year, int month, int day) {
        // error checking of year
        if (year < 0) {
            System.out.println("You cannot set the year to be less than 0. Setting to default date.");
            this.year = 1970;
        }
        else {
            this.year = year;
        }

        // error checking of month 
        if (month < 0 || month > 11) {
            System.out.println("You cannot set the month to be less than 0 or greater than 11. Setting to default date.");
            this.month = 0;
        }
        else {
            this.month = month;
        }

        // error checking of day
        if ((month == 1 && (day < 1 || day > 31)) || (month == 2 && (day < 1 || (day > 28 && (!((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)))) || (day < 1 || day > 29 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))) || (month == 3 && (day < 1 || day > 31)) || (month == 4 && (day < 1 || day > 30)) || (month == 5 && (day < 1 || day > 31)) || (month == 6 && (day < 1 || day > 30)) || (month == 7 && (day < 1 || day > 31)) || (month == 8 && (day < 1 || day > 31)) || (month == 9 && (day < 1 || day > 30)) || (month == 10 && (day < 1 || day > 31)) || (month == 11 && (day < 1 || day > 30)) || (month == 12 && (day < 1 || day > 31)))
        {
            System.out.println("You need to input a valid day for the month. Setting to default date.");
            this.day = 1;
        }
        else {
            this.day = day;
        }
    }

    /* A getter function for the year attribute */
    public int getYear() {
        return year;
    }

    /* A getter function for the month attribute */
    public int getMonth() {
        return month;
    }

    /* A getter function for the day attribute */
    public int getDay() {
        return day;
    }

    /* A method that sets a new date for the object using the elapsed time */
    public void setDate(long elapsedTime) {
        // initialize variables
        GregorianCalendar gc = new GregorianCalendar();

        // set time in milliseconds using elapsedTime
        gc.setTimeInMillis(elapsedTime);

        // get year, month, and day from GregorianCalendar
        this.year = gc.get(GregorianCalendar.YEAR);
        this.month = gc.get(GregorianCalendar.MONTH);
        this.day = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
    