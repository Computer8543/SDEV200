/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/2/2024
 * Purpose: To create a test program that creates a triangle instance based on user input. The user is prompted to input the three
 * sides, the color, and a Boolean value to see if the triangle is filled or not. These properties are then displayed to the user.
 */

import java.util.Scanner; // used to get input from the user

public class App {
    public static void main(String[] args) throws Exception {
        // use try with resources block to automatically terminate the input variable
        try (Scanner input = new Scanner(System.in)) {
          // initialize variables
        double side1;
        double side2;
        double side3;
        String color;
        boolean filled;
        
        // prompt user to input three sides 
        System.out.println("Input the length of side 1 of the triangle: ");
        side1 = input.nextDouble();
        System.out.println("Input the length of side 2 of the triangle: ");
        side2 = input.nextDouble();
        System.out.println("Input the length of side 3 of the triangle: ");
        side3 = input.nextDouble();

        // create triangle object with sides
        Triangle triangle = new Triangle(side1, side2, side3);

        // set triangle color based on user input
        System.out.println("Set the triangle's color: ");
        color = input.next(); // since you should never put a line getting input method after a token getting input method, this only gets one complete token.
        triangle.setColor(color);
        
        // set triangle filled boolean value based on user input
        System.out.println("Set the triangle's filled value as a boolean (true or false): ");
        filled = input.nextBoolean();
        triangle.setFilled(filled);

        // display properties of triangle to the user
        System.out.println("Area of triangle: " + triangle.getArea());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
        System.out.println("Color of triangle: " + triangle.getColor());
        System.out.println("Is the triangle filled?: " + triangle.isFilled());


        } catch (Exception e) {
            // print out exception to the console
            System.out.println(e);
        }
        

    }
}
