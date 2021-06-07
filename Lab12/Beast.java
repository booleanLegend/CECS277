/**
* Beast - Class that extends Monster 
*/
public class Beast extends Monster {
	/**
	* Beast - Constructor that calls super and passes in the name and hp of Beast object
	* @param n - Name of Beast
	* @param hp - hp of Beast
	*/
	public Beast() {
		super("Beast ", 8);
	}

	/**
	* Attack - Overriden method that sets the attack for Beast object
	* @return Returns an int
	*/
	@Override
	public int attack() {
		return 7;
	}
}