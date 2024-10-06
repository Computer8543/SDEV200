/* Program name: TestAuthor.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To test the Author class for correct functionality.
 */
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class TestAuthor {
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

        // we test out 3 of the getters
        System.out.println("Author ID: " + author1.getAuthorID() + ", and Author first name: " + author1.getFirstName() + ", and Author last name: " + author1.getLastName());

        // then test out the fourth getter
        Map<String, Book> author1Map2 = author1.getBooksWritten();

        author1Map2.forEach((k, v) -> System.out.println(k + v.toString()));

        // we then test out the setters with unauthorized values
        try {
            author1.setAuthorID(((long)(0)));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        try {
            author1.setBooksWritten(new TreeMap<>());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        // then we try authorized values

        try {
            author1.setAuthorID(((long)(1)));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        try {
            author1.setBooksWritten(author1Map2);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }

        // then we finally toString everything
        System.out.println(author1.toString());
    }
}
