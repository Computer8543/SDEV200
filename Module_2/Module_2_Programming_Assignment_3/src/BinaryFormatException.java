/* Program name: BinaryFormatException.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/4/2024
 * Purpose: The BinaryFormatException class will serve as a custom exception for the App.java program, and will have two constructors.
 * One constructor will have an argument, and the other one won't. Both will call the NumberFormatException constructor(s) to do the heavy work.
 */

public class BinaryFormatException extends NumberFormatException {
    /* A no argument constructor that calls the no argument constructor of NumberFormatException */
    public BinaryFormatException() {
        super();
    }
    
    /* A constructor with a string argument that calls the string argument constructor of NumberFormatException */
    public BinaryFormatException(String argument) {
        super(argument);
    }
    
}
