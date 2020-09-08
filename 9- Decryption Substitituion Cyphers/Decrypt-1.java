import java.util.Scanner;

/**
 * CS312 Assignment 9.
 *
 * On my honor, Luis Zamorano, this programming assignment is my own work and I
 * have not shared my solution with any other student in the class.
 *
 * email address:cyclazluis@gmail.com Number of slip days used on this
 * assignment:0
 * 
 * Program to decrypt a message that has been encrypted with a substitution
 * cipher. We assume only characters with ASCII codes from 32 to 126 inclusive
 * have been encrypted.
 */

public class Decrypt {

	final int[] ASCII = new int[128];
	public static char[] ASCIICHAR = new char[128];

	public static void main(String[] arg) {

		Scanner keyboard = new Scanner(System.in);
		String fileName = getFileName(keyboard);
		String encryptedText = DecryptUtilities.convertFileToString(fileName);

		runDecrypt(encryptedText, keyboard);

		keyboard.close();
	}

	// the main method of where all the processing occurs
	public static void runDecrypt(String encryptedText, Scanner keyboard) {
		String redo = "Y";
		System.out.println("The encrypted text is:");
		System.out.print(encryptedText);
		System.out.println("\nFrequencies of characters.\nCharacter - Frequency");
		int[] freq = frequency(encryptedText);
		char[] genKey = generateKey(freq, ASCIICHAR);

		// prints the frequency
		for (int chara = 32; chara < 127; chara++) {
			ASCIICHAR[chara] = (char) chara;
			System.out.println(ASCIICHAR[chara] + " - " + freq[chara]);

		}
		System.out.println("\nThe current version of the key for ASCII characters 32 to 126 is: ");

		// prints the new key of the encryption
		for (int i = 32; i < 127; i++) {
			System.out.println("Encrypt character: " + ASCIICHAR[i] + ", " + "decrypt character: " + genKey[i]);
		}

		System.out.println("\nThe current version of the decrypted text is: \n");
		decryptedText(genKey, encryptedText);
		System.out.println();

		// while the user keeps prompting to change a character
		while (redo.equals("Y")) {
			redo = reDo(keyboard);

			// the code will only execute if the string is "Y"
			if (redo.equals("Y")) {
				char[] decryptChar = decryptChoice(keyboard, genKey, redo);
				System.out.println("The current version of the decrypted text is: \n");
				decryptedText(decryptChar, encryptedText);
				System.out.println();
			}
		}

	}

	// it prompts the user if they want to make changes to the key
	public static String reDo(Scanner keyboard) {
		System.out.println("\nDo you want to make a change to the key?");
		System.out.print("Enter 'Y' or 'y' to make change: ");
		String reStart = keyboard.next().toUpperCase();
		return reStart;
	}

	// changes the key based on the chosen characters
	public static char[] decryptChoice(Scanner keyboard, char[] genKey, String restart) {
		if (restart.equals("Y")) {
			System.out.print("Enter the decrypt character you want to change: ");
			String letChange = keyboard.next();
			System.out.print("Enter what the character " + letChange + " should decrypt to instead: ");
			String toChange = keyboard.next();
			System.out.println(letChange + "'s will now decrypt to " + toChange + "'s and vice versa.\n");
			char old = letChange.charAt(0);
			char toChar = toChange.charAt(0);
			int change = 0;
			int previous = 0;
			for (int i = 0; i < genKey.length; i++) {
				if (genKey[i] == toChar) {
					change = i;

				} else if (genKey[i] == old) {
					previous = i;
				}

			}
			char update = genKey[previous];
			genKey[previous] = genKey[change];
			genKey[change] = update;

		}

		return genKey;
	}

	// frequency of the text
	public static int[] frequency(String encryptedText) {
		int[] fileEncrypt = new int[128];
		for (int encode = 0; encode < encryptedText.length() - 1; encode++) {
			int encodeCount = (int) encryptedText.charAt(encode);
			fileEncrypt[encodeCount]++;
		}
		return fileEncrypt;
	}

	// creates a char array based on the frequency
	public static char[] generateKey(int[] freq, char[] ASCIICHAR) {
		char[] key = DecryptUtilities.getDecryptionKey(freq);
		return key;

	}

	// it generates the decripted text key output
	public static void decryptedText(char[] genKey, String encryptedText) {
		char[] decText = new char[encryptedText.length()];
		int encrypted = 0;
		for (int i = 0; i < encryptedText.length() - 1; i++) {
			encrypted = encryptedText.charAt(i);
			decText[i] = genKey[encrypted];
			if (i == encryptedText.length() - 2) {
				for (int position = 0; position < decText.length; position++) {
					System.out.print(decText[position]);
				}
			}
		}
	}

	// get the name of file to use
	public static String getFileName(Scanner kbScanner) {
		System.out.print("Enter the name of the encrypted file: ");
		String fileName = kbScanner.nextLine().trim();
		System.out.println();
		return fileName;
	}
}