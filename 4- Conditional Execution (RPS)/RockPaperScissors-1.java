import java.util.Scanner;

/**
 * * CS312 Assignment 4. * * On my honor, Luis Zamorano, this programming
 * assignment is my own work and I have * not shared my solution with any other
 * student in the class. * * A program to play Rock Paper Scissors * *
 *  email address: cyclazluis@gmail.com 
 *  UTEID:ljz238 
 *  Number of slip days used on this assignment:0 
 */
public class RockPaperScissors {
	/*
	 * A program to allow a human player to play rock - paper - scissors *
	 * against the computer. If args.length != 0 then we assume * the first
	 * element of args can be converted to an int
	 */ public static void main(String[] args) {

		// CS312 Students. Do not change the following line.
		RandomPlayer computerPlayer = buildRandomPlayer(args);

		// CS312 students do no change the following line. Do not create any
		// other Scanners.
		final int ROCK = 1;
		final int PAPER = 2;
		final int SCISSORS = 3;

		Scanner keyboard = new Scanner(System.in);
		gameIntro(keyboard);
		String player = keyboard.next();
		introEnd(player);
		int numR = rounds(keyboard);
		playGame(player, numR, keyboard, computerPlayer);
		keyboard.close();
	}

	// intro
	public static void gameIntro(Scanner keyboard) {
		System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.");
		System.out.print("Please type in your name and press return: ");
	}

	// the intro continued
	public static void introEnd(String player) {
		System.out.println();
		System.out.println("Welcome " + player + ".");
		System.out.println();
		System.out.println("All right " + player + ". How many rounds would you like to play?");
		System.out.print("Enter the number of rounds you want to play and press return: ");

	}

	// makes and int for the number of rounds
	public static int rounds(Scanner keyboard) {

		int rounds = keyboard.nextInt();
		return rounds;
	}

	// the main program that runs the game
	public static void playGame(String player, int numR, Scanner keyboard, RandomPlayer computerPlayer) {
		int plWin = 0;
		int pcWin = 0;
		int draw = 0;
		for (int i = 1; i <= numR; i++) {
			System.out.println();
			System.out.println("Round " + i + ".");
			System.out.println(player + ", please enter your choice for this round.");
			System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
			int pPick = keyboard.nextInt();
			String playerChoice = printType(pPick);
			int compPick = computerPlayer.getComputerChoice();
			String compChoice = printType(compPick);
			System.out.println("Computer picked " + compChoice + ", " + player + " picked " + playerChoice + ".");
			System.out.println();
			String choice = "";

			if (pPick == compPick) {
				choice += "We picked the same thing! This round is a draw.";
				draw++;
			} else if (pPick == 1 && compPick == 2) {
				choice += "PAPER covers ROCK. I win.";
				pcWin++;
			} else if (pPick == 1 && compPick == 3) {
				choice += "ROCK breaks SCISSORS. You win.";
				plWin++;
			} else if (pPick == 2 && compPick == 1) {
				choice += "PAPER covers ROCK. You win.";
				plWin++;
			} else if (pPick == 2 && compPick == 3) {
				choice += "SCISSORS cut PAPER. I win.";
				pcWin++;
			} else if (pPick == 3 && compPick == 1) {
				choice += "ROCK breaks SCISSORS. I win.";
				pcWin++;
			} else {
				choice += "SCISSORS cut PAPER. You win.";
				plWin++;
			}
			System.out.print(choice);
			System.out.println();
		}
		System.out.println("");
		endGame(numR, player, plWin, pcWin, draw);
		winner(player, plWin, pcWin, draw);
	}

	// it prints the actual word for the choice of the player instead of the int
	// like ROCK instead of 1
	public static String printType(int Choice) {
		String type = " ";
		if (Choice == 1) {
			type = "ROCK";
		} else if (Choice == 2) {
			type = "PAPER";
		} else {
			type = "SCISSORS";

		}
		return type;
	}

	// It prints out who won or if it was a tie
	public static void winner(String player, int plWin, int pcWin, int draw) {
		String end = "";
		if (pcWin == plWin) {
			end = "We are evenly matched.";

		} else if (pcWin < plWin) {
			end = "You, " + player + ", are a master at ROCK, PAPER, SCISSORS.";

		} else {
			end = "I, Computer, am a master at ROCK, PAPER, SCISSORS.";

		}
		System.out.print(end);

	}

	// prints out the score of the match
	public static void endGame(int numR, String player, int plWin, int pcWin, int draw) {
		System.out.println("");
		System.out.println("Number of games of ROCK PAPER SCISSORS: " + numR);
		System.out.println("Number of times Computer" + " won: " + pcWin);
		System.out.println("Number of times " + player + " won: " + plWin);
		System.out.println("Number of draws: " + draw);

	}

	/*
	 * * Build the random player. If args is length 0 then the * default
	 * RandomPlayer is built that follows a predictable * sequence. If
	 * args.length > 0 then we assume we can * convert the first element to an
	 * int and build the * RandomPlayer with that initial value.
	 */ public static RandomPlayer buildRandomPlayer(String[] args) {
		if (args.length == 0) {
			return new RandomPlayer();
		} else {
			int seed = Integer.parseInt(args[0]);
			return new RandomPlayer(seed);
		}
	}
}
