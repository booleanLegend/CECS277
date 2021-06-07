import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;

/*
Blake Del Rey
Matthew Zaldana
Date: 9/15/2020
Purpose: Create a graphical rectangle creator that accepts valid user input.
Input: User input
Output: A rectangular grid that displays rectangles within it based on user input
*/

class Main {
	public static void main(String[] args) {

		final char DEFAULT_GRID = '.';
    	final int MAX_RECTS = 5;

		char[][] grid = new char[30][30];
    	char[] possibleFonts = {'o', 'x', '*', '#', '$'};
		ArrayList<Rectangle> rectArray = new ArrayList<Rectangle>();
    	int numRects = 0;

    // Populate blank grid
		for (int rowIt = 0; rowIt < grid.length; ++rowIt) {
			for (int colIt = 0; colIt < grid[0].length; ++colIt) {
				grid[rowIt][colIt] = DEFAULT_GRID;
			}
		}

		System.out.print("How many rectangles would you like to draw? ");
		numRects = getIntRange(1, MAX_RECTS);
		for (int rectIt = 0; rectIt < numRects; ++rectIt){
			rectArray.add(getRect(grid));
		}

    // Draw Rectangles
		for (int rectIt = 0; rectIt < rectArray.size(); ++rectIt){
			fillRectangle(grid, rectArray.get(rectIt), possibleFonts[rectIt]);
		}
    	displayGrid(grid);
    
	}

	/**
	* displayGrid prints the grid as its stored in the 2D Array 
	* 
	* @param grid Grid of symbols used to represent space and rectangles 
	*/
	public static void displayGrid(char[][] grid) {
		for (int rowIt = 0; rowIt < grid.length; ++rowIt) {
			for (int colIt = 0; colIt < grid[0].length; ++colIt) {
				System.out.print(grid[rowIt][colIt] + " ");
			}
			System.out.println("");
		}
	}
	
	/**
	* fillRectangle fills the grid with the appropriate symbols given the amount of rectangles
	*
	* @param grid Grid of symbols used to represent space and rectangles
	* @param rect Rectangle object
	* @param font Symbol that will be used to create rectangle
	* @param colFiller Fills in the columns with the symbol passed
	* @param rowFiller Fills in the rows with the symbol passed
	*/
	public static void fillRectangle(char [][] grid, Rectangle rect, char font) {
		for (int colFiller = rect.getX() - 1; colFiller < rect.getX() + rect.getWidth() - 1; ++colFiller) {
			for (int rowFiller = rect.getY() - 1; rowFiller < rect.getY() + rect.getHeight() - 1; ++ rowFiller) {
				grid[rowFiller][colFiller] = font;
			}
		}
	}

	/**
	* getRect gets input from the user to create a rectangle of specific location and size 
	*
	* @param grid Grid of symbols used to represent space and rectangles 
	* @return A rectangle constructed from the specifics entered by user 
	*/
	public static Rectangle getRect(char[][] grid) {
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		int tempX = 0;
		int tempY = 0;
		int tempWidth = 0;
		int tempHeight = 0;

		System.out.print("Enter x value of rectangle within bounds of grid ");
		tempX = getIntRange(1, grid.length);
		System.out.print("Enter y value of rectangle within bounds of grid ");	
		tempY = getIntRange(1, grid[0].length);

		System.out.print("Enter width of rectangle ");
		tempWidth = getIntRange(1, grid.length - tempX + 1);

		System.out.print("Enter height of rectangle ");
		tempHeight = getIntRange(1, grid[0].length - tempY + 1);

    	return new Rectangle(tempX, tempY, tempWidth, tempHeight);

	}

	/**
	* getIntRange prompts the user for an integer within a specific range of values and does
	* not exit until the user enters a valid input
	*
	* @param low lower inclusive boundary for integer to be entered by user
	* @param high higher inclusive boundary for integer to be entered by user 
	*/
	public static int getIntRange(int low, int high) {
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		int returnVal = 0;
		while (!isValid) {
			System.out.print("(" + low + "-" + high + "): ");
			try {
				returnVal = input.nextInt();
				if (returnVal < low || returnVal > high) {
					System.out.println("**INVALID INPUT**");
				} else {
					isValid = true;
				}

			} catch (InputMismatchException exception) {
				if (input.hasNext()) {
					String dummy = input.next();
				}
				System.out.println("**INVALID INPUT**");
			}

		}
		return returnVal;
	}
}
