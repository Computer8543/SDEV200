/* Program Name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/1/2024
 * Purpose: To act as a test program, creating multiple MyDate objects, and displaying the year, month, and day of those objects.
 */

public class App {
    public static void main(String[] args) throws Exception {
        // initialize variables
        MyDate currentDate = new MyDate();
        MyDate chosenDate = new MyDate(34355555133101L);

        // print out current date: year, month, and day
        System.out.println("Current Date: ");
        System.out.println('\t' + "Year: " + currentDate.getYear());
        System.out.println('\t' + "Month: " + currentDate.getMonth());
        System.out.println('\t' + "Day: " + currentDate.getDay());

        // print out chosen date: year, month, and day
        System.out.println("Chosen Date: ");
        System.out.println('\t' + "Year: " + chosenDate.getYear());
        System.out.println('\t' + "Month: " + chosenDate.getMonth());
        System.out.println('\t' + "Day: " + chosenDate.getDay());
    }
}
