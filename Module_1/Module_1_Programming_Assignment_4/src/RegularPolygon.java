/* Program name: RegularPolygon.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/25/2024
 * Purpose: This class will create a regular polygon and allow the user to adjust the parameters of that polygon utilizing methods.
 */

public class RegularPolygon {
    // initialize default attributes
    private int n = 3; // number of sides in the polygon
    private double side = 1; // side length
    private double x = 0; // x-coordinate of the polygon's center 
    private double y = 0; // y-coordinate of the polygon's center

    // methods

    // constructors

    /* This constructor is a no-argument constructor initializing the regular polygon with default values */
    public RegularPolygon() {}

    /* This constructor creates a regular polygon with the specified number of sides and side length centered around the coordinates (0, 0)  */
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    /* This constructor creates a regular polygon with the specified number of sides, side length, and x and y coordinates */
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // accessor methods

    /* This accessor method returns the number of sides in the regular polygon */
    public int getNumberOfSides() {
        return n;
    }

    /* This accessor method returns the side length of the regular polygon */
    public double getLengthOfSide() {
        return side;
    }

    /* This accessor method returns the x-coordinate of the regular polygon's center */
    public double getXCoordinate() {
        return x;
    }

    /* This accessor method returns the y-coordinate of the regular polygon's center */
    public double getYCoordinate() {
        return y;
    }

    /* This accessor method computes and returns the perimeter of the regular polygon */
    public double getPerimeter() {
        return (n * side);
    }

    /* This accessor method computes and returns the area of the regular polygon */
    public double getArea() {
        return ((n * Math.pow(side, 2.0)) / (4 * Math.tan((Math.PI / n))));
    }
    // mutator methods

    /* This mutator method sets the number of sides in the regular polygon */
    public void setNumberOfSides(int n) {
        this.n = n;
    }

    /* This mutator method sets the side length of the regular polygon */
    public void setLengthOfSide(double side) {
        this.side = side;
    }

    /* This mutator method sets the x-coordinate of the regular polygon's center */
    public void setXCoordinate(double x) {
        this.x = x;
    }

    /* This mutator method sets the y-coordinate of the regular polygon's center */
    public void setYCoordinate(double y) {
        this.y = y;
    }


}
