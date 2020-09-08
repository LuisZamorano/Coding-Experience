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
public class Ant extends Critter {
	private int moves;
	private Direction direct;

	//this sets the direction it will go based on a boolean
	public Ant(boolean walkSouth) {
		if (walkSouth) {
			direct = Direction.SOUTH;
		} else {
			direct = Direction.NORTH;
		}

	}

	// Makes  ant scratch always
	public Attack fight(String opponent) {

		return Attack.SCRATCH;
	}

	//always eats it's true
	public boolean eat() {
		return true;
	}

	// sets the color of the Ant
	public Color getColor() {
		return Color.RED;
	}

	// makes the ant move either south east or north east depending on if it's
	// true or false
	public Direction getMove() {

		moves++;
		Direction result=direct;
		if (moves % 2 == 1) {
			result =direct;
		}
		else{
			result=Direction.EAST;
		}
		return result;
	}

	// sets to string the Ant to be a percentage sign
	public String toString() {
		return "%";
	}

}