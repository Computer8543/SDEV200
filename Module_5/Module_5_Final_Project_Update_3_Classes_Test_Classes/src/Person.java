/* Program name: Person.java
 * Author: Kyle Ingersoll
 * Date last updated: 10/2/2024
 * Purpose: To serve as an abstract superclass for the Author and Borrower classes 
 */
public abstract class Person {
    // attributes
    private String firstName;
    private String lastName;

    // methods

    /* Note, I won't be implementing the Person no arg constructor because I realized that creating a person with no name or a generic name 
     * wouldn't be good for a database application and data integrity. 
     */

    // constructor
    protected Person(String firstName, String lastName) throws IllegalArgumentException {
        // make sure the first name isn't more than 50 characters long
        if (firstName.length() > 50) {
            throw new IllegalArgumentException("The first name cannot be more than 50 characters.");
        }
        else {
            this.firstName = firstName;
        }
        
        if (lastName.length() > 50) {
            throw new IllegalArgumentException("The last name cannot be more than 50 characters.");
        }
        else {
            this.lastName = lastName;
        }
        
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    // setters
    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.length() > 50) {
            throw new IllegalArgumentException("The first name cannot be more than 50 characters.");
        }
        else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() > 50) {
            throw new IllegalArgumentException("The last name cannot be more than 50 characters.");
        }
        else {
            this.lastName = lastName;
        }
    }

    // to string method is overridden and made abstract
    @Override
    public abstract String toString();
}