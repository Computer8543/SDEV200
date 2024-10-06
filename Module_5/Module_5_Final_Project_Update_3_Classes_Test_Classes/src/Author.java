/* Program name: Person.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/2/2024
 * Purpose: To serve as an a class that holds information about the author, and the books they have written. 
 */
import java.util.Map;
import java.util.TreeMap;

public class Author extends Person {
    // attributes
    private long authorID;
    private Map<String, Book> booksWritten = new TreeMap<>();
    
    // constructor
    public Author(String firstName, String lastName, long authorID, Map<String, Book> booksWritten) throws IllegalArgumentException {
        // make sure the person class gets the first name and last name so that it can construct
        // also can't use a try catch block here, since super has to be the first statement in the constructor
        super(firstName, lastName);
        
        // if authorID is less than or equal to zero, throw an exception, else continue on
        if (authorID <= 0) {
            throw new IllegalArgumentException("The author ID must be greater than 0.");
        }
        else {
            // set this object's authorID attribute to the authorID parameter
            this.authorID = authorID;

            // if booksWritten is empty, throw an exception, else iterate over the tree map and perform a deep copy from the parameter
            // into the object's attribute
            if (booksWritten.isEmpty()) {
                throw new IllegalArgumentException("An author needs to have written and published at least one book to be an author.");
            }
            else {

                // A deep copy of the booksWritten parameter into this object's booksWritten attribute using a for each loop since the
                // parameter's memory location might end up being taken by garbage collection
                booksWritten.forEach((k,v) -> this.booksWritten.put(k, v));

            }
            
        }
    }

    // getters
    public long getAuthorID() {
        return authorID;
    }

    public Map<String, Book> getBooksWritten() {
        return booksWritten;
    }

    // setters
    public void setAuthorID(long authorID) throws IllegalArgumentException {
        // if authorID is less than or equal to zero, throw an exception, else continue on
        if (authorID <= 0) {
            throw new IllegalArgumentException("The author ID must be greater than 0.");
        }
        else {
            // set this object's authorID attribute to the authorID parameter
            this.authorID = authorID;
        }
    }

    public void setBooksWritten(Map<String, Book> booksWritten) throws IllegalArgumentException {
        // if booksWritten is empty, throw an exception, else iterate over the tree map and perform a deep copy from the parameter
        // into the object's attribute
        if (booksWritten.isEmpty()) {
            throw new IllegalArgumentException("An author needs to have written and published at least one book to be an author.");
        }
        else {
            // A deep copy of the booksWritten parameter into this object's booksWritten attribute using a for each loop since the
            // parameter's memory location might end up being taken by garbage collection
            booksWritten.forEach((k,v) -> this.booksWritten.put(k, v));
            
        }
    }

    // to string method
    @Override
    public String toString() {
        // intitialize variable
        StringBuilder authorString = new StringBuilder();

        // append to string builder
        authorString.append("Author ID: ");
        authorString.append(authorID);
        authorString.append(", Author's first name: ");
        authorString.append(getFirstName());
        authorString.append(", Author's last name: ");
        authorString.append(getLastName());
        authorString.append(", Number of Books the Author has written: ");
        authorString.append(booksWritten.size());
        authorString.append(", Titles of Books the Author has written: ");

        // use for each loop to append the titles of books the author has written with a comma to the authorString
        // problem is, that leaves a comma at the end of the last item instead of a period.
        booksWritten.forEach((k, v) -> authorString.append(k).append(", "));

        // we finally return the string from the stringbuilder
        return authorString.toString();
    }
    
}
