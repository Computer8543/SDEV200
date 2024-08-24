/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/23/2024
 * Purpose: To see if a credit card number is correct using the Luhn or Mod 10 check 
 * utilizing methods in a program.
 */

import java.util.Scanner; // Scanner object is used for user input

public class App {
    /* This class contains the entire application for this assignment. 
     * It checks the credit card number length first, then the prefix, and
     * finally it uses the Luhn or Mod 10 check to see if the credit card is valid.
     * If it is, the credit card number is shown as valid, if not it is shown as invalid.
     */
    
    // named constants
    public static final int VISACREDITCARDPREFIX = 4;
    public static final int MASTERCREDITCARDPREFIX = 5;
    public static final int AMERICANEXPRESSCREDITCARDPREFIX = 37;
    public static final int DISCOVERCREDITCARDPREFIX = 6;

    public static void main(String[] args) throws Exception {
        // initialize variables
        Scanner input = new Scanner(System.in);

        // prompt user to enter in credit card number
        System.out.println("Enter a credit card number as a long integer:");

        Long number = input.nextLong();  
        
        // close input scanner
        input.close();
        
        // check to see if credit card number is valid
        boolean validCreditCardNumber = isValid(number);
        
        // show user if credit card is valid or not
        if (validCreditCardNumber == true) {
            System.out.println(Long.toString(number) + " is valid");
        }
        else {
            System.out.println(Long.toString(number) + " is invalid");
        }

    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {

        // first we get the number of digits in the credit card number
        int numOfDigitsInCreditCardNumber = getSize(number);

        // if credit card length is between 13 and 16 digits, continue on
        // else return false
        if (numOfDigitsInCreditCardNumber < 13 || numOfDigitsInCreditCardNumber > 16) {
            return false;
        }

        // check to see if any of the prefixes match the credit card number, if they don't return false
        if (!(prefixMatched(number, VISACREDITCARDPREFIX) == true || prefixMatched(number, MASTERCREDITCARDPREFIX) == true || prefixMatched(number, AMERICANEXPRESSCREDITCARDPREFIX) == true || prefixMatched(number, DISCOVERCREDITCARDPREFIX) == true)) {
            return false;
        }
        
        // we get the sum of double even places
        int firstSum = sumOfDoubleEvenPlace(number);

        // we get the sum of odd places
        int secondSum = sumOfOddPlace(number);

        // we get the sum of both sums
        int sumOfBothSums = firstSum + secondSum;
        
        // if sumOfBothSums is divisable by 10, it is valid, otherwise it is not valid
        if (sumOfBothSums % 10 == 0) {
            return true;
        }
        else {
            return false;
        }

        
        
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        // first we convert the number into a string
        String numberString = String.valueOf(number);

        // then we get the size of the number
        int numberOfDigitsInTheCreditCardNumber = getSize(number);

        // then we get the even digits into integer form, double all of them, then return the sum of them
        // note: all the digits are counted from the right, not the left!
        switch (numberOfDigitsInTheCreditCardNumber) {
            case 13: {
                int secondDigit = Integer.parseInt(numberString.substring(11, 12));
                int fourthDigit = Integer.parseInt(numberString.substring(9, 10));
                int sixthDigit = Integer.parseInt(numberString.substring(7, 8));
                int eighthDigit = Integer.parseInt(numberString.substring(5, 6));
                int tenthDigit = Integer.parseInt(numberString.substring(3, 4));
                int twelvethDigit = Integer.parseInt(numberString.substring(1, 2));

                return (getDigit(secondDigit * 2) + getDigit(fourthDigit * 2) + getDigit(sixthDigit * 2) + getDigit(eighthDigit * 2) + getDigit(tenthDigit * 2) + getDigit(twelvethDigit * 2));
            }
            case 14: {
                int secondDigit = Integer.parseInt(numberString.substring(12, 13));
                int fourthDigit = Integer.parseInt(numberString.substring(10, 11));
                int sixthDigit = Integer.parseInt(numberString.substring(8, 9));
                int eighthDigit = Integer.parseInt(numberString.substring(6, 7));
                int tenthDigit = Integer.parseInt(numberString.substring(4, 5));
                int twelvethDigit = Integer.parseInt(numberString.substring(2, 3));
                int fourteenthDigit = Integer.parseInt(numberString.substring(0, 1));

                return (getDigit(secondDigit * 2) + getDigit(fourthDigit * 2) + getDigit(sixthDigit * 2) + getDigit(eighthDigit * 2) + getDigit(tenthDigit * 2) + getDigit(twelvethDigit * 2) + getDigit(fourteenthDigit * 2));
            }
            case 15:
            {
                int secondDigit = Integer.parseInt(numberString.substring(13, 14));
                int fourthDigit = Integer.parseInt(numberString.substring(11, 12));
                int sixthDigit = Integer.parseInt(numberString.substring(9, 10));
                int eighthDigit = Integer.parseInt(numberString.substring(7, 8));
                int tenthDigit = Integer.parseInt(numberString.substring(5, 6));
                int twelvethDigit = Integer.parseInt(numberString.substring(3, 4));
                int fourteenthDigit = Integer.parseInt(numberString.substring(1, 2));
                

                return (getDigit(secondDigit * 2) + getDigit(fourthDigit * 2) + getDigit(sixthDigit * 2) + getDigit(eighthDigit * 2) + getDigit(tenthDigit * 2) + getDigit(twelvethDigit * 2) + getDigit(fourteenthDigit * 2));
            }
            case 16: {
                int secondDigit = Integer.parseInt(numberString.substring(14, 15));
                int fourthDigit = Integer.parseInt(numberString.substring(12, 13));
                int sixthDigit = Integer.parseInt(numberString.substring(10, 11));
                int eighthDigit = Integer.parseInt(numberString.substring(8, 9));
                int tenthDigit = Integer.parseInt(numberString.substring(6, 7));
                int twelvethDigit = Integer.parseInt(numberString.substring(4, 5));
                int fourteenthDigit = Integer.parseInt(numberString.substring(2, 3));
                int sixteenthDigit = Integer.parseInt(numberString.substring(0, 1));

                return (getDigit(secondDigit * 2) + getDigit(fourthDigit * 2) + getDigit(sixthDigit * 2) + getDigit(eighthDigit * 2) + getDigit(tenthDigit * 2) + getDigit(twelvethDigit * 2) + getDigit(fourteenthDigit * 2) + getDigit(sixteenthDigit * 2));
            }
            default: {
                return -1;
            }
        }
    }
       
    /** Return this number if it is a single digit, otherwise,
    * return the sum of the two digits */
    public static int getDigit(int number) throws IllegalArgumentException {
        try {
            // change number into string
        String numberString = String.valueOf(number);

        // if the length of numberString is greater than 2
        // throw an IllegalArgumentException
        // if the length of numberString is equal to 2
        // return the sum of the two numbers 
        // else return the number
        if (numberString.length() > 2) {
            throw new IllegalArgumentException("numberString length cannot be greater than 2 digits long");
        }
        else if (numberString.length() == 2) {
            int firstDigit = Integer.parseInt(numberString.substring(0, 1));
            int secondDigit = Integer.parseInt(numberString.substring(1, 2));
            return (firstDigit + secondDigit);
        }
        else {
            return number;
        }

        // 
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return -1;
        }
        
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        // first we convert the number into a string
        String numberString = String.valueOf(number);

        // then we get the size of the number
        int numberOfDigitsInTheCreditCardNumber = getSize(number);

        // then we get the odd digits into integer form, then return the sum of them
        // note: all the digits are counted from the right, not the left!
        switch (numberOfDigitsInTheCreditCardNumber) {
            case 13: {
                int firstDigit = Integer.parseInt(numberString.substring(12, 13));
                int thirdDigit = Integer.parseInt(numberString.substring(10, 11));
                int fifthDigit = Integer.parseInt(numberString.substring(8, 9));
                int seventhDigit = Integer.parseInt(numberString.substring(6, 7));
                int ninthDigit = Integer.parseInt(numberString.substring(4, 5));
                int eleventhDigit = Integer.parseInt(numberString.substring(2, 3));
                int thirteenthDigit = Integer.parseInt(numberString.substring(0, 1 ));
                return (firstDigit + thirdDigit + fifthDigit + seventhDigit + ninthDigit + eleventhDigit + thirteenthDigit);
            }
            case 14: {
                int firstDigit = Integer.parseInt(numberString.substring(13, 14));
                int thirdDigit = Integer.parseInt(numberString.substring(11, 12));
                int fifthDigit = Integer.parseInt(numberString.substring(9, 10));
                int seventhDigit = Integer.parseInt(numberString.substring(7, 8));
                int ninthDigit = Integer.parseInt(numberString.substring(5, 6));
                int eleventhDigit = Integer.parseInt(numberString.substring(3, 4));
                int thirteenthDigit = Integer.parseInt(numberString.substring(1, 2));
                return (firstDigit + thirdDigit + fifthDigit + seventhDigit + ninthDigit + eleventhDigit + thirteenthDigit);
            }
            case 15:
            {
                int firstDigit = Integer.parseInt(numberString.substring(14, 15));
                int thirdDigit = Integer.parseInt(numberString.substring(12, 13));
                int fifthDigit = Integer.parseInt(numberString.substring(10, 11));
                int seventhDigit = Integer.parseInt(numberString.substring(8, 9));
                int ninthDigit = Integer.parseInt(numberString.substring(6, 7));
                int eleventhDigit = Integer.parseInt(numberString.substring(4, 5));
                int thirteenthDigit = Integer.parseInt(numberString.substring(2, 3));
                int fifteenthDigit = Integer.parseInt(numberString.substring(0, 1));
                return (firstDigit + thirdDigit + fifthDigit + seventhDigit + ninthDigit + eleventhDigit + thirteenthDigit + fifteenthDigit);
            }
            case 16: {
                int firstDigit = Integer.parseInt(numberString.substring(15, 16));
                int thirdDigit = Integer.parseInt(numberString.substring(13, 14));
                int fifthDigit = Integer.parseInt(numberString.substring(11, 12));
                int seventhDigit = Integer.parseInt(numberString.substring(9, 10));
                int ninthDigit = Integer.parseInt(numberString.substring(7, 8));
                int eleventhDigit = Integer.parseInt(numberString.substring(5, 6));
                int thirteenthDigit = Integer.parseInt(numberString.substring(3, 4));
                int fifteenthDigit = Integer.parseInt(numberString.substring(1, 2));
                return (firstDigit + thirdDigit + fifthDigit + seventhDigit + ninthDigit + eleventhDigit + thirteenthDigit + fifteenthDigit);
            }
            default: {
                return -1;
            }
        }
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        // get prefix for number 
        int prefixTwoDigits = Integer.parseInt(String.valueOf(getPrefix(number, 2)));
        int prefixOneDigit = Integer.parseInt(String.valueOf(getPrefix(number, 1)));

        // if prefix matches return true, else return false
        if (d == prefixOneDigit || d == prefixTwoDigits) {
            return true;
        }
        else {
            return false;
        }

    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        // we first convert the long number to a string
        String dString = Long.toString(d);
        
        // then we return the length of the string, 
        // which is the length of the number
        return dString.length();
    }

    /** Return the first k number of digits from number. If the
    * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) throws NumberFormatException, IllegalArgumentException {
        try {
            if (k < 0)
            {
                throw new IllegalArgumentException("k must be equal to or greater than 0");
            }

        // we first get the length of the number
        int numberLength = getSize(number);

        // then we check to see if the number of digits in number
        // is less than k, if so we return the number, if not
        // we continue on
        if (numberLength < k) {
            return number;
        }
        
        // we then convert number into a string so we can use the substring method
        String numberString = Long.toString(number);

        // we then extract a substring of that number with the size of k digits
        String numberSubString = numberString.substring(0, k);
        
        // we convert the numberSubString into a long number
        Long prefix = Long.valueOf(numberSubString);

        // we return the prefix 
        return prefix;


        } catch (NumberFormatException e) {
            // we print out the error for the user and return -1 so we know something is wrong
            System.out.println(e);
            return -1;
        }
        catch (IllegalArgumentException e) {
            // we print out the error for the user
            System.out.println(e);
            return -1;
        }
        
    }
}
