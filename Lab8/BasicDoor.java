import java.util.Random;

public class BasicDoor implements Door{
	/**
	* push - Boolean push is random and is considered an action
	*/
	private boolean push;
	/**
	* input - Boolean input is found through the input of the user
	*/
	private boolean input;
	/**
	* Constructor BasicDoor - Default Constructor
	*/
	public BasicDoor(){
		Random rand = new Random();
		push = rand.nextBoolean();
		input = false;
	}
	/**
	* @method examine - Overriden method from Door iterface, returns * a string description of the Basic Door
	* @return Returns the basic door's description
	*/
	@Override
	public String examine(){
		return "You encountered a basic door. You can either push it or pull it to open\n";
	}
	/**
	* @method menu -  returns a list of options the user can do to unlock the door.
	* @return Returns the menu
	*/
	@Override
	public String menu(){
		return "1. Push \n2. Pull";
	}
	/**
	* @method unlock -  passes in the user’s menu selection, checks that it is in the bounds of the menu choices, and then performs the action associated with that choice in the attempt to open the door.
	* @param option - passes in the user's guess for the location of the key to unlock the door
	* @return Returns text related to user action
	*/
	@Override
	public String unlock(int option){
		if (option < 1 || option >2){
			try{
				throw new Exception();
			} catch (Exception e){
				return ("Array Index Out of Bounds");
			}
		}
		if (option == 1) {
			if (push) {
				input = true;
			} else {
				input = false;
			}
			return "You push the door\n";
		} else {
			if (!push) {
				input = true;
			} else {
				input = false;
			}
			return "You attempt to pull the door\n";
		}
	}
	/**
	* @method open - tests to see if the door has been unlocked, 
	* returns true if it is.
	* @return Returns a boolean
	*/
	@Override
	public boolean open() {
		if (input) {
			return true;
		}
		return false;
	}
	/**
	* @method clue -  returns a clue to help the user unlock the door.
	* @return Returns a clue
	*/
	@Override
	public String clue(){
		return "Try to do it another way\n";
	}
	/**
	* @method success - returns the success message for the door.
	* @return Returns a message
	*/
	@Override
	public String success(){
		return "You opened the Basic Door!\n";
	} 
}