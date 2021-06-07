import java.util.Random;

public class DeadBoltDoor implements Door {
	/** 
	* bolt1 - boolean variable which stores whether bolt1 is correct bolt to test
	*/
	private boolean bolt1;
	/**
	* bolt2 - boolean variable which stores whether bolt2 is correct bolt to test
	*/
	private boolean bolt2;
	/**
	* @method examine() - returns a string description of the door
	*/
	/**
	* Constructor DeadboltDoor() - Default Constructor
	*/
	public DeadBoltDoor() {
		// Define True as Unlocked, False as Locked
		Random rand = new Random();
		bolt1 = rand.nextBoolean();
		bolt2 = rand.nextBoolean();
	}
	/**
	* @method examine - Overriden method from Door iterface, returns * a string description of the Door
	* @return Returns the door's description
	*/
	@Override
	public String examine() {
		return "You encountered a door with two deadbolts. Both need to be unlocked for the door to open, but you can't tell if they are locked or unlocked.\n";
	}
	/**
	* @method menu() - returns a list of options the user can do to unlock the door.
	*/
	@Override
	public String menu() {
		return "1. Toggle Bolt 1\n2. Toggle Bolt 2\n";
	}
	/**
	* @method unlock() - passes in the user’s menu selection, checks that it is in the bounds of the menu choices, and then performs the action associated with that choice in the attempt to open the door.
	* @param option - passes in the user's guess for the location of the key to unlock the door
	* @return Returns text related to user action
	*/
	@Override 
	public String unlock(int option) {
		// option = CheckInput.getIntRange(1,2);
		if (option < 1 || option >2){
			try{
				throw new Exception();
			} catch (Exception e){
				return ("Array Index Out of Bounds");
			}
		}		
		if (option == 1) {
			if (bolt1) {
				bolt1 = false;
				return "You toggle the first bolt.\nYou jiggle the door. It's locked.";
			} else {
				bolt1 = true;
				return "You toggle the first bolt.\nYou jiggle the door. It feels like one of the bolts is unlocked.\n";
			}
		} else {
			if (bolt2) {
				bolt2 = false;
				return "You toggle the second bolt.\nYou jiggle the door. It's locked.";
			} else {
				bolt2 = true;
				return "You toggle the second bolt.\nYou jiggle the door. It feels like one of the bolts is unlocked.\n";
			}
		}
	}
	/**
	* @method open - tests to see if the door has been unlocked
	* returns, true if it is.
	* @return Returns a boolean
	*/
	@Override
	public boolean open() {
		if (bolt1 && bolt2) {
			return true;
		}
		return false;
	}
	/**
	* @method clue - returns a clue to help the user unlock the door
	* @return Returns a message
	*/
	@Override
	public String clue() {
		return "One of the bolts is in the correct position.";
	}
	/**
	* @method succes - returns the success message for the door.
	* @return Returns a message
	*/
	@Override
	public String success() {
		return "You unlocked both deadbolts and opened the door";
	}
}