/**
* Decorator class EnemyDecorator incorporates the decorator design pattern for Warlock and Warrior to add extra hp and damage to the hero for levels greate than 1
*/
public abstract class EnemyDecorator extends Enemy {
	/**
	* Instance variable enemy saves the enemy object to use for attacks
	*/
	private Enemy enemy;
	/**
	* Constructor that passses in current enemy, extra name, and extra hp to add
	* @param e - Current enemy
	* @param n - Extra name to include for decoration
	* @param hp - Extra hp to add for decoration
	*/
	public EnemyDecorator(Enemy e, String n, int hp) {
		super(e.getName() + " " + n, e.getHP() + hp, ItemGenerator.getInstance().generateItem());
		enemy = e;
	}
	/**
	* Overriden attack method that allows decorated enemy to attack hero
	* @param e - Entity passed in
	* @return Abstract method
	*/
	@Override
	public String attack(Entity e) {
		return enemy.attack(e);
	}
}