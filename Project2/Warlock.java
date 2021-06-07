import java.util.Random;
/**
* Decorator class when Hero encounters a Warlock, which implements the Magical interface and randomly chooses of its attacks, which are overriden from aforementioned interface
*/
public class Warlock extends EnemyDecorator implements Magical {
	/**
	* Constructor that calls the superclass Enemy to set the Warlock's current name, its additional name, and hp that it's capable of
	* @param e - Current enemy
	*/
	public Warlock(Enemy e) {
		super(e, "Warlock", 1);
	}
	/**
	* Overriden method that the Warlock uses to attack the hero, can use any of the magical attacks depending on the random number generated
	* @param e - Entity passed in
	* @return A function call 
	*/
	@Override
	public String attack(Entity e) {
		final int NUM_ATTACKS = 3;
		String attack = "";
		// Random integer between 1 and hero's max hp
		int randomAttack = (int)((Math.random() * (NUM_ATTACKS)) + 1);
		switch (randomAttack) {
			case 1:
				return magicMissile(e);
			case 2:
				return fireball(e);
			
			case 3:
				return thunderclap(e);
		}
		return attack;		
	}
	/**
	* Overriden string function magicMissile from Magical that allows the Warlock to attack the hero using a magical attack called magic missile. The function returns a string with the attack made and how much damage the enemy incurred with this type of attack.
	* @param e - Passes in an entity such as the hero
	* @return A string
	*/
	@Override
	public String magicMissile(Entity e) {
		final int MAX_DAMAGE = 5;

		//Random integer between 1 and 5 to prolong hero's life
		int randomDamage = (int) ((Math.random() * (MAX_DAMAGE)) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " shoots " + e.getName() + " with a magic missile.\n");
		returnString.append(e.getName() + " takes " + randomDamage + " damage.");
		
		return returnString.toString();
	}
	/**
	* Overriden string function fireball from Magical that allows the Warlock to attack the hero using a magical attack called fireball. The function returns a string with the attack made and how much damage the enemy incurred with this type of attack.
	* @param e - Passes in an entity such as the hero
	* @return A string
	*/
	@Override
	public String fireball(Entity e) {
		final int MAX_DAMAGE = 6;
		//Random integer between 1 and 6 to prolong hero's life
		int randomDamage = (int) ((Math.random() * (MAX_DAMAGE)) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " hits " + e.getName() + " with a fireball for " + randomDamage);
		returnString.append("\ndamage.");
		
		return returnString.toString();
	}
	/**
	* Overriden string function thunderclap from Magical that allows the Warlock to attack the hero using a magical attack called thunderclap. The function returns a string with the attack made and how much damage the enemy incurred with this type of attack.
	* @param e - Passes in an entity such as the hero
	* @return A string
	*/
	@Override
	public String thunderclap(Entity e) {
		final int MAX_DAMAGE = 7;
		//Random integer between 1 and 7 to prolong hero's life 
		int randomDamage = (int) ((Math.random() * (MAX_DAMAGE)) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " hits " + e.getName() + " with Thunderclap for " + randomDamage);
		returnString.append("\ndamage.");
		
		return returnString.toString();
	}
}