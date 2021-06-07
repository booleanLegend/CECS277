import java.util.*;

/**
* Class Board represents Originator that constructs a Memento and is able to revert back to previous state using a Memento
* Board allows for tokens to be placed and to display the board
*/
public class Board {
	/**
	* Instance variable, 2d char array of size 3x3 that holds the token placed on the board
	*/
	private char [][] board = new char[3][3];

	/**
	* Boolean method that places the token in the row and col specified, returns true if succesful placement, false otherwise
	* @param token - Type char, represents the token to be placed, either 'x' or 'o'
	* @param row - Type int, represents the row to place token
	* @param col - Type int, represents the col to place token
	* @return Returns a boolean
	*/
	public boolean placeToken(char token, int row, int col) {
		// Checking if space is empty
		if (board[row][col] == ' ') {
			board[row][col] = token;
			return true;
		}
		return false;
	}
	/**
	* Method that displays the board along with indices for better UI experience
	*/
	public void display() {
		System.out.println("\n  0 1 2");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < board[i].length; j++) {
				if (j <= 2) {
					if (board[i][j] == 0) {
						board[i][j] = ' ';
						System.out.print(board[i][j] + "|");
					} else {
						System.out.print(board[i][j] + "|");
					}
				} else {
					System.out.print(board[i][j]);
				}
			}
			if (i < 2) {
				System.out.println(" ");
				System.out.println(" -------");
			}
		}
		
	}
	/**
	* Memento method that returns the Memento storing the current state of the board
	* @return Returns a new Memento
	*/
	public Memento save() {
		return new Memento(board);
	}
	/**
	* Method that resets the board to a previous state using the Memento
	* @param m - Passes in the Memento to restore to
	*/
	public void restore(Memento m) {
		board = m.getState();
	}
	/**
	* checks if there is a win
	* @param t - passes in the token
	* @return Returns a char
	*/
	public char checkWin(char t) {
		
		if ((board[0][0] == t && board[0][1] == t && board[0][2] == t) || (board[1][0] == t && board[1][1] == t && board[1][2] == t) || (board[2][0] == t && board[2][1] == t && board[2][2] == t)) {
			return t;	// row
		} else if ((board[0][0] == t && board[1][0] == t && board[2][0] == t) || (board[0][1] == t && board[1][1] == t && board[2][1] == t) || (board[0][2] == t && board[1][2] == t && board[2][2] == t)) {
			return t;	// col
		} else if ((board[0][0] == t && board[1][1] == t && board[2][2] == t) || (board[0][2] == t && board[1][1] == t && board[2][0] == t)) {
			return t;	//diagonal
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] != 'x' || board[i][j] != 'o') {
						return 'c';		// there is still room
					}
				}
			}
			return 'd';		// board all filled up
		}
	
	}
}