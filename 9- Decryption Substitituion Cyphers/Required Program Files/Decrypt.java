import java.util.Scanner;

/**
 * CS312 Assignment 9.
 *
 * On my honor, <NAME>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address:
 *  UTEID:
 *  Number of slip days used on this assignment:
 *  
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only characters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 */

public class Decrypt {

    // CS312 students, add your constants here



    public static void main(String[] arg) {
        // CS312 Students, do not create any other Scanners connected to System.in
        Scanner keyboard = new Scanner(System.in); 
        String fileName = getFileName(keyboard);
        String encryptedText = DecryptUtilities.convertFileToString(fileName);

        // The other method from DecryptUtilities you will have to use is
        // DecryptUtilities.getDecryptionKey(int[]), but first you need to
        // create an array with the frequency of all the ASCII characters in the 
        // encrypted text. Count ALL characters from ASCII code 0 to ASCII code 127

        // CS312 students, add you code here.

        keyboard.close();
    }

    // CS312 students, add your methods here



    // get the name of file to use
    public static String getFileName(Scanner kbScanner) {
        System.out.print("Enter the name of the encrypted file: ");
        String fileName = kbScanner.nextLine().trim();
        System.out.println();
        return fileName;
    }
}
