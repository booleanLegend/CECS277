import java.util.Scanner;
import java.util.ArrayList;

class Main {

	public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);
		int inpDir;

		int ROWS, COL;
		ROWS = COL = 10;

		int xPos, yPos;
		xPos = yPos = 0;
		
		char [][] grid = new char [ROWS][COL];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = '.';
			}	
		}
		
		grid[9][9] = 'f';
    
		while (grid[xPos][yPos] != 'f') {
			System.out.println();
			
			bugLoc(grid, xPos, yPos);
			grid[xPos][yPos] = 'x';

			System.out.println ("Choose a direction: ");
			System.out.println ("1. UP");  
			System.out.println ("2. RIGHT");
			System.out.println ("3. DOWN");
			System.out.println ("4. LEFT");

			inpDir = in.nextInt();

			switch (inpDir) {
				case 1:
					if (xPos == 0) {
						System.out.println("Cannot move any further up. Please try again.");
					}
					else
						xPos = (xPos - 1);          
					break;
				case 2:
					if (yPos == 9) {
						System.out.println("Cannot move any further right. Please try again.");
					}
					else
						yPos = ( yPos + 1);          
					break;
				case 3:
					if (xPos == 9) {
						System.out.println("Cannot move any further down. Please try again.");
					}
					else
						xPos = (xPos + 1); 
					break;
				case 4:
					if (yPos == 0) {
						System.out.println("Cannot move any further right. Please try again.");
					}
					else
						yPos = (yPos - 1);   
					break;
				default:
						System.out.println ("Please enter a value from 1-4.");
					break;
			}
    	}
		
		if ( xPos == 9 && yPos == 9) {
			System.out.println("Congratulations! You've reached the end!");
		}
	}

    
  	public static void bugLoc (char [][] arr, int x, int y) {
		arr[x][y] = 'o';
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}	
			System.out.println();
		}
  	}
}
