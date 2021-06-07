import java.util.Random;

public class LockedDoor implements Door {
	/**
	* keyLocation - Integer that stores the location of the key
	*/
	private int keyLocation;
	/**
	* keyChoice - User guess for key location
	*/
	private int keyChoice;
	/**
	* Constructor LockedDoor - Default Constructor
	*/
	public LockedDoor() {
		Random rand = new Random();
		keyLocation = rand.nextInt(3) + 1;
	}
	/**
	* @method examine - Overriden method from Door iterface, returns * a string description of the Door
	* @return Returns the door's description
	*/
	@Override
	public String examine() {
		String msg = "You encountered a Locked Door that can be opened with a key. Look around to see if you can find it.\n";
		return msg;
	}
	/**
	* @method menu -  returns a list of options the user can do to unlock the door.
	* @return Returns the menu
	*/
	@Override
	public String menu() {
		return "You can: \n1. Look Under Mat\n2. Look Under Flower Pot\n3. Look Under Fake Rock\n";
	}
	/**
	* @method unlock -  passes in the user’s menu selection, checks that it is in the bounds of the menu choices, and then performs the action associated with that choice in the attempt to open the door.
	* @param option - passes in the user's guess for the location of the key to unlock the door
	* @return Returns text related to user action
	*/
	@Override
	public String unlock(int option) {
		keyChoice = option;
		if (option < 1 || option >3){
			try{
				throw new Exception();
			} catch (Exception e){
				return ("Array Index Out of Bounds");
			}
		}		
		//if (CheckInput.getIntRange(1,3) == option) {
		if (option == 1) {
			return "You look under the Mat\n";
		} else if (option == 2) {
			return "You look under the Flower Pot\n";
		} else {
		}
		//}
		return "You look under the Fake Rock\n";
	}
	/**
	* @method open - tests to see if the door has been unlocked, 
	* returns true if it is.
	* @return Returns a boolean
	*/
	@Override
	public boolean open() {
		if (keyLocation == keyChoice) {
			return true;
		}
		return false;
	}
	/**
	* @method clue -  returns a clue to help the user unlock the door.
	* @return Returns a clue
	*/
	@Override
	public String clue() {
		if (keyLocation != keyChoice) {
		}
		return "Try looking somewhere else.\n";
	}
	/**
	* @method success - returns the success message for the door.
	* @return Returns a message
	*/
	@Override
	public String success() {
		return "Congratulations, you opened the door.\n";
	}
}