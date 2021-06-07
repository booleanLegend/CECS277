import java.util.*;
import java.util.Random;
/**
*Name: Johnerson Li and Matthew Zaldana
* Date: 11-3-2020
* Purpose: To create a progarm that will predict a *user's input between 'X' and 'O' based off patterns of *user's previous inputs.
*/

class Main {
	public static void main(String[] args) {
		System.out.println("Mind Reader!");
		HashMap <String, Integer> hm = new HashMap <String, Integer>();
		char userInput = getInput();
		String ptrn = "";
		int rounds = 1;
		double right = 0.0;
		double total = 0.0;
		while (userInput != 'Q' || userInput != 'q') {
			if (ptrn.length() == 4){
				storePattern(hm, ptrn);
				ptrn = ptrn.substring(1);
			}
			char prediction = makePrediction(hm, ptrn);
			System.out.println("Comp: " + prediction);
			if (prediction == userInput) {
				right++;
			}
			total = right/rounds; 
			System.out.println("% Wins: " + total * 100 + "\n");
			ptrn = ptrn + userInput;
			rounds++;
			userInput = getInput();
		}
		System.out.println("Game Over.");
	}
	/**
	* makePrediction - passes in the HashMap and the pattern string. It uses the last three values in the pattern along w/ possible outcomes to check the HashMap to examine how many more times the user has chosen X over O after that pattern. Retuns the character matching the larger result. If not enough info, return a random result.
	* @param hm - HashMap which has stored the last four inputs as a string (keys) and the corresponding count of the pattern's appearance (values)
	* @param ptrn - String built from the last 4 inputs 
	* @return Returns a char
	*/
	public static char makePrediction(HashMap<String, Integer> hm, String ptrn) {
		String pattern = ptrn;
		if (hm.size() == 0){
			Random rand = new Random();
			int randomInt = rand.nextInt(2);
			if (randomInt == 0){
				return 'X';
			}
			if (randomInt == 1){
				return 'O';
			}
		}
		
		String containsX = pattern.substring(1) + "X";
		String containsO = pattern.substring(1) + "O";
		int valueOfX = 0;
		int valueOfO = 0;

		if (hm.containsKey(containsX)) {
			valueOfX = hm.get(containsX);
		}
		if (hm.containsKey(containsO)) {
			valueOfO = hm.get(containsO);
		}
		if (valueOfX > valueOfO) {
			return 'X';
		}
		return 'O';
	}
	/**
	* getInput - prompt user to enter input. Return input if it's valid, else reprompt
	* @return Returns a char
	*/
	public static char getInput() {
		Scanner in = new Scanner(System.in);
		char input;
		System.out.print("Enter X or O, or Q to quit.\n?: ");
		input = in.next().charAt(0);
		boolean invalidInput = true;
		while(invalidInput == true) {
			if (input == 'Q' || input == 'X' || input == 'O') {	
				invalidInput = false;
			} else {
				System.out.println("Invalid input. Please try again.\n");
				System.out.print("Enter X or O, or Q to quit.\n?: ");
				input = in.next().charAt(0);
			}
		}
		return input;
	}
	/**
	* storePattern - passes in the HashMap and the pattern string. Checks HashMap to see if pattern string exists in the map. It it does, increment its value by 1, otherwise, initialize the pattern with a value of 1.
	* @param hm - HashMap which has stored the last four inputs as a string (keys) and the corresponding count of the pattern's appearance (values)
	* @param ptrn - String built from the last 4 inputs
	*/
	public static void storePattern(HashMap<String, Integer> hm, String ptrn){
		if (hm.containsKey(ptrn)){
			int counter = hm.get(ptrn);
			hm.put(ptrn, counter++);
			return;
		}
		hm.put(ptrn, 1);
	}
}