/* Program name: TestPerson.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To test out the abstract Person class through it's concrete subclasses.
 */

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class TestPerson {
    public static void main(String[] args) {
        // initialize variables 
        Map<String, Book> author1Map = new TreeMap<>();
        LocalDate author1PublishingDate = LocalDate.of(2022, 9, 13);
        StringBuilder author1BookSummary = new StringBuilder();
        
        // we append the book summary to the StringBuilder
        author1BookSummary.append("This new exciting book has over 100 recipes in it!");

        // then we put everything in the map
        author1Map.put("New Recipe Guide", new Book(((long)19), "New Recipe Guide", "John", "Smith", author1PublishingDate, "1333333333333", 1.23, author1BookSummary, false));

        // finally we put the map inside the Author class
        Author author1 = new Author("John", "Smith", ((long)19), author1Map);

        // we then try out methods in the person class
        author1.setFirstName("James");
        author1.setLastName("Jackson");

        // we finally print out the Author toString(), to verify our changes
        System.out.println(author1.toString());
    }
}
