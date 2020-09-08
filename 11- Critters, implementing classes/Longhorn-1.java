import java.awt.Color;

/**
 * CS312 Assignment 11.
 *
 * On MY honor, Luis Zamorano, this programming assignment is MY own work and I
 * have not provided this code to any other student.
 *
 * Student name: Luis Zamorano
 * UTEID:ljz238
 * email address:cyclazluis@gmail.com
 * Number of slip days used on this assignment:0
 * 
 */

public class Longhorn extends Critter {
	private Attack struggle;
	private int moveNum;
	private int totalRuns;
	private Direction way;

	public Longhorn() {

	}

	//longhorn kills birds, vultures, rocks and hippos.
	public Attack fight(String opponent) {
		if (opponent.equals("^")) {
			struggle = Attack.SCRATCH;
		} else if (opponent.equals(">")) {
			struggle = Attack.SCRATCH;

		}

		else if (opponent.equals("V")) {
			struggle = Attack.SCRATCH;
		} else if (opponent.equals("<")) {
			struggle = Attack.SCRATCH;
		}

		else if (opponent.equals("S")) {
			struggle = Attack.POUNCE;
		} else if(opponent.equals("0")){
			struggle = Attack.SCRATCH;
		}
		else{
			struggle= Attack.ROAR;
		}
		return struggle;
	}

	// the longhorn will only go orange if it successfully fought or destroyed another
	// critter, otherwise it remains white
	public Color getColor() {
		if (struggle == Attack.SCRATCH || struggle == Attack.POUNCE) {
			return Color.ORANGE;
		} else {
			return Color.WHITE;
		}
	}

	//the longhorn always eats for extra points
	public boolean eat() {
		return false;

	}

	// the longhorn moves forward (NORTH) in a "T" shaped pattern
	public Direction getMove() {
		if (totalRuns % 5 == 0) {
			if (moveNum % 3 == 0) {
			way = Direction.WEST;
			}
			else if (moveNum%3==1){
				way=Direction.EAST;
			}
			else {
					way = Direction.NORTH;
		

		}
		}
		totalRuns++;
		moveNum++;
		return way;
	}

	/*
	 * longhorn can turn into its "U" form if it was able to
	 * slaughter a bird, otherwise it will forever want to hunt "!"
	 */
	public String toString() {

		if (struggle == Attack.SCRATCH || struggle == Attack.POUNCE) {
			return "U";
		} else {
			return "!";

		}

	}
}
