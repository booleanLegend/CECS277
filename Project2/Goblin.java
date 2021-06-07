/**
* Base enemy class that extends Enemy class and provides base attack for Goblin
*/
public class Goblin extends Enemy {
	/**
	* Constructor that calls super and passes in the base enemy name, max hp, and random Item
	*/
	public Goblin() {
		super("Goblin", 5, ItemGenerator.getInstance().generateItem());
	}
	/**
	* Overriden attack method that passes in the entity to attack and returns a string with how much random damage was given
	* @param e - Entity passed in
	* @return A string
	*/
	@Override
	public String attack(Entity e) {
		final int MAX_DAMAGE = 7;
		// Random integer between 1 and 7 to prolong hero's life
		int randomDamage = (int) ((Math.random() * (MAX_DAMAGE)) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " attacks " + e.getName() + " for " + randomDamage + " damage.");
		
		return returnString.toString();
	} 
}