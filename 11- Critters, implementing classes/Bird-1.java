import java.awt.Color;
/**
 * CS312 Assignment 11.
 *
 * On MY honor, Luis Zamorano, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Luis Zamorano
 * UTEID:ljz238
 * email address:cyclazluis@gmail.com
 * Number of slip days used on this assignment:0
 * 
 */

public class Bird extends Critter {
	private int moves;
	private int numTurn;
	private Direction direct;

	public Bird() {

	}

	// roar if opponent looks like an Ant "%", otherwise pounces
	public Attack fight(String opponent) {
		if (opponent.equals("%")) {
			return Attack.ROAR;
		} else {
			return Attack.POUNCE;
		}
	}

	// always returns false for eating in the bird
	public boolean eat() {
		return false;
	}

	// sets the color of the bird
	public Color getColor() {
		return Color.BLUE;
	}

	// the bird swirls north then east then south and west 3 times each.
	public Direction getMove() {

		if (numTurn % 3 == 0) {
			if (moves % 4 == 0) {
				direct = Direction.NORTH;
			}

			else if (numTurn % 4 == 1) {
				direct = Direction.WEST;		
				

			} else if (moves % 4 == 2) {
				direct = Direction.SOUTH;

			} else {
			direct = Direction.EAST;	

			}
		}

		numTurn++;
		moves++;
		return direct;

	}

	// converts the bird to the appropriate string based on the direction it is facing
	public String toString() {
		String vBird = "";
		if (direct == Direction.WEST) {
			vBird = "<";
		} else if (direct == Direction.SOUTH) {
			vBird = "V";
		}

		else if (direct == Direction.EAST) {
			vBird = ">";
		} else {
			vBird = "^";
		}
		return vBird;

	}

}
