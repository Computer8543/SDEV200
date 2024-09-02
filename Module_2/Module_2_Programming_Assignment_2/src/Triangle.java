/* Program name: Triangle.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/2/2024
 * Purpose: To create an class that extends the GeometricObject class so that it can serve as a representation of a triangle, where you can
 * get the three sides length, the area, the perimeter, the string representation of the Triangle instance, and create the object in two different ways.
 */

public class Triangle extends GeometricObject {
    // class attributes
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // class methods

    /* No argument constructor that creates a default triangle */
    public Triangle() {
        // to access the no argument GeometricObject constructor
        super();

        // nothing else, since it is a default triangle that we are making
    }

    /* A constructor that creates a triangle with the specified side1, side2, and side3. */
    public Triangle(double side1, double side2, double side3) {
        // to access the no argument GeometricObject constructor
        super();

        // initialize attributes using argument variables
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /* Accessor method for side 1 */
    public double getSide1() {
        return side1;
    }

    /* Accessor method for side 2 */
    public double getSide2() {
        return side2;
    }

    /* Accessor method for side 3 */
    public double getSide3() {
        return side3;
    }

    /* A method that returns the area of the triangle, and overrides the GeometricObject getArea() abstract method */
    @Override
    public double getArea() {
        // intitialize variable
        double s = ((side1 + side2 + side3) / 2);
        
        // return area
        return Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)));
    }
    
    /* A method that returns the perimeter of the triangle, and overrides the GeometricObject getPerimeter() abstract method */
    @Override
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }

    /* A method that returns a string description of the triangle that overrides the Object class toString() method */
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
        " side3 = " + side3;
    }
}
