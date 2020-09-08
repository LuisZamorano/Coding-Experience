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
public class Vulture extends Bird {
	private boolean hungry;

	public Vulture(){
		hungry=true;
	}
	
	//sets color of the Vulture
	public Color getColor() {
		return Color.BLACK;
	}
	
	//eats after it fights and is initially hungry
	public boolean eat(){
	boolean hunger=hungry;
	hungry=false;
	return hunger;
		
	}
	

	
}
