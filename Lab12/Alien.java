/**
* Alien - Class that extends Monster 
*/
public class Alien extends Monster {
	/**
	* Alien - Constructor that calls super and passes in the name and hp of Alien object
	* @param n - Name of Alien
	* @param hp - hp of Alien
	*/
	public Alien() {
		super("Alien ", 5);
	}

	/**
	* Attack - Overriden method that sets the attack for Alien object
	* @return Returns an int
	*/
	@Override
	public int attack() {
		return 3;
	}
 
}