
/**
 * CS312 Assignment 6.
 *
 * On my honor, Luis Zamorano , this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Hangman.
 *
 *  email address:cyclazluis@gmail.com
 *  UTEID:lz238
 *  Grader name: Walid Owais
 *  Number of slip days used on this assignment:0
 */

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		intro();
		PhraseBank phrases = buildPhraseBank(args);
		Scanner keyboard = new Scanner(System.in);
		playGame(phrases, keyboard);

		keyboard.close();
	}

	// The main method that takes the phrase bank and loops as long as you want
	// to play
	public static void playGame(PhraseBank phrases, Scanner keyboard) {
		String rePlay = "Y";
		while (rePlay.equals("Y")) {
			int wrongChoice = 0;
			String abcBank = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
			String phrase = currentPhrase(phrases);
			String asteriskPhrase = changeStars(phrase, abcBank);
			System.out.println("\nI am thinking of a " + phrases.getTopic() + " ...\n");
			while (wrongChoice != 5 && !asteriskPhrase.equals(phrase)) {
				System.out.println("The current phrase is " + asteriskPhrase);
				System.out.println("\nThe letters you have not guessed yet are: ");
				System.out.println(abcBank + "\n");
				String userInput = validInput(keyboard, abcBank);
				wrongChoice = userResult(phrase, wrongChoice, userInput);
				abcBank = abcChange(abcBank, userInput);
				asteriskPhrase = revealPhrase(asteriskPhrase, userInput, phrase);
				endgame(wrongChoice, asteriskPhrase, phrase);

			}
			rePlay = newRound(keyboard);
		}
	}

	// displays the current phrase of the game
	public static String currentPhrase(PhraseBank phrases) {
		String movieName = phrases.getNextPhrase();
		return movieName;
	}

	// method that converts the movie name into a asterisks and dashes
	public static String changeStars(String movieName, String abcBank) {
		String convertStar = "";
		while (movieName.length() != convertStar.length()) {
			for (int movieLen = 0; movieLen < movieName.length(); movieLen++) {
				if (abcBank.contains("" + movieName.charAt(movieLen))) {
					convertStar += "*";
				} else {
					convertStar += '_';
				}

			}
			return convertStar;
		}
		return convertStar;
	}

	// stores user input
	public static String userGuess(Scanner keyboard) {
		System.out.print("Enter your next guess: ");
		String userLetter = keyboard.next();
		userLetter = userLetter.toUpperCase();
		return userLetter;
	}

	// Boolean method that checks for the validity of the user input and returns
	public static String validInput(Scanner keyboard, String abcBank) {
		String rightOrwrongChoice = userGuess(keyboard);
		if (abcBank.contains(rightOrwrongChoice)) {
			return rightOrwrongChoice;
		} else {
			while (!abcBank.contains(rightOrwrongChoice)) {
				System.out.println("\n" + rightOrwrongChoice
						+ " is not a valid guess.\nThe letters you have not guessed yet are: ");
				System.out.println(abcBank);
				rightOrwrongChoice = userGuess(keyboard);

			}

			return rightOrwrongChoice;
		}
	}

	// a string method that converts the stars into characters if the user
	// guessed the phrase correctly
	public static String revealPhrase(String asteriskPhrase, String userInput, String phrase) {
		String deStar = "";
		for (int letter = 0; letter < phrase.length(); letter++) {
			if (phrase.substring(letter, letter + 1).equals(userInput)) {
				deStar += userInput;
			} else {
				deStar += asteriskPhrase.substring(letter, letter + 1);
			}
		}
		asteriskPhrase = deStar;
		return asteriskPhrase;

	}

	// updates the abcBank
	public static String abcChange(String abcBank, String userInput) {
		String abcOriginal = abcBank;
		boolean abcInGuess = abcBank.contains(userInput);
		if (abcInGuess == true) {
			String abcNew = abcBank.replace(userInput + " ", "");
			return abcNew;
		} else {
			return abcOriginal;
		}

	}

	// a method for when the user picks a correct guess
	public static void correctPick(int wrongChoice) {
		System.out.println("\nThat is present in the secret phrase.\n\nNumber of wrong guesses so far: " + wrongChoice);

	}

	// a method for what actions to perform when the user picks a wrong letter
	public static int incorrectPick(int wrongChoice) {
		System.out.println("\nThat is not present in the secret phrase.\n");
		System.out.println("Number of wrong guesses so far: " + wrongChoice);
		return wrongChoice;
	}

	// it returns the user's result
	public static int userResult(String phrase, int wrongChoice, String validInput) {
		System.out.println("\nYou guessed " + validInput + ".");
		if (phrase.contains(validInput)) {
			correctPick(wrongChoice);
			return wrongChoice;
		} else {
			wrongChoice++;
			incorrectPick(wrongChoice);
			return wrongChoice;

		}
	}

	// ends the game and tells you if you lost or won
	public static void endgame(int wrongChoice, String asteriskPhrase, String phrase) {
		if (wrongChoice == 5) {
			System.out.println("You lose. The secret phrase was " + phrase);
		} else if (asteriskPhrase.equals(phrase)) {
			System.out.println("The phrase is " + phrase + ".\nYou win!!");

		}
	}

	// it prompts the user if they would like to do another round
	public static String newRound(Scanner keyboard) {
		System.out.println("Do you want to play again?");
		System.out.print("Enter 'Y' or 'y' to play again: ");
		String playMaybe = keyboard.next();
		playMaybe = playMaybe.toUpperCase();
		return playMaybe;

	}

	// Build the PhraseBank.
	// If args is empty or null, build the default phrase bank.
	// If args is not null and has a length greater than 0
	// then the first elements is assumed to be the name of the
	// file to build the PhraseBank from.
	public static PhraseBank buildPhraseBank(String[] args) {
		PhraseBank result;
		if (args == null || args.length == 0 || args[0] == null || args[0].length() == 0)
			result = new PhraseBank();
		else
			result = new PhraseBank(args[0]);
		return result;
	}

	// show the intro to the program
	public static void intro() {
		System.out.println("This program plays the game of hangman.\n\nThe computer will pick a random phrase.");
		System.out.println("Enter letters for your guess.\nAfter 5 wrong guesses you lose.");
	}
}