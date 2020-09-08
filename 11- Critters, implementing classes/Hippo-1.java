import java.awt.Color;
import java.util.Random;
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
public class Hippo extends Critter {
	private int hungry;
	private boolean eating;
	private int max = 3;
	private int min = 0;
	private Direction direct;
	private int turns;

	public Hippo(int hunger) {
		hungry = hunger;
		eating = eat();
	}

	// The hippo scratches if it is hungry else it pounces
	public Attack fight(String opponent) {

		if (eating == true && hungry > 0) {
			return Attack.SCRATCH;
		} else {
			return Attack.POUNCE;
		}
	}

	// the color of the hippo changes depending on if he is hungry or not. Gray
	// if hungry white if not
	public Color getColor() {
		if (eating == true && hungry > 0) {
			return Color.GRAY;
		} else {
			return Color.WHITE;
		}

	}

	// the hippo returns true every time it is still hungry otherwise it will
	// return false
	public boolean eat() {
		if (hungry > 0) {
			hungry--;
			return true;
		} else {
			return false;
		}

	}

	// returns the number of hunger has based on the int provided
	public String toString() {
		String hippoStr = hungry + "";

		return hippoStr;

	}

	// creates the movement of the hippo which will move five times based on the selected
	// direction then chooses another random direction
	public Direction getMove() {
		Random hip = new Random();
		int randMove = hip.nextInt(5);
		if (turns % 5 == 0) {
			if (randMove == 0) {
				direct = Direction.NORTH;
			}

			else if (randMove == 1) {
				direct = Direction.SOUTH;

			} else if (randMove == 2) {
				direct = Direction.EAST;

			} else {
				direct = Direction.WEST;

			}
		}
		turns++;
		return direct;

	}
}
