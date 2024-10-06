/* Program name: TestBook.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To test the Book class for correct functionality.
 */

import java.time.LocalDate;

public class TestBook {
    public static void main(String[] args) {
        // initialize variables
        LocalDate author1PublishingDate = LocalDate.of(2022, 9, 13);
        StringBuilder author1BookSummary = new StringBuilder();
        Book book1 = new Book(((long)19), "New Recipe Guide", "John", "Smith", author1PublishingDate, "1333333333333", 1.23, author1BookSummary, false);
        
        // test out methods

        // try unauthorized values
        try {
            book1.setDeweyDecimalLocation(-1.0); 
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        // setBookAvailable to true 
        book1.setBookAvailable(true);

        // see how that affects other boolean values
        System.out.println("Book Available: " + book1.getBookAvailable() + ", Book lost: " + book1.getBookLost() + ", Book Borrowed: " + book1.getBookBorrowed());

        // finally, let us print out toString()

        System.out.println(book1.toString());
    }       
}
    
