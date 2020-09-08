import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * CS312 Assignment 7.
 * 
 * On my honor, Luis, this programming assignment is my own work and I have not
 * shared my solution with any other student in the class.
 *
 * A program to play determine the extend of home field advantage in sports.
 *
 * email address: cyclazluis@gmail.com UTEID:ljz238
  Number of slip days used on this assignment:1
 *
 */
public class HomeField {

	// Ask the user for the name of a data file and process
	// it until they want to quit.
	public static void main(String[] args) throws IOException {
		System.out.println("A program to analyze home field advantage in sports.\n");
		Scanner keyboard = new Scanner(System.in);
		keepScan(keyboard);
		keyboard.close();
	}

	// this checks if the file is correct and if it is it executes the entire
	// scan of the file
	public static void fileCheck(Scanner keyboard) throws FileNotFoundException {
		int numG = 0;
		int numHGames = 0;
		int teamHScore = 0;
		int teamAwScore = 0;
		int hGameWins = 0;
		System.out.print("Enter the file name: ");
		String fileChoice = keyboard.nextLine();
		File sportsFile = new File(fileChoice);

		// checks for existance of the file
		if (sportsFile.exists()) {
			Scanner sportsReader = new Scanner(sportsFile);
			System.out.println();
			gTitle(sportsReader);
			System.out.println("\nHOME FIELD ADVANTAGE RESULTS\n");

			// checks if there are still lines in the file then scans for data
			while (sportsReader.hasNextLine()) {
				String game = sportsReader.nextLine();
				Scanner scanFile = new Scanner(game);
				numG++;
				scanFile.next();
				numHGames = hGTotal(numHGames, game);

				String teamA = getName(scanFile);
				int teamAPoints = scanFile.nextInt();

				String teamB = getName(scanFile);
				int teamBPoints = scanFile.nextInt();

				// it increases the count of if home team wins
				if (teamA.contains("@") && teamAPoints > teamBPoints) {
					hGameWins++;
				} else if (teamB.contains("@") && teamBPoints > teamAPoints) {
					hGameWins++;
				}

				// creates a score for the team a and b
				if (teamA.contains("@")) {
					teamHScore += teamAPoints;
					teamAwScore += teamBPoints;
				} else if (teamB.contains("@")) {
					teamHScore += teamBPoints;
					teamAwScore += teamAPoints;
				}
			}

			// prints out the scores
			double percentAdvant = percG(numG, numHGames);
			double hPercentage = (double) hGameWins / numHGames * 100;
			double homeMargin = ((double) teamHScore - teamAwScore) / numHGames;
			System.out.printf("Total number of games: %,d\n", +(int) numG);
			System.out.printf("Number of games with a home team: %,d\n", (int) +numHGames);
			System.out.printf("Percentage of games with a home team: " + percentAdvant + "%%\n");
			System.out.printf("Number of games the home team won: %,d\n", +hGameWins);
			System.out.printf("Home team win percentage: %.1f%%\n", hPercentage);
			System.out.printf("Home team average margin: %.2f\n", homeMargin);
			System.out.println();
		}

		// prompts the user to re-enter if the file is non-existent
		else {
			System.out.println("Sorry, that file does not exist");
			fileCheck(keyboard);

		}

	}

	// creates the number of homegames
	public static int hGTotal(int numHGames, String game) {
		if (game.contains("@")) {
			numHGames++;
		}
		return numHGames;
	}

	// it scans the file to show the title
	public static void gTitle(Scanner sportsReader) {
		String sTitle = sportsReader.nextLine();
		String sYear = sportsReader.nextLine();
		String sFullTitle = "**********   " + sTitle + " --- " + sYear + "   **********";
		System.out.println(sFullTitle);

	}

	// calculates the percentage of home games
	public static double percG(int numG, int homeGames) {
		double percentHome = Math.round((double) (homeGames) / (numG) * 100 * 10);
		percentHome = percentHome / 10;
		return percentHome;
	}

	// it checks if the scan is valid
	public static String getName(Scanner scanFile) {
		String checkName = "";
		while (scanFile.hasNext() && !scanFile.hasNextInt()) {
			checkName += scanFile.next();
		}
		return checkName;
	}

	// restarts the method by prompting user
	public static void keepScan(Scanner keyboard) throws FileNotFoundException {
		String rePlay = "Y";
		while (rePlay.equals("Y")) {
			fileCheck(keyboard);
			System.out.println("Do you want to check another data set?");
			System.out.print("Enter Y or y for to analyze another file, anything else to quit: ");
			rePlay = keyboard.nextLine().toUpperCase();
			System.out.println();
		}
	}

}