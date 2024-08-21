/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/21/2024
 * Purpose: To make a test program that converts between feet and meters
 */
public class App {
    /* The part of the program that runs the test data and creates the table
     * note: I can't get the results for the Meters to Feet conversion to exactly
     * match the table utilizing the conversion factor given to us by the textbook.
     */
    public static void main(String[] args) throws Exception {
        // intitialize variables
        double feet = 1.0;
        double meters = 20.0;
        final double FEETADDITIONFACTOR = 1.0;
        final double METERSADDITIONFACTOR = 5.0;
        ConvertFromMetersToFeetAndFeetToMeters conversion = new ConvertFromMetersToFeetAndFeetToMeters();
        
        // print out header of table
        System.out.println("Feet      Meters     |       Meters     Feet ");
        System.out.println("------------------------------------------------");
        
        // print out body of table using a for loop
        for (int i = 0; i < 10; i++) {
            // calculate conversion of feet to meters and meters to feet
            double feetToMeters = conversion.footToMeter(feet);
            double metersToFeet = conversion.meterToFoot(meters);
            
            // print out body of table while formatting the input feet and meters 
            // to one decimal place and the output meters and feet to three decimal places
            System.out.printf("%5.1f", feet);
            System.out.print("     ");
            System.out.printf("%5.3f", feetToMeters);
            System.out.print("     ");
            System.out.print("  | ");
            System.out.print("     ");
            System.out.printf("%5.1f", meters);
            System.out.print("     ");
            System.out.printf("%5.3f", metersToFeet);
            System.out.print('\n');

            // add FEETADDITIONFACTOR to feet and METERSADDITIONFACTOR to meters
            feet = feet + FEETADDITIONFACTOR;
            meters = meters + METERSADDITIONFACTOR;
        }
         
    }
}

            