import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Luis Zamorano
 * @version 2/18/2016 CS312 Assignment 3.
 * 
 *          On my honor, Luis Zamorano, this programming assignment is my own
 *          work and I have not shared my solution with any other student in the
 *          class.
 *
 *          A program to print out various scintillation grids and a student
 *          designed drawing.
 *		
 *		Name: Luis Zamorano
 *  	email address: cyclazluis@gmail.com
 *  	UTEID: ljz238
 *  	Section 5 digit ID: 50939 
 *  	Grader name: Walid Owais 
 *  	Number of slip days used on this assignment:0
 * 
 */

public class ScintillationGrid {

	// Main method that creates the DrawingPanel with scintillation grids.
	// Restricted to chapters 1 - 3 of Building Java Programs
	public static void main(String[] args) {

		/*
		 * In the final version of the program DO NOT call method drawingOne
		 * from main or anywhere else in the program
		 */

		DrawingPanel drawP = new DrawingPanel(900, 650);
		Graphics g = drawP.getGraphics();
		drawP.setBackground(Color.CYAN);

		// The drawGrid methods
		// x and y coordinates for the parameters go first
		// the large size square value goes first "laSize" and followed by the
		// small size one "smSize"
		// the last two parameters are the number of lines "numL" in the figure
		// followed by the thickness of them "lineThick"
		drawGrid(g, 0, 0, 348, 75, 3, 16);
		drawGrid(g, 400, 50, 422, 50, 6, 12);
		drawGrid(g, 50, 400, 220, 100, 1, 20);
		drawGrid(g, 500, 500, 148, 15, 7, 4);

	}

	// The method that draws the ScintillationGrid
	public static void drawGrid(Graphics g, int x, int y, int laSize, int smSize, int numL, int lineThick) {

		// initially sets the background colors of the squares and makes the
		// appropriate size black ones
		g.setColor(Color.BLACK);
		g.fillRect(x, y, laSize, laSize);
		crossL(g, x, y, laSize, smSize, lineThick, numL);
		drawCirc(g, x, y, laSize, smSize, lineThick, numL);
	}

	// the method that draws the gray lines
	public static void crossL(Graphics g, int x, int y, int laSize, int smSize, int lineThick, int numL) {

		g.setColor(Color.GRAY);

		// loop for horizontal lines of the grid
		for (int i = 0; i < numL; i++) {

			g.fillRect(x, y + (i * (smSize + lineThick) + smSize), laSize, lineThick);

		}

		// loop that draws the vertical gray lines of the grid
		for (int i = 0; i < numL; i++) {

			g.fillRect(x + (i * (smSize + lineThick) + smSize), y, lineThick, laSize);
		}
	}

	// this draws the white circles and aligns them as well
	public static void drawCirc(Graphics g, int x, int y, int laSize, int smSize, int lineThick, int numL) {
		g.setColor(Color.WHITE);

		// this equation makes the circle the correct thickness by increasing it
		// by 40 percent
		int radius = (int) Math.round(lineThick * .4 + lineThick);

		// this equation divides by half the 40 percent
		int subradius = (int) Math.round(lineThick * .4 / 2);

		// loop for positioning
		// formula is for x values it's the original x value added to the size
		// of small squares
		// and adding the thickness of the line and and small squares again
		// multiplied by the difference
		// of the sub radius and inner loop.The y value is the same except you
		// multiply by the outer loop
		// the height and width are just the adjusted radiuses
		for (int i = 0; i < numL; i++) {

			for (int j = 0; j < numL; j++) {

				g.fillOval((x + smSize + (smSize + lineThick) * j - subradius),
						(y + smSize + (smSize + lineThick) * i - subradius), radius, radius);
			}
		}
	}

	// method for the student designed drawing
	// NOT restricted to chapters 1 - 3 of Building Java Programs
	// This method creates the standard figure
	public static void drawingOne() {
		DrawingPanel p = new DrawingPanel(400, 200);
		Graphics g = p.getGraphics();
		// sets the color to green for the background
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 400, 200);
		g.drawOval(0, 0, 200, 100);
		// sets color for oval to red
		g.setColor(Color.RED);
		g.fillOval(0, 0, 200, 100);
		g.drawOval(200, 100, 200, 100);
		g.setColor(Color.RED);
		g.fillOval(200, 100, 200, 100);
		// sets the color of the lines
		// the following coding creates the lines for the ovals
		g.setColor(Color.BLACK);
		g.drawLine(100, 100, 100, 0);
		g.drawLine(200, 200, 200, 0);
		g.drawLine(0, 100, 400, 100);
		g.drawLine(300, 100, 300, 200);
		g.drawLine(200, 150, 400, 150);
		g.drawLine(0, 50, 200, 50);
	}
}
