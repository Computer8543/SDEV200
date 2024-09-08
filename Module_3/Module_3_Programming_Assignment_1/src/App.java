/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/8/2024
 * Purpose: To test out the operations of the Circle class.
 */
public class App {
    public static void main(String[] args) throws Exception {
        // initialize variables
        Circle circle1 = new Circle(1.0);
        Circle circle2 = new Circle(1.0);
        Circle circle3 = new Circle(2.0);
        Circle circle4 = new Circle(0.5);

        // print out if circle 1 equals circle 2, and if circle 1 equals circle 3.
        System.out.println("Does Circle 1 equal Circle 2: " + circle1.equals(circle2));
        System.out.println("Does Circle 1 equal Circle 3: " + circle1.equals(circle3));

        // use compareTo() to figure out the relation of one circle to another
        System.out.println("What is Circle 1's relation to Circle 2: " + circle1.compareTo(circle2));
        System.out.println("What is Circle 1's relation to Circle 3: " + circle1.compareTo(circle3));
        System.out.println("What is Circle 1's relation to Circle 4: " + circle1.compareTo(circle4));
    }
}
