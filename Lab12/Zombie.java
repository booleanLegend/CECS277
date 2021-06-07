/**
* Zombie - Class that extends Monster 
*/
public class Zombie extends Monster {
	/**
	* zombie - Constructor that calls super and passes in the name and hp of zombie object
	* @param n - Name of zombie
	* @param hp - hp of zombie
	*/
	public Zombie() {
		super("Zombie ", 15);
	}

	/**
	* Attack - Overriden method that sets the attack for zombie object
	* @return Returns an int
	*/
	@Override
	public int attack() {
		return 10;
	}
}