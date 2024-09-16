## Author of assignment code
The author of assignment code is Kyle Ingersoll.

## What class was it for 
The class it was for was Software Development Using Java, SDEV200 by Ivy Tech Community College.

## Where assignment was from
The assignment was from Java Programming and Data Structures Comprehensive Version Twelfth Edition by Y. Daniel Liang covering Chapter 20: Programming Exercise 20.11.

## Purpose of the program
The purpose of the program is to check the grouping symbols in a Java source code file so that they are paired and don't overlap and then display the results to the user. 

## Notes
You will need at least three grouping symbols in the Java source code file you are testing for the program to work, thus the user cannot just put a file solely containing an empty Java class, since that would only contain two grouping symbols. App.java is the program that checks the Java source code file, while TestFalse.java and TestTrue.java are example Java source code files to be processed by App.java. TestFalse.java and TestTrue.java are not intended to be runnable programs, just test data for App.java. Also, the program only works if you put one and exactly one Java source code file name in as args[0]. That Java source code file has to be within /src/ for it to work. Furthermore, if you want to change the arguments inputted in VSCode, you have to go to launch.json in /.vscode/ and change the file name in "args". The program is designed to only work with Java source code files, so a .txt file won't work.