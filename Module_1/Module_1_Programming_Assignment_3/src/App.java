/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 8/24/2024 
 * Purpose: The program will prompt the user to enter two arrays of 3 X 3 integers and display whether the two arrays are identical.
 */

import java.util.Scanner; // the scanner is used for user input

public class App {
    /* This class contains the main method and the equals method. The main method prompts the user to enter in two two-dimensional arrays
     * of size 3 x 3 and then checks to see if their contents are identical. Afterwards, it displays the results to the user.
     * 
     */
    public static void main(String[] args) throws Exception {
        // initialize variables
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        Scanner input = new Scanner(System.in); 

        // prompt user to enter in the first two-dimensional array
        System.out.print("Enter list1: ");

        // have user populate the first two-dimensional array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = input.nextInt();
            }
        }

        // end the input line
        System.out.print("\n");

        // prompt user to enter in the second two-dimensional array
        System.out.print("Enter list2: ");

        // have user populate the second two-dimensional array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = input.nextInt();
            }
        }

        // end the input line
        System.out.print("\n");

        // close the input scanner since we no longer need it
        input.close();

        // use selection statement and equals() method to determine if the two arrays are identical and display the results to the user
        if (equals(m1, m2) == true) {
            System.out.print("The two arrays are identical");
        }
        else {
            System.out.print("The two arrays are not identical");
        }

    }
    /* This method checks whether one two dimensional array is identical to another two dimensional array. */
    public static boolean equals(int[][] m1, int[][] m2) {
        // initialize variable to true so that the assertion can be disproven
        boolean arraysAreIdentical = true;
        int tempM1 = 0;
        int tempM2 = 0;

        // first we need to sort both m1 and m2 in ascending order so that we can compare the contents element by element
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 3; k++) {
                    // sort m1 in ascending order
                    if (m1[i][j] > m1[i][k]) {
                        tempM1 = m1[i][j];
                        m1[i][j] = m1[i][k];
                        m1[i][k] = tempM1; 
                    }

                    // sort m2 in ascending order
                    if (m2[i][j] > m2[i][k]) {
                        tempM2 = m2[i][j];
                        m2[i][j] = m2[i][k];
                        m2[i][k] = tempM2; 
                    } 
                }
            }
        } 

        // create a nested loop to iterate across both two dimensional arrays at once
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // if one of the values at each spot in the arrays don't match, then the arrays are not identical
                if (m1[i][j] != m2[i][j])
                {
                    arraysAreIdentical = false;
                }
            }
        }

        // return the result
        return arraysAreIdentical;
    }
}
