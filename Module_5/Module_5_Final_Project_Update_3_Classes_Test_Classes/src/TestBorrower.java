/* Program name: TestBorrower.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To test out the Borrower class for correct functionality
 */

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class TestBorrower {
    public static void main(String[] args) {
        // initialize variables
        Map<String, Book> borrower1Map = new TreeMap<>();
        LocalDate borrower1PublishingDate = LocalDate.of(2022, 9, 13);
        StringBuilder borrower1BookSummary = new StringBuilder();
        
        // we append the book summary to the StringBuilder
        borrower1BookSummary.append("This new exciting book has over 100 recipes in it!");

        // then we put everything in the map
        borrower1Map.put("New Recipe Guide", new Book(((long)19), "New Recipe Guide", "John", "Smith", borrower1PublishingDate, "1333333333333", 1.23, borrower1BookSummary, false));

        // we set up the borrower class
        Borrower borrower1 = new Borrower("Tina", "Smith", 9, 4809876543L, "jackson1@google.com", "800 NE Road", 0, "New York City", "NY", 48098, borrower1Map);

        // then we try out some things
        try {
            borrower1.setEmailAddress("emailAddress");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex);
        }

        try {
            borrower1.setState("ZZ");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex);
        }
        
        // then finally we use the toString() method

        System.out.println(borrower1.toString());

    }
}
