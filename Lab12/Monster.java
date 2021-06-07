/**
* Monster - Abstract class that creates a monster based on name and hp.
* Continously renews its name and its hp
*/
public abstract class Monster {
	//	name - Instance variable for name of monster
	private String name = "";
	// hp - Instance variable for hp of monster
	private int hp;
	/**
	* Monster - Constructor that sets the name and the hp for the monster created
	* @param n - Name of the monster
	* @mhp - Current hp of the monster
	*/
	public Monster(String n, int mhp) {
		name = n;
		hp = mhp;
  	}
	
	/**
	* getName - Method that returns the name of the monster
	* @return name - Returns a string
	*/
	public String getName(){
    	return name;
  	}

	/**
	* getHp - Method that returns the current hp of the monster
	* @return hp - Returns an int
	*/
  	public int getHp(){
    	return hp;
  	}

	/**
	* attack - Abstract method which all subclasses must override for each monster
	* 
	*/
  	public abstract int attack();
}	