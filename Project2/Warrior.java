/**
* Decorator class that extends EnemyDecorator. It decorates the enemy with a warrior which adds extra maxHP and can do an extra attack
*/
public class Warrior extends EnemyDecorator {
	/**
	* Constructor that passes in the current enemy's name. Calls super to pass in it's current name, the additional decorator name, and the extra hp
	* @param e - The current enemy
	*/
	public Warrior(Enemy e) {
		super(e, "Warrior", 2);
	}
	/**
	* Overriden attack method with which the warrior can attack for a random amount of damage. It returns the additional damage by calling super's attack and passing in it's name
	* @param e - The enemy's current name
	* @return A string from a super call
	*/
	@Override
	public String attack(Entity e) {
		final int MAX_DAMAGE = 5;

		//Random integer between 1 and 5 to prolong hero's life
		int randomDamage = (int) ((Math.random() * (MAX_DAMAGE)) + 1);
		return randomDamage + super.attack(e);
	}
}