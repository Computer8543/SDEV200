/* Program name: Borrower.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/6/2024
 * Purpose: To track the borrower information for the library
 */

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Borrower extends Person {
    // constant attributes, todo: put in all caps
    public final int PHONENUMBERLENGTH = 10;
    public final int ZIPCODELENGTH = 5;
    public final int NUMBEROFBOOKSBORROWABLE = 3;
    public final int MAXCHARACTERLIMIT = 50;
    public final int APARTMENTINTEGERLENGTH = 10;
    public final int STATEABBREVIATIONLENGTH = 2;
    public final int NUMBEROFSTATES = 50;
    public final String[] STATEABBREVIATIONS = { "AL",
        "AK",
        "AZ",
        "AR",
        "CA",
        "CO",
        "CT",
        "DE",
        "FL",
        "GA",
        "HI",
        "ID",
        "IL",
        "IN",
        "IA",
        "KS",
        "KY",
        "LA",
        "ME",
        "MD",
        "MA",
        "MI",
        "MN",
        "MS",
        "MO",
        "MT",
        "NE",
        "NV",
        "NH",
        "NJ",
        "NM",
        "NY",
        "NC",
        "ND",
        "OH",
        "OK",
        "OR",
        "PA",
        "RI",
        "SC",
        "SD",
        "TN",
        "TX",
        "UT",
        "VT",
        "VA",
        "WA",
        "WV",
        "WI",
        "WY"};

    // variable attributes
    private long borrowerID;
    private long phoneNumber;
    private String emailAddress;
    private String street;
    private int apartmentNumber;
    private String city;
    private String state; // changed the data type for the methods I could use on it
    private int zipcode;
    private Map<String, Book> booksBorrowed = new TreeMap<>();
    private Date dateOfBeginningLibraryMembership;
    
    // methods

    // constructor

    /* I decided to not put the first constructor in since it didn't contain enough information about the person borrowing the books. */
    public Borrower(String firstName, String lastName, long borrowerID, long phoneNumber, String emailAddress, String street, int apartmentNumber, String city, String state, int zipcode, Map<String, Book> booksBorrowed) throws IllegalArgumentException {
        // call Person constructor with arguments
        super(firstName, lastName);

        // basically this code is a long nested sequence of if statements that does some light input verification before 
        // setting the attributes of the class to the constructor's parameters. 
        // Incorrect information leads to an IllegalArgumentException being thrown and stopping the program.
        if (borrowerID <= 0) {
            throw new IllegalArgumentException("The borrower ID must be greater than 0.");
        }
        else {
            this.borrowerID = borrowerID;

            // if phone number length is not 10, then throw an IllegalArgument exception
            if (Long.toString(phoneNumber).length() != PHONENUMBERLENGTH) {
                throw new IllegalArgumentException("The phone number must be 10 digits long");
            }
            else {
                this.phoneNumber = phoneNumber;
                
                // basically if the email address is just an empty string, or too long, 
                // or the email address doesn't match something @ something . something 
                // then an IllegalArgumentException will be thrown.
                // original regex: ".*@{1}.*\\.\\.{3}"
                if (emailAddress.equals("")) {
                    throw new IllegalArgumentException("The email address cannot be an empty string");
                }
                else if (emailAddress.length() > MAXCHARACTERLIMIT) {
                    throw new IllegalArgumentException("The email address cannot be more than 50 characters.");
                }
                else if ((!(emailAddress.matches("\\.\\*@\\{1\\}\\.\\*\\\\\\.\\\\\\.\\{3\\}")))) {
                    throw new IllegalArgumentException("The email address has to be formatted correctly.");
                }
                else {
                    this.emailAddress = emailAddress;
                    if (street.equals("")) {
                        throw new IllegalArgumentException("The street cannot be an empty string");
                    }
                    else if (street.length() > MAXCHARACTERLIMIT) {
                        throw new IllegalArgumentException("The street cannot be more than 50 characters.");
                    }
                    else {
                        this.street = street;

                        if (apartmentNumber < 0) {
                            throw new IllegalArgumentException("The apartment number cannot be less than 0.");
                        }
                        else if (Integer.toString(apartmentNumber).length() > APARTMENTINTEGERLENGTH) {
                            throw new IllegalArgumentException("The apartment number cannot be more than 10 digits long");
                        }
                        else {
                            this.apartmentNumber = apartmentNumber;

                            if (city.equals("")) {
                                throw new IllegalArgumentException("The city cannot be an empty string");
                            }
                            else if (city.length() > MAXCHARACTERLIMIT) {
                                throw new IllegalArgumentException("The city cannot be more than 50 characters.");
                            }
                            else {
                                this.city = city;
                                
                                // initialize variable
                                boolean stateAbbrevationValid = false;

                                // we check to see if state abbreviations are equal to a valid abbrevation
                                for (int i = 0; i < NUMBEROFSTATES; i++) {
                                    if (state.equals(STATEABBREVIATIONS[i])) {
                                        stateAbbrevationValid = true;
                                        break;
                                    }
                                }


                                if (state.length() != STATEABBREVIATIONLENGTH) {
                                    throw new IllegalArgumentException("State abbreviation can only be 2 characters long.");
                                }
                                else if (stateAbbrevationValid == false) {
                                    throw new IllegalArgumentException("State abbreviation must be valid.");
                                }
                                else {
                                    this.state = state;
                                    
                                    if (Integer.toString(zipcode).length() != ZIPCODELENGTH) {
                                        throw new IllegalArgumentException("The zipcode must be 5 digits long.");
                                    }
                                    else {
                                        this.zipcode = zipcode;
    
                                        if (booksBorrowed.size() > NUMBEROFBOOKSBORROWABLE) {
                                            throw new IllegalArgumentException("Only three books can be borrowed at a time.");
                                        }
                                        else {
                                            // populate booksBorrowed attribute with booksBorrowed constructor parameter with a for each loop
                                            booksBorrowed.forEach((k,v) -> this.booksBorrowed.put(k, v));
    
                                            // set up date of beginning library membership set to the current time
                                            dateOfBeginningLibraryMembership = new Date();
                                        }
    
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
    public long getBorrowerID() {
        return borrowerID;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStreet() {
        return street;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public Map<String, Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public Date getDateOfBeginningLibraryMembership() {
        return dateOfBeginningLibraryMembership;
    }

    // setters

    public void setBorrowerID(long borrowerID) throws IllegalArgumentException {
        if (borrowerID <= 0) {
            throw new IllegalArgumentException("The borrower ID must be greater than 0.");
        }
        else {
            this.borrowerID = borrowerID;
        }
    }

    public void setPhoneNumber(long phoneNumber) throws IllegalArgumentException {
        // if phone number length is not 10, then throw an IllegalArgument exception
        if (Long.toString(phoneNumber).length() != PHONENUMBERLENGTH) {
            throw new IllegalArgumentException("The phone number must be 10 digits long");
        }
        else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setEmailAddress(String emailAddress) throws IllegalArgumentException {
        // basically if the email address is an empty string, above 50 characters long, or doesn't match the format of
        // something @ something . something then a IllegalArgumentException will be thrown, else we set the attribute equal to the parameter. 
        if (emailAddress.equals("")) {
            throw new IllegalArgumentException("The email address cannot be an empty string");
        }
        else if (emailAddress.length() > MAXCHARACTERLIMIT) {
            throw new IllegalArgumentException("The email address cannot be more than 50 characters.");
        }
        else if ((!(emailAddress.matches("\\.\\*@\\{1\\}\\.\\*\\\\\\.\\\\\\.\\{3\\}")))) {
            throw new IllegalArgumentException("The email address has to be formatted correctly.");
        }
        else {
            this.emailAddress = emailAddress;
        }
    }

    public void setStreet(String street) throws IllegalArgumentException {
        if (street.equals("")) {
            throw new IllegalArgumentException("The street cannot be an empty string");
        }
        else if (street.length() > MAXCHARACTERLIMIT) {
            throw new IllegalArgumentException("The street cannot be more than 50 characters.");
        }
        else {
            this.street = street;
        }
    }

    public void setApartmentNumber(int apartmentNumber) throws IllegalArgumentException {
        if (apartmentNumber < 0) {
            throw new IllegalArgumentException("The apartment number cannot be less than 0.");
        }
        else if (Integer.toString(apartmentNumber).length() > APARTMENTINTEGERLENGTH) {
            throw new IllegalArgumentException("The apartment number cannot be more than 10 digits long");
        }
        else {
            this.apartmentNumber = apartmentNumber;
        }
    }

    public void setCity(String city) throws IllegalArgumentException {
        if (city.equals("")) {
            throw new IllegalArgumentException("The city cannot be an empty string");
        }
        else if (city.length() > MAXCHARACTERLIMIT) {
            throw new IllegalArgumentException("The city cannot be more than 50 characters.");
        }
        else {
            this.city = city;
        }
    }

    public void setState(String state) throws IllegalArgumentException {
         // initialize variable
         boolean stateAbbrevationValid = false;

         // we check to see if state abbreviations are equal to a valid abbrevation
         for (int i = 0; i < NUMBEROFSTATES; i++) {
             if (state.equals(STATEABBREVIATIONS[i])) {
                 stateAbbrevationValid = true;
                 break;
             }
         }

         // if the state isn't equal to 2 characters, or it isn't a valid state abbreviation, then we throw an IllegalArgumentException
         // else we set the attribute equal to the parameter
         if (state.length() != STATEABBREVIATIONLENGTH) {
             throw new IllegalArgumentException("State abbreviation can only be 2 characters long.");
         }
         else if (stateAbbrevationValid == false) {
             throw new IllegalArgumentException("State abbreviation must be valid.");
         }
         else {
            this.state = state;
         }
    }

    public void setZipcode(int zipcode) throws IllegalArgumentException {
        if (Integer.toString(zipcode).length() != ZIPCODELENGTH) {
            throw new IllegalArgumentException("The zipcode must be 5 digits long.");
        }
        else {
            this.zipcode = zipcode;
        }
    }
    
    public void setBooksBorrowed(Map<String, Book> booksBorrowed) throws IllegalArgumentException {
        // if the books borrowed is more than three, then throw an IllegalArgumentException
        if (booksBorrowed.size() > NUMBEROFBOOKSBORROWABLE) {
            throw new IllegalArgumentException("Only three books can be borrowed at a time.");
        }
        else {
            // populate booksBorrowed attribute with booksBorrowed constructor parameter with a for each loop
            booksBorrowed.forEach((k,v) -> this.booksBorrowed.put(k, v));
        }
    }

    // toString method
    @Override
    public String toString() {
        // initialize StringBuilder
        StringBuilder borrowerString = new StringBuilder();

        // build string
        borrowerString.append("Borrower ID: ");
        borrowerString.append(borrowerID);
        borrowerString.append(", First Name: ");
        borrowerString.append(getFirstName());
        borrowerString.append(", Last Name: ");
        borrowerString.append(getLastName());
        borrowerString.append(", Phone Number: ");
        borrowerString.append(phoneNumber);
        borrowerString.append(", Email Address: ");
        borrowerString.append(emailAddress);
        borrowerString.append(", Street: ");
        borrowerString.append(street);
        borrowerString.append(", Apartment Number: ");
        borrowerString.append(apartmentNumber);
        borrowerString.append(", City: ");
        borrowerString.append(city);
        borrowerString.append(", State: ");
        borrowerString.append(state);
        borrowerString.append(", Zipcode: ");
        borrowerString.append(zipcode);
        borrowerString.append(", Books Borrowed: ");

        // for each loop to append the titles of the books borrowed
        booksBorrowed.forEach((k,v) -> borrowerString.append(k).append(", "));

        // final attribute to add into the StringBuilder
        borrowerString.append("Date they signed up for the library: ");
        borrowerString.append(dateOfBeginningLibraryMembership.toString());

        // return string
        return borrowerString.toString();
    }
}
