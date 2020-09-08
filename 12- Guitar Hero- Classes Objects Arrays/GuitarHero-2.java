/*****************************************************************************
 * Compilation: javac GuitarHeroLite.java Execution: java GuitarHeroLite
 * Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 * Plays 37 guitar strings ranging from (q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/')
 * when the user types the lowercase letters 'a' and 'c', respectively in the
 * standard drawing window.
 *
 * /** CS312 Assignment 12.
 *
 * On MY honor, Luis Zamorano, this programming assignment is MY own work and I
 * have not provided this code to any other student.
 *
 * Student name: Luis Zamorano 
 * UTEID:ljz238 
 * 
 */

public class GuitarHero {

	public static void main(String[] args) {
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; 
		// The keys that play the sounds
		// Create 37 guitar strings for the keyboard
		GuitarString[] tune= new GuitarString[37]; 
		for(int position=0; position<keyboard.length(); position++){
			double freq= 440*Math.pow(1.05956,position-24);
			tune[position]= new GuitarString(freq);
		}

		// creates the text that is drawn
		final double TEXT_POS_X = .5;
		final double TEXT_POS_Y = .2;
		final double TEXT_POS_XBLACK = .5;//position for the welcome message
		final double TEXT_POS_YWHITE = .8;//position for the welcome message

		StdDraw.text(TEXT_POS_XBLACK, TEXT_POS_YWHITE, "Welcome To Guitar Hero!!");
		StdDraw.text(TEXT_POS_XBLACK, TEXT_POS_YWHITE - .1, "Type any of the available keys to produce a tune");
		StdDraw.text(TEXT_POS_X, TEXT_POS_Y," The \"white keys\" are on the qwerty and zxcv rows and the \"black keys\"");
		StdDraw.text(TEXT_POS_X, TEXT_POS_Y - .1, " are on the 12345 and asdf rows of the keyboard.");

		stroke(tune, keyboard);

	}

	// plays the requested key and loops it as long as the user keeps playing 
	private static void stroke(GuitarString[] tune, String keyboard) { // the main input loop

		while (true) {

			// check if the user has typed a key, and, if so, process it
			if (StdDraw.hasNextKeyTyped()) {

				// the user types this character and plucks the corresponding string
				char key = StdDraw.nextKeyTyped();
				int place= keyboard.indexOf(key);
				if(0<=place && place <tune.length){
					tune[place].pluck();

				}


			}

			// compute the superposition of the samples
			double total=0;
			for(int i=0; i<tune.length;i++){
				total+=tune[i].sample();

			}

			// send the result to standard audio
			StdAudio.play(total);

			// advance the simulation of each guitar string by one step for each cell 
			for(int spot=0; spot<tune.length;spot++){
				tune[spot].tic();

			}
		}

	}

}