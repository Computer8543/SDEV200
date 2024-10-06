/* Program name: Book.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To track the book information for the library
 */

import java.time.LocalDate;

public class Book {
    // constant attributes
    public final int TITLELENGTH = 100;
    public final int MAXCHARACTERLIMIT = 50;
    public final int ISBNLENGTH = 13;
    public final int DEWEYDECIMALBEGINNING = 0;
    public final int DEWEYDECIMALEND = 1000;
    public final int BOOKSUMMARYLENGTH = 2000;

    // variable attributes
    private long bookID;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private LocalDate publishingDate;
    private String ISBN;
    private double deweyDecimalLocation;
    private StringBuilder bookSummary;
    private boolean bookDamaged;
    private boolean bookBorrowed;
    private boolean bookLost;
    private boolean bookAvailable;
    private LocalDate[] bookBorrowedTime = new LocalDate[2];
    private static int numberOfBooksInTheLibrary;

    // constructor
    public Book(long bookID, String title, String authorFirstName, String authorLastName, LocalDate publishingDate, String ISBN, double deweyDecimalLocation, StringBuilder bookSummary, boolean bookDamaged) throws IllegalArgumentException {
        // if else nested structure that does some light input verification before setting the attributes equal to the parameters
        if (bookID <= 0) {
            throw new IllegalArgumentException("The book ID must be greater than 0.");
        }
        else {
            this.bookID = bookID;

            if (title.length() > TITLELENGTH) {
                throw new IllegalArgumentException("Title must not exceed 100 characters.");
            }
            else {
                this.title = title;

                if (authorFirstName.length() > MAXCHARACTERLIMIT) {
                    throw new IllegalArgumentException("Author's first name cannot exceed 50 characters.");
                }
                else {
                    this.authorFirstName = authorFirstName;

                    if (authorLastName.length() > MAXCHARACTERLIMIT) {
                        throw new IllegalArgumentException("Author's last name cannot exceed 50 characters.");
                    }
                    else {
                        this.authorLastName = authorLastName;
                        
                        // if the publishing date is after the current date, then throw an IllegalArgumentException
                        if (publishingDate.isAfter(LocalDate.now())) {
                            throw new IllegalArgumentException("The publishing date of the book cannot be after the current time.");
                        }
                        else {
                            this.publishingDate = publishingDate;

                            if (ISBN.length() != ISBNLENGTH) {
                                throw new IllegalArgumentException("The ISBN must be 13 digits long.");
                            }
                            else {
                                this.ISBN = ISBN;

                                if (((int)(Math.round(deweyDecimalLocation))) < DEWEYDECIMALBEGINNING || ((int)(Math.round(deweyDecimalLocation))) > DEWEYDECIMALEND) {
                                    throw new IllegalArgumentException("The Dewey Decimal Location must be between 0 and 1000.");
                                }
                                else {
                                    this.deweyDecimalLocation = deweyDecimalLocation;

                                    if (bookSummary.length() > BOOKSUMMARYLENGTH) {
                                        throw new IllegalArgumentException("Book Summary must not exceed 2000 characters");
                                    }
                                    else {
                                        this.bookSummary = bookSummary;

                                        // no input verification needed for a boolean
                                        this.bookDamaged = bookDamaged;

                                        // the book was just put into the systems, so we set the bookBorrowed and bookLost to false
                                        bookBorrowed = false;
                                        bookLost = false;

                                        // we then set bookAvailable to true since it is in the system
                                        bookAvailable = true;

                                        // then we set book borrowed time to now, since nobody has borrowed it yet
                                        // index 0 is the beginning time, index 1 is the ending time of the borrowing of the book
                                        bookBorrowedTime[0] = LocalDate.now();
                                        bookBorrowedTime[1] = LocalDate.now();

                                        // finally we increase the number of books in the library by 1
                                        numberOfBooksInTheLibrary++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    // getters
    public long getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getDeweyDecimalLocation() {
        return deweyDecimalLocation;
    }

    public StringBuilder getBookSummary() {
        return bookSummary;
    }

    public boolean getBookDamaged() {
        return bookDamaged;
    }

    public boolean getBookBorrowed() {
        return bookBorrowed;
    }

    public boolean getBookLost() {
        return bookLost;
    }

    public boolean getBookAvailable() {
        return bookAvailable;
    }

    public LocalDate[] getBookBorrowedTime() {
        return bookBorrowedTime;
    }

    public static int getNumberOfBooksInTheLibrary() {
        return numberOfBooksInTheLibrary;
    }

    // setters
    public void setBookID(long bookID) throws IllegalArgumentException {
        if (bookID <= 0) {
            throw new IllegalArgumentException("The book ID must be greater than 0.");
        }
        else {
            this.bookID = bookID;
        }
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.length() > TITLELENGTH) {
            throw new IllegalArgumentException("Title must not exceed 100 characters.");
        }
        else {
            this.title = title;
        }
    }

    public void setAuthorFirstName(String authorFirstName) throws IllegalArgumentException {
        if (authorFirstName.length() > MAXCHARACTERLIMIT) {
            throw new IllegalArgumentException("Author's first name cannot exceed 50 characters.");
        }
        else {
            this.authorFirstName = authorFirstName;
        }
    }

    public void setAuthorLastName(String authorLastName) throws IllegalArgumentException {
        if (authorLastName.length() > MAXCHARACTERLIMIT) {
            throw new IllegalArgumentException("Author's last name cannot exceed 50 characters.");
        }
        else {
            this.authorLastName = authorLastName;
        }
    }

    public void setPublishingDate(LocalDate publishingDate) throws IllegalArgumentException {
        // if the publishing date is after the current date, then throw an IllegalArgumentException
        if (publishingDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The publishing date of the book cannot be after the current time.");
        }
        else {
            this.publishingDate = publishingDate;
        }
    }

    public void setISBN(String ISBN) throws IllegalArgumentException {
        if (ISBN.length() != ISBNLENGTH) {
            throw new IllegalArgumentException("The ISBN must be 13 digits long.");
        }
        else {
            this.ISBN = ISBN;
        }
    }

    public void setDeweyDecimalLocation(double deweyDecimalLocation) throws IllegalArgumentException {
        if (((int)(Math.round(deweyDecimalLocation))) < DEWEYDECIMALBEGINNING || ((int)(Math.round(deweyDecimalLocation))) > DEWEYDECIMALEND) {
            throw new IllegalArgumentException("The Dewey Decimal Location must be between 0 and 1000.");
        }
        else {
            this.deweyDecimalLocation = deweyDecimalLocation;
        }
    }

    public void setBookSummary(StringBuilder bookSummary) throws IllegalArgumentException {
        if (bookSummary.length() > BOOKSUMMARYLENGTH) {
            throw new IllegalArgumentException("Book Summary must not exceed 2000 characters");
        }
        else {
            this.bookSummary = bookSummary;
        }
    }
    
    // todo: create some logic that ensures that if a book is borrowed or lost, then it is not available and vice versa.
    public void setBookDamaged(boolean bookDamaged) {
        this.bookDamaged = bookDamaged;
    }

    public void setBookBorrowed(boolean bookBorrowed) {
        if (bookBorrowed == true) {
            bookAvailable = false;
            this.bookBorrowed = bookBorrowed;
        }
        else {
            this.bookBorrowed = bookBorrowed;
        }

        
    }

    public void setBookLost(boolean bookLost) {
        if (bookLost == true) {
            bookAvailable = false;
            this.bookLost = bookLost;
        }
        else {
            this.bookLost = bookLost;
        }
        
    }

    public void setBookAvailable(boolean bookAvailable) {
        if (bookAvailable == true) {
            bookLost = false;
            bookBorrowed = false;
            this.bookAvailable = bookAvailable;
        }
        else {
            this.bookAvailable = bookAvailable;
        }
        
    }

    public void setBookBorrowedTime(LocalDate[] bookBorrowedTime) throws IllegalArgumentException {
        // if booksBorrowedTime[1] is after bookBorrowedTime[2] and bookBorrowedTime[0] plus 1 month is equal to bookBorrowedTime[1], then copy over the array.
        if (bookBorrowedTime[1].isAfter(bookBorrowedTime[0]) && bookBorrowedTime[0].plusMonths(1).equals(bookBorrowedTime[1])) {
            // make a deep copy of the parameter into the attribute
            System.arraycopy(bookBorrowedTime, 0, this.bookBorrowedTime, 0, 2);
        }
        else {
            throw new IllegalArgumentException("The time when the book borrowing period is over is one month after it has begun."); 
        }
    }

    // toString method override
    @Override
    public String toString() {
        // initialize StringBuilder
        StringBuilder bookString = new StringBuilder();

        // build string
        bookString.append("Book ID: ");
        bookString.append(bookID);
        bookString.append(", Title: ");
        bookString.append(title);
        bookString.append(", Author First Name: ");
        bookString.append(authorFirstName);
        bookString.append(", Author Last Name: ");
        bookString.append(authorLastName);
        bookString.append(", Publishing Date: ");
        bookString.append(publishingDate.toString());
        bookString.append(", ISBN: ");
        bookString.append(ISBN);
        bookString.append(", Dewey Decimal Location: ");
        bookString.append(deweyDecimalLocation);
        bookString.append(", Book Summary: ");
        bookString.append(bookSummary.toString());
        bookString.append(", Book Damaged: ");
        bookString.append(bookDamaged);
        bookString.append(", Book Borrowed: ");
        bookString.append(bookBorrowed);
        bookString.append(", Book Lost: ");
        bookString.append(bookLost);
        bookString.append(", Book Available: ");
        bookString.append(bookAvailable);
        bookString.append(", Book is borrowed from: ");
        bookString.append(bookBorrowedTime[0].toString());
        bookString.append(", to: ");
        bookString.append(bookBorrowedTime[1].toString());
        bookString.append(", Number of books in the library: ");
        bookString.append(numberOfBooksInTheLibrary);

        // return string
        return bookString.toString();
    }

}
