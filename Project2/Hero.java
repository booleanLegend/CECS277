import java.util.*;
/**
* class Hero - The Hero class aggregates to the Entity class and implements the Magical interface. With these two additional classes, the Hero object can play the game properly. The Hero's class functions aid the hero object in movement, attacking, and interaction with enemies and items. The implementation of the Magical interface allows the hero object to use magical attacks when called for.
*/
public class Hero extends Entity implements Magical {
	/** 
	* Arraylist of Items hero has in inventory
	*/
	private ArrayList<Item> items;
  	/** 
  	* Hero's map of the dungeon calling singleton instance variable
  	*/
  	private Map map = Map.getInstance();
	/** 
	* Hero's Location in dungeon
	*/
	private Point location;
	/**
	* Amount of money Hero has
	*/
	private int gold;
	/** 
	* Constructor for the hero object
	* @param n - Passes in name of hero
	* @param m - Passes in the current map the hero is in
	*/
	public Hero(String n, Map m) {
		super(n, 25);
		map = m;
		items = new ArrayList<Item>();
		location = map.findStart();
	}
	/**
	* Overriden toString function from abstract class Entity that returns a String
	* @return A string
	*/
	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		returnString.append(super.toString());
		returnString.append(this.getGold() + " Gold");
		returnString.append("\n");
		returnString.append("Inventory:\n");
		if (this.getNumItems() != 0) {
			returnString.append(itemsToString());
		}
		return returnString.toString();
	}
	/**
	* A toString function that prints the hero's items
	* @return A string 
	*/
	public String itemsToString() {
		StringBuilder returnString = new StringBuilder();
		for (int itemIt = 0; itemIt < getNumItems(); ++itemIt) {
			returnString.append(itemIt + 1 + ". " + items.get(itemIt).getName() + "\n");
		}
		return returnString.toString();
	}
	/**
	* Gets number of items in inventory and returns it
	* @return An int
	*/
	public int getNumItems() {
		return items.size();
	}
	/**
	* If inventory is not full, an item is added to items and true is returned, otherwise no item is added and false is returned.
	* @param i Item to be picked up
	* @return A boolean
	*/
	public boolean pickUpItem(Item i) {
		final int MAX_ITEMS = 5;
		if (items.size() == MAX_ITEMS) {
			return false;
		}
		items.add(i);
		return true;
	}
	/**
	* If the Hero has a potion in their inventory, consume adding a maximum of 25 to their hp and removing the potion from their inventory
	*/
	public void drinkPotion() {
		final String POTION_NAME = "Health Potion";
		final int HEAL_AMOUNT = 25;
		for (int invIt = 0; invIt < items.size(); invIt++) {
			if (items.get(invIt).getName().equals(POTION_NAME)) {
				super.heal(HEAL_AMOUNT);
				items.remove(invIt);
				break;
			}
		}
	}
	/**
	* dropItem - Returns an item from the items array at the given index from the Hero's inventory
	* @param i - Index of element to return
	* @return An item
	*/
	public Item dropItem(int i) {
		return items.get(i);
	}
	/**
	* Returns true if hero has a potion, false if they do not.
	* @return A boolean
	*/
	public boolean hasPotion() {
		final String POTION_NAME = "Health Potion";
		for (int invIt = 0; invIt < items.size(); invIt++) {
			if (POTION_NAME.equals(items.get(invIt).getName())) {
				return true;
			}
		}
		return false;
	}
	/**
	* Returns true if hero has a key, false if he doesn't
	* @return A boolean
	*/
	public boolean hasKey() {
		final String KEY_NAME = "Key";
		for (int iT = 0; iT < items.size(); ++iT) {
			if (KEY_NAME.equals(items.get(iT).getName())) {
				return true;
			}
		}
		return false;
	}
	/**
	* Uses key if hasKey is true and removes it from inventory to go to the next level
	*/
	public void useKey() {
		final String KEY_NAME = "Key";
		if (hasKey()) {
			System.out.println("There is a key in your inventory.\nYou use it to go to the next level.\nYou must get another key to pass the next level.");
			for (int invIt = 0; invIt < items.size(); invIt++) {
				if (KEY_NAME.equals(items.get(invIt).getName())) {
					items.remove(invIt);
				}
			}
		} else {
			System.out.println("You do not have a key in your inventory.\nGo find a key in the map, then come back here.");
		}
	}
	/**
	* Returns the index of the first armor item in inventory, -1 if there is none
	* @return An int
	*/
	public int hasArmorItem() {
		final char ARMOR_NAME = 'a';
		for (int invIt = 0; invIt < items.size(); invIt++) {
			if (ARMOR_NAME == items.get(invIt).getType()) {
				return invIt;
			}
		}
		return -1;
	}
	/**
	* Gets the amount of gold Hero has
	* @return An int
	*/
	public int getGold() {
		return gold;
	}
	/**
	* Collects the gold for the Hero and adds it to his Gold amount
	* @param g - Amount of gold to collect
	*/
	public void collectGold(int g) {
		this.gold += g;
	}
	/**
	* Spends the gold for the Hero and decreases his Gold amount
	* @param g - Amount of gold to spend
	*/
	public void spendGold(int g) {
		this.gold -= g;
	}
	/**
	* Returns location of hero
	* @return A Point object 
	*/
	public Point getLocation() {
		return location;
	}
	/**
	* Moves hero north if 1 space above is not out of bounds
	* @return A char
	*/
	public char goNorth() {
		final int HIGHEST_Y = 0;
		char returnVal = map.getCharAtLocation(location);
		if (location.getY() > HIGHEST_Y) {
			location.translate(0, -1);
		} else {
			System.out.println("Cannot go any farther North!");
		}
		return returnVal;
	} 
	/**
	* Moves hero south if 1 space below is not out of bounds
	* @return A char
	*/
	public char goSouth() {
		final int LOWEST_Y = 4;
		char returnVal = map.getCharAtLocation(location);

		if (location.getY() < LOWEST_Y) {
			location.translate(0, 1);
		} else {
			System.out.println("Cannot go any farther South!");
		}
		return returnVal;
	} 
	/**
	* Moves hero east if 1 space to the right is not out of bounds
	* @return A char
	*/
	public char goEast() {
		final int RIGHTEST_X = 4;
		char returnVal = map.getCharAtLocation(location);

		if (location.getX() < RIGHTEST_X) {
			location.translate(1, 0);
		} else {
			System.out.println("Cannot go any farther East!");
		}
		return returnVal;
	} 
	/**
	* Moves hero west if 1 space to the left is not out of bounds
	* @return A char
	*/
	public char goWest() {
		final int LEFTEST_X = 0;
		char returnVal = map.getCharAtLocation(location);

		if (location.getX() > LEFTEST_X) {
			location.translate(-1, 0);
		} else {
			System.out.println("Cannot go any farther West!");
		}
		return returnVal;
	}
	/**
	* Overriden string function attack from Entity will allow the hero to attack an enemy. It will do some damage and return what attack it did and how much damage the hero incurred
	* @param e - Passes in an entity 
	* @returns A string 
	*/ 
	@Override 
	public String attack(Entity e) {
		// Random integer between 1 and enemy's max hp
		int randomDamage = (int) ((Math.random() * (e.getMaxHP())) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " attacks " + e.getName() + " for " + randomDamage + " damage.");
		
		return returnString.toString();
	}
	/**
	* Overriden string function magicMissile from Magical that allows the hero to attack an enemy using a magical attack called magic missile. The functions returns a string with the attack made and how much damage the hero incurred with this type of attack.
	* @param e - Passes in an entity
	* @return A string
	*/
	@Override
	public String magicMissile(Entity e) {
		// Random integer between 1 and enemy's max hp
		int randomDamage = (int) ((Math.random() * (e.getMaxHP())) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " shoots " + e.getName() + " with a magic missile.\n");
		returnString.append(e.getName() + " takes " + randomDamage + " damage.");
		
		return returnString.toString();
	}
	/**
	* Overriden string function fireball from Magical that allows the hero to attack an enemy using a magical attack called fireball. The functions returns a string with the attack made and how much damage the hero incurred with this type of attack.
	* @param e - Passes in an entity
	* @return A string
	*/
	@Override
	public String fireball(Entity e) {
		// Random integer between 1 and enemy's max hp
		int randomDamage = (int) ((Math.random() * (e.getMaxHP())) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " hits " + e.getName() + " with a fireball for " + randomDamage);
		returnString.append("\ndamage.");
		
		return returnString.toString();
	}
	/**
	* Overriden string function thunderclap from Magical that allows the hero to attack an enemy using a magical attack called Thunderclap. The functions returns a string with the attack made and how much damage the hero incurred with this type of attack.
	* @param e - Passes in an entity
	* @return A string
	*/
	@Override
	public String thunderclap(Entity e) {
		// Random integer between 1 and enemy's max hp
		int randomDamage = (int) ((Math.random() * (e.getMaxHP())) + 1);
		e.takeDamage(randomDamage);

		StringBuilder returnString = new StringBuilder();
		returnString.append(this.getName() + " strikes " + e.getName() + " with Thunderclap for " + randomDamage);
		returnString.append("\ndamage.");
		
		return returnString.toString();
	}
}