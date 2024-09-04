/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/4/2024
 * Purpose: The App class will have a main method where the user inputs a binary number as a string and is shown it's decimal equivalent.
 * The bin2Dec function will do the heavy work of converting the binary string to an decimal number. 
 */

import java.util.Scanner; // Is used for user input

public class App {
    public static void main(String[] args) throws Exception {
        // try with resources block for user input
        try (Scanner input = new Scanner(System.in)) {
            // initialize variables
            String binaryString;
            int decimalValue;
            
            // prompt user to input binary string
            System.out.print("Input a binary string: ");
            binaryString = input.next();

            // use bin2Dec to translate the binary string into a decimal number if possible
            decimalValue = bin2Dec(binaryString);

            // displays the decimal equivalant to the binary number to the user
            System.out.println(decimalValue);
        }
        catch (BinaryFormatException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    /* This function first checks to see if the binaryString is actually a binary string. If it is not, it throws an custom exception.
     * If it is a binary string, it converts the binary string into a decimal value and returns that value.
     */
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // "[^01]" means if there is a character that isn't 0 or 1 in the string
        if (binaryString.matches("[^01]")) {
            throw new BinaryFormatException("Not a binary number");
        }
        else {
            // the radix is the base of the number system, thus the radix being set to 2 is because binary strings have a base of 2
            int decimalValue = Integer.parseInt(binaryString, 2);
            return decimalValue;
        }
    }
}
