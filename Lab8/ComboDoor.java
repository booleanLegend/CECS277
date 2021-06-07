import java.util.Random;

public class ComboDoor implements Door {
	/**
	* comboValue - random integer value that holds the true key of door
	*/
	private int comboValue;
	/**
	* input - integer provided by the user input.
	*/
	private int guess;
	
	public ComboDoor() {
		Random rand = new Random();
		comboValue = rand.nextInt(10) + 1;
	}

	@Override
	public String examine() {
		return "A door with a combination lock. You can spin the dial to a number 1-10";
	}
	/**
	* @method menu() - returns a list of options the user can do to unlock the door.
	*/
	@Override
	public String menu() {
		return "Enter # 1-10:";
	}
	/**
	* @method unlock -  passes in the user’s menu selection, checks that it is in the bounds of the menu choices, and then performs the action associated with that choice in the attempt to open the door.
	* @param option - passes in the user's guess for the location of the key to unlock the door
	* @return Returns text related to user action
	*/
	@Override
	public String unlock(int choice) {
		// choice = CheckInput.getIntRange(1, 2);
		if (choice < 1 || choice > 10){
			try{
				throw new Exception();
			} catch (Exception e){
				return ("Array Index Out of Bounds");
			}
		}		
		guess = choice;
		return "You turn the dial...";
	}
	/**
	* @method open - tests to see if the door has been unlocked
	* returns, true if it is.
	* @return Returns a boolean
	*/
	@Override
	public boolean open() {
		if (comboValue == guess) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* @method clue - returns a clue to help the user unlock the door
	* @return Returns a message
	*/
	@Override
	public String clue() {
		if (guess > comboValue) {
			return "Too High";
		} else {
			return "Too Low";
		}
	}
	/**
	* @method succes - returns the success message for the door.
	* @return Returns a message
	*/
	@Override
	public String success() {
		return "You opened the Combo Door!";
	}
}