import java.util.Scanner;

/**
 * CS312 Assignment 10.
 *
 * On my honor, Luis Zamorano, this programming assignment is my own work and I
 * have not shared my solution with any other student in the class.
 *
 * email address:cyclazluis@gmail.com 
 * Number of slip days used on this assignment:2
 *
 * Program that allows two people to play Connect Four.
 */

public class ConnectFour {

// I didn't know how to solve my exceptions for validity I think I created the method that checks for validity wrong since I couldn't
// splash is properly in other methods 

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		playGame(key);
		// complete this method
		// Recall make and use one Scanner coonected to System.in
	}

	// this method plays the whole game of connect four
	public static void playGame(Scanner key) {

		intro();

		int checkInt = 0;
		int checkColumn = 0;
		int numTurns = 0;
		boolean win = false;
		boolean fullBoard = false;

		// player 1 choice
		char ch1 = 'r';

		// player 2 choice
		char ch2 = 'b';

		System.out.print("Player 1 enter your name: ");
		String playerOne = key.next();
		System.out.print("\nPlayer 2 enter your name: ");
		String playerTwo = key.next();

		char[][] boardIn = board();

		// prints the initial board
		boardPrint(boardIn, win, fullBoard);
		String prompt = playerOne + ", enter the column to drop your checker: ";
		String prompt2 = playerTwo + ", enter the column to drop your checker: ";

		// while loop for the execution of the game
		while (!win && !fullBoard) {
			System.out.println(playerOne + " it is your turn.\nYour pieces are the " + ch1 + "'s.");
			System.out.print(prompt);
			checkInt = getInt(key, prompt);
			checkColumn = getColumn(key, prompt, checkInt);
			char[][] pChoice = playerChoice(boardIn, checkColumn, ch1);
			numTurns++;
			win = whoWon(boardIn, ch1, win);

			// prints the p1 winner
			if (win == true) {
				System.out.println("\n" + playerOne + " wins!!");
			}

			// prints the current board
			boardPrint(pChoice, win, fullBoard);

			if (!win) {
				System.out.println(playerTwo + " it is your turn.");
				System.out.println("Your pieces are the " + ch2 + "'s.");
				System.out.print(prompt2);
				checkInt = getInt(key, prompt2);
				checkColumn = getColumn(key, prompt2, checkInt);
				char[][] pChoice2 = playerChoice(boardIn, checkColumn, ch2);

				numTurns++;
				win = whoWon(boardIn, ch2, win);

				// prints the p2 winner
				if (win == true) {

					System.out.println("\n" + playerTwo + " wins!!");
				}

				// prints if the board is full
				fullBoard = boardFilled(numTurns, fullBoard);
				if (fullBoard) {
					System.out.println("\nThe game is a draw.");

				}
				// prints the current board
				boardPrint(pChoice2, win, fullBoard);

			}

		}

	}

	// creates the board of connect four
	public static char[][] board() {
		char[][] board = new char[6][7];
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				board[row][column] = '.';
			}
		}
		return board;
	}

	// creates where to drop the array column and places it on top if a char is
	// already present
	public static char[][] playerChoice(char[][] boardIn, int checkColumn, char ch) {
		int maxRow = 5;
		boolean result = false;

		while (!result) {
			if (boardIn[maxRow][checkColumn - 1] == '.') {
				boardIn[maxRow][checkColumn - 1] = ch;
				result = true;
			} else if (maxRow > 0) {
				maxRow--;

			}
		}
		return boardIn;

	}

	// prints the current board for connect four
	public static void boardPrint(char[][] boardIntro, boolean win, boolean fullBoard) {
		System.out.println();
		if (win || fullBoard) {
			System.out.println("Final Board");
		} else {
			System.out.println("Current Board");
		}
		System.out.println("1 2 3 4 5 6 7  column numbers");
		for (int row = 0; row < boardIntro.length; row++) {
			for (int column = 0; column < boardIntro[0].length; column++) {
				System.out.print(boardIntro[row][column] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	// checks to make sure the column is a valid integer
	public static int getColumn(Scanner key, String prompt, int checkInt) {

		while ((checkInt <= 0 || checkInt >= 8)) {
			System.out.println(checkInt + " is not a valid column.");
			System.out.print(prompt);
			checkInt = key.nextInt();

		}

		int result = checkInt;
		return result;
	}

	// checks if the board is full
	public static boolean boardFilled(int numTurns, boolean fullBoard) {
		if (numTurns == 42) {
			fullBoard = true;
		}
		return fullBoard;
	}

	// Method checks if a player wins
	public static boolean whoWon(char[][] board, char ch, boolean win) {
		win = verticalCheck(board, ch, win);
		win = horizonCheck(board, ch, win);
		win = diagUp(board, ch, win);
		win = diagDown(board, ch, win);

		return win;
	}

	// Checks for winning in a vertical manner
	public static boolean verticalCheck(char[][] board, char ch, boolean win) {
		for (int column = 0; column < 7; column++) {
			for (int row = 0; row <= 2; row++) {
				if (board[row][column] == ch && board[row + 1][column] == ch && board[row + 2][column] == ch
						&& board[row + 3][column] == ch) {
					win = true;
				}
			}
		}
		return win;
	}

	// Checks for winning in a horizontal way
	public static boolean horizonCheck(char[][] board, char ch, boolean win) {
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column <= 3; column++) {
				if (board[row][column] == ch && board[row][column + 1] == ch && board[row][column + 2] == ch
						&& board[row][column + 3] == ch) {
					win = true;
				}
			}
		}
		return win;
	}

	// Checks for a diagonal win
	public static boolean diagUp(char[][] board, char ch, boolean win) {
		for (int row = 0; row <= 2; row++) {
			for (int column = 3; column <= 6; column++) {
				if (board[row][column] == ch && board[row + 1][column - 1] == ch && board[row + 2][column - 2] == ch
						&& board[row + 3][column - 3] == ch) {
					win = true;
				}
			}
		}
		return win;
	}

	// checks for winning diagonally down
	public static boolean diagDown(char[][] board, char ch, boolean win) {
		for (int row = 0; row <= 2; row++) {
			for (int column = 0; column <= 3; column++) {
				if (board[row][column] == ch && board[row + 1][column + 1] == ch && board[row + 2][column + 2] == ch
						&& board[row + 3][column + 3] == ch) {
					win = true;
				}
			}
		}
		return win;
	}

	// prompt the user for an int and make sure it's correct
	public static int getInt(Scanner key, String prompt) {
		while (!key.hasNextInt()) {
			String notAnInt = key.next();
			System.out.println(notAnInt + " is not an integer.");
			System.out.print(prompt);
		}
		int result = key.nextInt();
		key.nextLine();
		return result;
	}

	// intro
	public static void intro() {
		System.out.println("This program allows two people to play the\ngame of Connect four. Each player takes turns");
		System.out.println("dropping a checker in one of the open columns\non the board. The columns are numbered 1 to 7.");
		System.out.println("The first player to get four checkers in a row\nhorizontally, vertically, or diagonally wins");
		System.out.println("the game. If no player gets fours in a row and\nand all spots are taken the game is a draw.");
		System.out.println("Player one's checkers will appear as r's and\nplayer two's checkers will appear as b's.");
		System.out.println("Open spaces on the board will appear as .'s.\n");

	}

}