/* Program name: Circle.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/8/2024
 * Purpose: To create a circle class that extends GeometricObject and implements the Comparable interface
 */
public class Circle extends GeometricObject implements Comparable<Circle> {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius,
    String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }


    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override 
    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
        " and the radius is " + radius);
    }

    @Override
    /* Override equals method from Object class */
    public boolean equals(Object obj) {
        // If obj is an instance of Circle and this.radius == obj.radius, then return true, else return false.
        if ((obj instanceof Circle) == true && radius == ((Circle)obj).radius) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    /* Overload Comparable interface's compareTo function */ 
    public int compareTo(Circle o) {
        // if radius is greater than o.radius, return 1, if radius is less than o.radius, return -1, else return 0
        if (radius > o.radius) {
            return 1;
        }
        else if (radius < o.radius) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    /* We override the hashCode() function since we overrode the equals function. We start with the prime number of 7,
     * and multiply that by another prime number 31 and the integer conversion of the radius to get the hash code value.
     */
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash * (int) radius;
        System.out.println("hashCode() called - Computed hash: " + hash);
        return hash;
    }
    
}
