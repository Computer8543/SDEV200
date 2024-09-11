/* Program name: Test.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/11/2024
 * Purpose: To create a test program for the Rational data type where the user enters two rational numbers and is shown the results.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        // initialize variables
        BigInteger firstRationalNumberNumerator;
        BigInteger firstRationalNumberDenominator;
        BigInteger secondRationalNumberNumerator;
        BigInteger secondRationalNumberDenominator;

        // we use a try with resources loop to ensure that our input closes automatically at the end.
        try (Scanner input = new Scanner(System.in)) {
            // we prompt the user to enter in the first rational number in two parts, the numerator and the denominator
            System.out.print("Enter the first rational number: ");
            firstRationalNumberNumerator = input.nextBigInteger();
            firstRationalNumberDenominator = input.nextBigInteger();
            System.out.println();

            // we prompt the user to enter in the second rational number in two parts, the numerator and the denominator
            System.out.print("Enter the second rational number: ");
            secondRationalNumberNumerator = input.nextBigInteger();
            secondRationalNumberDenominator = input.nextBigInteger();
            System.out.println();
        }

        // then we create our two new Rational objects
        Rational firstRationalNumber = new Rational(firstRationalNumberNumerator, firstRationalNumberDenominator);
        Rational secondRationalNumber = new Rational(secondRationalNumberNumerator, secondRationalNumberDenominator);
        
        // then we print out the addition operation, the subtraction operation, the multiplication operation, and the division operation
        // taking place on our first rational number and second rational number and the results of those operations.
        System.out.println(firstRationalNumber.toString() + " + " + secondRationalNumber.toString() + " = " + (firstRationalNumber.add(secondRationalNumber)).toString());
        System.out.println(firstRationalNumber.toString() + " - " + secondRationalNumber.toString() + " = " + (firstRationalNumber.subtract(secondRationalNumber)).toString());
        System.out.println(firstRationalNumber.toString() + " * " + secondRationalNumber.toString() + " = " + (firstRationalNumber.multiply(secondRationalNumber)).toString());
        System.out.println(firstRationalNumber.toString() + " / " + secondRationalNumber.toString() + " = " + (firstRationalNumber.divide(secondRationalNumber)).toString());

        // we then print the double value of the first and second rational number
        System.out.println(firstRationalNumber.toString() + " is " + String.valueOf(firstRationalNumber.floatValue()));
        System.out.println(secondRationalNumber.toString() + " is " + String.valueOf(secondRationalNumber.floatValue()));
    }
}
