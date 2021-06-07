/**
* Memento class stores an old board so that the a previous turn can be retrieved
*/
public class Memento {
	/**
	* Instance variable, stores previous char board
	*/
	private char [][] board = new char[3][3];
	/**
	* Constructor that passes in the "new" board to be saved into instance variable and be used for future reference
	* @param b - Passes in "new" char array representing the board
	*/
	public Memento (char [][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = b[i][j];
			}
		}
	}
	/**
	* Method that returns the "old" state of the board
	* @return Returns a char array
	*/
	public char [][] getState() {
		return board;
	}
}