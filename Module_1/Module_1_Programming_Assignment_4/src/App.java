/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/26/2024
 * Purpose: This class will create three regular polygons utilizing a different constructor each while displaying the perimeter and area to the user.
 */
public class App {
    /* This is a test program that creates three regular polygon objects utilizing different constructors and 
     * displays their perimeter and length to the user.
     */
    public static void main(String[] args) throws Exception {
        // initialize variables
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // print all the polygons' perimeter and area
        System.out.println("Polygon 1 perimeter is " + Double.toString(polygon1.getPerimeter()) + " and area is " + Double.toString(polygon1.getArea()));
        System.out.println("Polygon 2 perimeter is " + Double.toString(polygon2.getPerimeter()) + " and area is " + Double.toString(polygon2.getArea()));
        System.out.println("Polygon 3 perimeter is " + Double.toString(polygon3.getPerimeter()) + " and area is " + Double.toString(polygon3.getArea()));
    }
}
