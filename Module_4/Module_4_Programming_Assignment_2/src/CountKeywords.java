/* Program name: CountKeywords.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/21/2024
 * Purpose: To check a Java source code file for keywords, ignoring the ones in comments or strings.
 */
import java.io.*;
import java.util.*;
public class CountKeywords {
    public static void main(String[] args) throws Exception {  
        // check to see if number of arguments is greater than 1, if so, print a error message to the user and exit out
        if (args.length != 1) {
            System.out.println("You can only put 1 argument, which is the Java source file you want to use, into the program.");
            System.exit(1);
        }

        // input new file in Module_4_Programming_Assignment_2 folder
        File file = new File(args[0]);
        
        // if the file exists, print number of keywords, else print file does not exist
        if (file.exists()) {
        System.out.println("The number of keywords in " + args[0]
            + " is " + countKeywords(file));
        }
        else {
        System.out.println("File " + args[0] + " does not exist");
        }    
    }

/* Checks file for Java keywords, not counting the ones in comments or strings */
    public static int countKeywords(File file) throws Exception {  
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean", 
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int", 
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", 
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

        Set<String> keywordSet = 
        new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                // we read the file word by word  
                String word = input.next();

                // if word is a line or paragraph comment or string read word until done, then return to testing for keywords
                if (word.contains("/*")) {
                    do { 
                        word = input.next();
                    } while (!(word.contains("*/")));
                }
                else if (word.contains("//")) {
                    input.nextLine();
                }
                else if (word.contains("\"")) {
                    do { 
                        word = input.next();
                    } while (!(word.contains("\"")));
                }
                else {
                    // test if word is a keyword
                    if (keywordSet.contains(word)) {
                        count++;
                    }
                }
            }
        
            
        }

    // finally we return the count of keywords
    return count;
    }
}