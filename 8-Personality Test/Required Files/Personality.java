/**
 * CS312 Assignment 8.
 * 
 * On my honor, <NAME>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to read a file with raw data from a Keirsey personality test
 * and print out the results.
 *
 *  email address:
 *  UTEID:
 *  Number of slip days used on this assignment:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Personality {
    
    // CS312 Student- Add your constants here.

    // The main method to process the data from the personality tests
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // do not make any other Scanners connected to System.in
        Scanner fileScanner = getFileScanner(keyboard);

        // CS312 students - your code and methods calls go here

        fileScanner.close();
        keyboard.close();
    }

    
    // CS312 Students add you methods here
    
    // Method to choose a file.
    // Asks user for name of file. 
    // If file not found create a Scanner hooked up to a dummy set of data
    // Example use: 
    public static Scanner getFileScanner(Scanner keyboard){
        Scanner result = null;
        try {
            System.out.print("Enter the name of the file with the personality data: ");
            String fileName = keyboard.nextLine().trim();
            System.out.println();
            result = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) {
            System.out.println("Problem creating Scanner: " + e);
            System.out.println("Creating Scanner hooked up to default data " + e);
            String defaultData = "1\nDEFAULT DATA\n"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
            result = new Scanner(defaultData);
        }
        return result;
    }
}
