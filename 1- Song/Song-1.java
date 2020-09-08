/*
 * CS312 Assignment 1.
 * On my honor, Luis Zamorano , this programming assignment is my own work.
 * Section Number:50565
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Luis Zamorano
 *  email address: cyclazluis@gmail.com
 *  UTEID: ljz238
 *  Section 5 digit ID:50939
 *  Grader name: Walid Owais
 *  Number of slip days used on this assignment: 0
 */
public class Song {

	public static void main(String[] args) {
		intro();
		paragraph2();
		paragraph3();
		paragraph4();
		paragraph5();
		paragraph6();
		paragraph7();
		conclusion();

	}

	// A method for the first line of the song
	public static void firstLine() {
		System.out.print("There was an old woman who swallowed a ");
	}

	// A method for the last segments of the song which include the catch fly
	// paragrapht to avoid redundancy
	public static void lastLines() {
		System.out.println("She swallowed the spider to catch the fly,");
		System.out.println("I don't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
	}

	// The lines that start with "she swallowed " are created in the following
	// portions for each combination of animals with the exception of fly to attempt
	//and reduce redundancy further.

	public static void birdSpider() {
		System.out.println("She swallowed the bird to catch the spider,");
	}

	public static void catBird() {
		System.out.println("She swallowed the cat to catch the bird,");
	}

	public static void dogCat() {
		System.out.println("She swallowed the dog to catch the cat,");
	}

	public static void goatDog() {
		System.out.println("She swallowed the goat to catch the dog,");
	}

	// The introduction of the song a.k.a. first paragraph is created in the
	// following code.
	public static void intro() {
		firstLine();
		System.out.println("fly.");
		System.out.println("I don't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
		System.out.println();
	}

	// The second paragraph
	public static void paragraph2() {
		firstLine();
		System.out.println("spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		lastLines();
		System.out.println();
	}

	// The third paragraph
	public static void paragraph3() {
		firstLine();
		System.out.println("bird,");
		System.out.println("How absurd to swallow a bird.");
		birdSpider();
		lastLines();
		System.out.println();
	}

	// The fourth paragraph
	public static void paragraph4() {
		firstLine();
		System.out.println("cat,");
		System.out.println("Imagine that to swallow a cat.");
		catBird();
		birdSpider();
		lastLines();
		System.out.println();
	}

	// The fifth paragraph
	public static void paragraph5() {
		firstLine();
		System.out.println("dog,");
		System.out.println("What a hog to swallow a dog.");
		dogCat();
		catBird();
		birdSpider();
		lastLines();
		System.out.println();
	}

	// The sixth paragraph
	public static void paragraph6() {
		firstLine();
		System.out.println("goat,");
		System.out.println("She just opened her throat to swallow a goat.");
		goatDog();
		dogCat();
		catBird();
		birdSpider();
		lastLines();
		System.out.println();
	}

	// The seventh paragraph
	public static void paragraph7() {
		firstLine();
		System.out.println("cow,");
		System.out.println("I don't know how she swallowed a cow.");
		System.out.println("She swallowed the cow to catch the goat,");
		goatDog();
		dogCat();
		catBird();
		birdSpider();
		lastLines();
		System.out.println();
	}

	// The eight paragraph
	public static void conclusion() {
		System.out.println("There was an old woman who swallowed a horse,");
		System.out.println("She died of course.");
	}
}
