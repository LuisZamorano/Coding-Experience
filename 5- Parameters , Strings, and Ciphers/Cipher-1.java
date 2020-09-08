import java.util.Scanner;

/**
 * CS312 Assignment 5.
 *
 * On my honor, Luis Zamorano, this programming assignment is my own work and I
 * have not shared my solution with any other student in the class.
 *
 * A program to encrypt and decrypt messages using a columnar transposition
 * cipher.
 *
 * email address:cyclazluis@gmail.com 
 * UTEID:ljz238 
 * Grader name:Walid Owais
 * Number of slip days used on this assignment:0
 */

public class Cipher {

	// CS312 Students: This constant must be set to 10 in the
	// final version of your program that you turn in.
	public static final int MAX_ROWS = 10;

	// main method to demonstrate various encryptions and
	// decryptions using a columnar transposition cipher
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		intro();

		demoPrint();

		String userMessage = keyboard.nextLine();

		cipherNoPad(keyboard, userMessage);

		cipherWPad(userMessage);

		decodeDemo();

		String decodeMessage = keyboard.nextLine();

		cipherDecode(decodeMessage);

		keyboard.close();
	}

	// shows the introduction
	public static void intro() {
		System.out.println(
				"This program demonstrates a transposition cipher.\nA cipher is an algorithm to encrypt or decrypt a message.\n");
		System.out.println(
				"This program will demonstrate encrypting a message with\na columnar transposition cipher both with and without");
		System.out.println(
				"padding characters. The program will then decrypt a message\nassuming it was encrypted with a columnar transposition cipher");
		System.out.println("with padding.\nAfter accepting user input, the program displays some tests.\n\n");
	}

	// Creates the initial statement for the print
	public static void demoPrint() {
		System.out.println("A demonstration of encrypting with a columnar transposition cipher:\n");
		System.out.print("Enter the message to encrypt: ");
	}

	// encrypts the message of the user inputs without padding
	public static void cipherNoPad(Scanner keyboard, String userMessage) {
		System.out.println("\nMessage encrypted with columnar transposition cipher and no padding.");
		for (int row = 2; row <= MAX_ROWS; row++) {
			String cipherMessage = "";
			for (int i = 0; i < row; i++) {
				for (int j = i; j < userMessage.length(); j += row) {
					cipherMessage += userMessage.charAt(j);
				}
			}
			System.out.println("Encrypted with " + row + " rows: " + cipherMessage);
		}
	}

	// encrypts the message of the user inputs with padding
	public static void cipherWPad(String userMessage) {
		System.out.println("\nMessage encrypted with columnar transposition cipher and padding.\n");
		for (int row = 2; row <= MAX_ROWS; row++) {
			String ciphMessage = "";
			String padMessage = userMessage;

			// loop that adds the "X" encryption if the remainder of the length is 0
		

			while (padMessage.length() % row != 0) {
				padMessage += "X";
			}
			System.out.println("Clear text padded for " + row + " rows: " + padMessage);
			for (int z = 0; z < row; z++) {
				for (int i = z; i < padMessage.length(); i += row) {
					ciphMessage += padMessage.charAt(i);
				}
			}
			System.out.println("Encrypted with " + row + " rows: " + ciphMessage + "\n");
		}
	}

	// the initial message for the decode section
	public static void decodeDemo() {
		System.out.println("\nA demonstration of decrypting with a columnar transposition cipher:");
		System.out.println("If the length of the message is not a multiple of the number of rows");
		System.out.println("it will be padded which may throw off the decryption.");
		System.out.print("\nEnter the message to decrypt: ");
	}

	// deciphers the message
	public static void cipherDecode(String decodeMessage) {
		System.out.println("\nMessages Decrypted with a Columnar Transposition Cipher");
		for (int row = 2; row <= MAX_ROWS; row++) {
			System.out.println();
			String ciphMessage = "";
			String padMessage = decodeMessage;
			while (padMessage.length() % row != 0) {
				padMessage += "X";
			}
			int col = padMessage.length() / row;
			System.out.println("Decrypted text padded for " + row + " rows: " + padMessage);

			for (int i = 0; i < col; i++) {
				for (int j = i; j < padMessage.length(); j += col) {
					ciphMessage += padMessage.charAt(j);

				}
			}

			System.out.println("Decrypted with " + row + " rows: " + ciphMessage);
		}
	}
}