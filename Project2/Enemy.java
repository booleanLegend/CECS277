/**
* Class Enemy - Abstract Enemy class extends abstract Entity class and overrides super class Entity functions such as attack and toString. 
Allows the enemy to interact with the hero
*/
public abstract class Enemy extends Entity {
	/** 
	* Instance variable item enemy has in inventory
	*/
	private Item item;
	/** 
	* Constructor Passes in name of enemy, maxHp, and item to use
	* @param n - Name of enemy
	* @param mHp - max Hp of enemy
	* @param i - item enemy will use
	*/
	public Enemy(String n, int mHp, Item i) {
		super(n, mHp);
		item = i;
	}
	/**
	* Method that gets the enemy's item
	* @return An item
	*/
	public Item getItem() {
		return item;
	}
	/**
	* Abstract attack method that passes in an entity e which performs an attack a returns a String
	* @param e - Of type entity which is passed in to perform an attack
	*/
	@Override
	public abstract String attack(Entity e);
}