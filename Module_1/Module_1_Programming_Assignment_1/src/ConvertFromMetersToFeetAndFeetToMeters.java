/* Program name: ConvertFromMetersToFeetAndFeetToMeters.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/21/2024
 * Purpose: To make a class that converts feet to meters and meters to feet.
 */

public class ConvertFromMetersToFeetAndFeetToMeters {
   /* This class converts between meters and feet utilizing constant conversion
    * attributes and conversion methods
    */

    // constant attributes
    public static final double FOOTTOMETERCONVERSIONNUMBER = 0.305;
    public static final double METERTOFOOTCONVERSIONNUMBER = 3.279;

    // methods
    public double footToMeter(double foot) {
       double meter = FOOTTOMETERCONVERSIONNUMBER * foot;
       return meter;
    }
 
    public double meterToFoot(double meter) {
       double foot = METERTOFOOTCONVERSIONNUMBER * meter;
       return foot;
    } 
}