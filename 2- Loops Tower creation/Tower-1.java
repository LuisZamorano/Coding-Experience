/*
 *  CS312 Assignment 2.
 *  On my honor, Luis Zamorano, this programming assignment is my own work.
 *
 *  A program to print out the UT Tower in ASCII art form.
 *
 *  Name: Luis Zamorano
 *  email address: cyclazluis@gmail.com
 *  UTEID: ljz238
 *  Section 5 digit ID: 50939 
 *  Grader name: Walid Owais 
 *  Number of slip days used on this assignment:0
 */

public class Tower {
	public static final int SIZE = 3;

	public static void main(String[] args) {
		tip();
		longBody();
		colonBase();
		lowerBase();

	}

	// combines the hashtag border and the body of the tip to create the tip
	// of the tower.
	public static void tip() {
		hashTag();
		tipBody();
		hashTag();
	}

	// creates a method for the spacing of the tip sections of the tower
	public static void tipSp() {
		int topSpace = SIZE * 4 + 2;
		for (int lefts = 0; lefts < topSpace; lefts++) {
			System.out.print(" ");
		}
	}

	// creates the body section of the tip
	public static void tipBody() {
		int numLines = SIZE * 2 - 2;
		for (int line = 1; line <= numLines; line++) {
			int numPoles = SIZE * 2 - 1;
			tipSp();
			for (int i = 0; i < numPoles; i++) {
				System.out.print("|");
			}
			System.out.println("");
		}
	}

	// The method that creates the hashtags of the tip
	public static void hashTag() {
		int numHash = SIZE * 2 - 1;
		tipSp();
		for (int i = 0; i < numHash; i++) {
			System.out.print("#");
		}
		System.out.println("");
	}

	// Combines the methods numTilde and bodyFloors to create the long section
	public static void longBody() {
		int numFloors = SIZE * SIZE;
		for (int floor = 1; floor <= numFloors; floor++) {
			numTilde();
			bodyFloors();
		}
		numTilde();
	}

	// makes the tildes "~~" for the sections of the long body
	public static void numTilde() {
		int tildeLines = SIZE * 2 + 3;
		bodySpaces();
		for (int i = 0; i < tildeLines; i++) {
			System.out.print("~");
		}
		System.out.println("");
	}
	
	// creates a method for the spacing of the long body of the tower
	public static void bodySpaces() {
		int longSpace = SIZE * 4;
		for (int i = 0; i < longSpace; i++) {
			System.out.print(" ");
		}
	} 
	
	// makes the body using the pairs of "-o"
	public static void bodyFloors() {
		int numPair = SIZE;
		bodySpaces();
		System.out.print("|");
		System.out.print("");
		for (int i = 0; i < numPair; i++) {
			System.out.print("-O");
		}
		System.out.print("-|");
		System.out.println("");
	}

	

	// Creates the lower platform base of the tower by using the platform floors
	// through a loop
	public static void lowerBase() {
		int platforms = SIZE;
		for (int pl = 1; pl <= platforms; pl++) {
			platformFloors();
		}
		System.out.println("");
	}

	// creates the colon base upper part of the tower
	public static void colonBase() {

		// makes the num of rows based on size

		int totalRows = (SIZE / 2 + 1);
		for (int line = 1; line <= totalRows; line++) {

			// creates spacing
			 int colonSp = (totalRows - line) * 3;
			for (int spaces = 0; spaces < colonSp; spaces++) {
				System.out.print(" ");

			}

			System.out.print("/");
			int numCols = (SIZE * 5) - colonSp;
			for (int cpairs = 0; cpairs < numCols; cpairs++) {
				System.out.print("\"'");
			}
			System.out.println("\"\\");
		}
	}
	
	// makes the "\"O" pattern for the platform
	public static void platformFloors() {
		int numTotalPairs = SIZE * 5;
		System.out.print("/");
		for (int pairs = 0; pairs < numTotalPairs; pairs++) {
			System.out.print("\"O");
		}
		System.out.println("\"\\");

	}
}