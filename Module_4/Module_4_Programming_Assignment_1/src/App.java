/* Program name: App.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/15/2024
 * Purpose: To check to see if a Java source code file has correct
 * pairs of grouping symbols.
 */
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class App {
    public static void main(String[] args) throws Exception {
        // initalize variables
        String javaSourceCodeFileName = args[0];
        java.util.Deque<Character> pairsOfGroupingSymbols = new LinkedList<>();
        java.io.File javaSourceCodeFile = new java.io.File(".\\src\\" + javaSourceCodeFileName);
        boolean fileHasCorrectPairsOfGroupingSymbols;

        // check to see if the java source code file name was passed as an argument
        // the regex means if there isn't a java file name, then dot, then java file extension, then return true
        if (args[0].equals("") || args[0].matches("\\^\\(\\.\\+\\(\\(\\\\\\.\\)java\\$\\)\\)") || args.length > 1 ) {
            System.out.println("The name of the Java source code file must be the only command line argument made to the program.");
            System.exit(1);
        }

        // check to see if file can be read
        if (javaSourceCodeFile.canRead() == false) {
            System.out.println("File cannot be read.");
            System.exit(2);
        }

        // create try with resources block to check if the file exists
        try (InputStream in = new FileInputStream(javaSourceCodeFile);
        Reader fileInput = new InputStreamReader(in, Charset.defaultCharset());) {
            
            int r;
            // while loop to add grouping symbols to the deque
            while ((r = fileInput.read()) != -1) {
                if (r == '(' || r == ')' || r == '{' || r == '}' || r == '[' || r == ']') {
                    pairsOfGroupingSymbols.addLast((char)r);
                }
            }   
        }

        // create try block to handle method exception
        try {
            // get whether the file has correct pairs of grouping symbols or not from the method
            fileHasCorrectPairsOfGroupingSymbols = checkPairsOfGroupingSymbolsForCorrectness(pairsOfGroupingSymbols);

            if (fileHasCorrectPairsOfGroupingSymbols == true) {
                System.out.println(javaSourceCodeFileName + " grouping symbols are all correct.");
            }
            else {
                System.out.println(javaSourceCodeFileName + " grouping symbols are incorrect.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.exit(3);
        }
        catch (NoSuchElementException e) {
            System.out.println("The file does not contain at least three grouping symbols.");
            System.exit(4);
        }
        

    }

    /* Method to check if the pairs of grouping symbols are correct */
    public static boolean checkPairsOfGroupingSymbolsForCorrectness(Deque<Character> pairsOfGroupingSymbols) throws NoSuchElementException, IllegalArgumentException {
        // if the number of grouping symbols is zero or odd (odd means that not all grouping symbols are a pair), then it is automatically incorrect
        if (pairsOfGroupingSymbols.isEmpty() || pairsOfGroupingSymbols.size() % 2 != 0) {
            return false;
        }

        // initialize variables
        Character leftGroupingSymbol = pairsOfGroupingSymbols.remove();
        Character middleGroupingSymbol = pairsOfGroupingSymbols.remove();
        Character rightGroupingSymbol = pairsOfGroupingSymbols.remove();
        Character temp;
        
        // program must begin with braces 
        if (!(leftGroupingSymbol.equals('{'))) {
            throw new IllegalArgumentException("The first grouping symbol in a Java program must begin with a {");
        }

        // while loop to loop across the Deque and figure out if there are any overlapping grouping symbols
        // if there are overlapping grouping symbols, return false, else move on
        while (!(pairsOfGroupingSymbols.isEmpty())) {
            // basically if the right grouping symbol pairs with the left grouping symbol and there is a
            // different grouping symbol in the middle, we return false
            if ((leftGroupingSymbol.equals('(') == true) && (middleGroupingSymbol.equals('{') == true || 
            middleGroupingSymbol.equals('[') == true) && (rightGroupingSymbol.equals(')') == true)) {
                return false;
            }
            else if ((leftGroupingSymbol.equals('{') == true) && (middleGroupingSymbol.equals('(') == true || 
            middleGroupingSymbol.equals('[') == true) && (rightGroupingSymbol.equals('}') == true)) {
                return false;
            }
            else if ((leftGroupingSymbol.equals('[') == true) && (middleGroupingSymbol.equals('(') == true || 
            middleGroupingSymbol.equals('{') == true) && (rightGroupingSymbol.equals(']') == true)) {
                return false;
            }
            else if ((leftGroupingSymbol.equals('(') == true) && (middleGroupingSymbol.equals(']') == true || 
            middleGroupingSymbol.equals('}') == true) && (rightGroupingSymbol.equals(')') == true)) {
                return false;
            }
            else if ((leftGroupingSymbol.equals('{') == true) && (middleGroupingSymbol.equals(']') == true || 
            middleGroupingSymbol.equals(')') == true) && (rightGroupingSymbol.equals('}') == true)) {
                return false;
            }
            else if ((leftGroupingSymbol.equals('[') == true) && (middleGroupingSymbol.equals(')') == true || 
            middleGroupingSymbol.equals('}') == true) && (rightGroupingSymbol.equals(']') == true)) {
                return false;
            }

            // we then shift the symbols 1 step rightward
            temp = pairsOfGroupingSymbols.remove();
            leftGroupingSymbol = middleGroupingSymbol;
            middleGroupingSymbol = rightGroupingSymbol;
            rightGroupingSymbol = temp;
        }

        // no overlapping symbols, so return true
        return true;
    }
}
