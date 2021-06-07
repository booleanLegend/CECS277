import java.util.ArrayList;
import java.util.Random;

/*
 Name: Matthew Zaldana and Benjamin Okenwa
 Date: 12-8-2020
 Purpose: The purpose of this lab was to create a text based dungeon-crawler game that allows a hero to 
 		fight monsters and collect items and gold. This project incorporates all the concepts of Java we 
		have learned in this class.	
*/


class Main {
	public static void main(String[] args) {
		final char FINISH_CHAR = 'f';
		final char MONSTER_CHAR = 'm';
		final char ITEM_CHAR = 'i';
		final char START_CHAR = 's';

		ItemGenerator.getInstance();
		EnemyGenerator.getInstance();

		int levelNum = 1;
		Map currentMap = Map.getInstance();

    	System.out.print("What is your name, traveler? ");
    	String heroName = CheckInput.getString();
		Hero protag = new Hero(heroName, currentMap);
		int userChoice = 0;

		while (userChoice != 5 && protag.getHP() != 0) {
			System.out.print(protag.toString());
			currentMap.displayMap(protag.getLocation());

			System.out.println("1. Go North");
			System.out.println("2. Go South");
			System.out.println("3. Go East");
			System.out.println("4. Go West");
			System.out.println("5. Quit");
			
			userChoice = CheckInput.getIntRange(1,5);
			switch (userChoice) {
				case 1:
					currentMap.reveal(protag.getLocation());
					protag.goNorth();
					break;
				
				case 2:
					currentMap.reveal(protag.getLocation());
					protag.goSouth();
					break;
				
				case 3:
					currentMap.reveal(protag.getLocation());
					protag.goEast();
					break;
				
				case 4:
					currentMap.reveal(protag.getLocation());
					protag.goWest();
					break;
				
				case 5:
					break;
				
				default:
					System.out.println("Invalid Input! Try Again!");
			}
			
			if (currentMap.getCharAtLocation(protag.getLocation()) == FINISH_CHAR) {
				if (protag.hasKey()) {
					System.out.println("Congrats you passed level " + levelNum + "!");
				++levelNum;
				System.out.println("Level " + levelNum + " will now be loaded...");
				currentMap.loadMap(levelNum);
				protag.heal(protag.getMaxHP());
				System.out.println(protag.getName() + "\'s HP has been restored!");
				} else {
					System.out.println("Go to the store and buy a key or find a key in the map.");
				}
			}
			if (currentMap.getCharAtLocation(protag.getLocation()) == MONSTER_CHAR) {
				monsterRoom(protag, levelNum);
			}
			if (currentMap.getCharAtLocation(protag.getLocation()) == ITEM_CHAR) {
				itemRoom(protag);
			}
			if (currentMap.getCharAtLocation(protag.getLocation()) == START_CHAR) {
				System.out.println("Would you like to visit the store?\n(Input your choice with a number)\n1.Y\n2.N");
				userChoice = CheckInput.getIntRange(1,2);
				if (userChoice == 1) {
					storeRoom(protag);
				} 
			}
	  	}
    	System.out.println("Game Over");
  	}

	/**
	* Method that executes when hero object encounters a monster room 
	* @param h - Type Hero class that passes in the current Hero object
	* @param level - Passes in the current level the Hero object is in
	* @return - True if monster is defeated, false otherwise
	*/
	public static boolean monsterRoom(Hero h, int level) {
		final int FIGHT_NUM = 1;
		final int RUN_NUM = 2;

		final int PHYSICAL_NUM = 1;
		final int MAGICAL_NUM = 2;

		final int NUM_MAGIC_OPTIONS = 3;

		final int TOTAL_DIRECTIONS = 4;

		final int MAP_SIZE = 5;

		Enemy enemy = EnemyGenerator.getInstance().generateEnemy(level);
		Map m = Map.getInstance();
		Item item = ItemGenerator.getInstance().generateItem();

		int userChoice = 0;

		boolean runFlag = false;
		int maxOptions = 2;

		while(enemy.getHP() != 0 && !runFlag && h.getHP() != 0) {
			System.out.println("You encountered a " + enemy.toString());
			System.out.println("1. Fight");
			System.out.println("2. Run Away");
			if (h.hasPotion()) {
				maxOptions = 3;
				System.out.println("3. Drink Potion");
			}
			userChoice = CheckInput.getIntRange(FIGHT_NUM, maxOptions);
			if (userChoice == FIGHT_NUM) {
				System.out.println("1. Physical Attack");
				System.out.println("2. Magic Attack");
				userChoice = CheckInput.getIntRange(PHYSICAL_NUM, MAGICAL_NUM);
				if (userChoice == PHYSICAL_NUM)	{
					System.out.println(h.attack(enemy));
				} else {
					System.out.println(Magical.MAGIC_MENU);
					userChoice = CheckInput.getIntRange(1, NUM_MAGIC_OPTIONS);
					if (userChoice == 1) {
						System.out.println(h.magicMissile(enemy));
					} else if (userChoice == 2) {
						System.out.println(h.fireball(enemy));
					} else {
						System.out.println(h.thunderclap(enemy));
					}
				}
			} else if (userChoice == RUN_NUM) {
				runFlag = true;
			} else {
				h.drinkPotion();
			}
			if (enemy.getHP() != 0 && !runFlag) {
				System.out.println(enemy.attack(h));
				if (h.hasArmorItem() != -1) {
					System.out.println("The " + enemy.getName() + " attack gets blocked by " + h.getName() + "'s Armor.");
					h.dropItem(h.hasArmorItem());
				}
			}
    	}

		// CASE: HERO DEFEATS MONSTER
		if (!runFlag && h.getHP() != 0 ) {
			// Remove monster space 
			System.out.println("You defeated the " + enemy.getName());
			System.out.println("You found a " + enemy.getItem().getName() + " in its corpse.");
			m.removeCharAtLoc(h.getLocation());
			
			// Pickup item / drop item
			if (!h.pickUpItem(enemy.getItem()))	{
				System.out.println("Inventory Full. Select Item To Drop");
				System.out.print(h.itemsToString());
				System.out.println(h.getNumItems() + 1 + " (new item): " + enemy.getItem().getName());
				int itemToDrop = CheckInput.getIntRange(1, h.getNumItems() + 1);
				if (itemToDrop <= h.getNumItems()) {
					h.dropItem(itemToDrop - 1);

					h.pickUpItem(enemy.getItem());
					System.out.println(h.getName() + " picked up " + enemy.getItem().getName());
				} else {
					System.out.println(h.getName() + " did not pick up " + enemy.getItem().getName());
				}
				
			} else {
				System.out.println(h.getName() + " picked up " + enemy.getItem().getName());
			}
			return true;
		}
		
		// CASE: HERO RUNS
		if (h.getHP() != 0)	{
			boolean validDirection = false;
			while (!validDirection) {
				// Random integer between 1 and number of directions player can move
				int randomDirection = (int) ((Math.random() * (TOTAL_DIRECTIONS)) + 1);

				switch (randomDirection) {
					case 1:
						if (h.getLocation().getY() - 1 >= 0) {
							m.reveal(h.getLocation());
							h.goNorth();
							validDirection = true;
							System.out.println(h.getName() + " successfully ran north!");
						}
						break;
					
					case 2:
						if (h.getLocation().getY() + 1 < MAP_SIZE) {
							m.reveal(h.getLocation());
							h.goSouth();
							validDirection = true;
							System.out.println(h.getName() + " successfully ran south!");
						}
						break;
					
					case 3:
						if (h.getLocation().getX() + 1 < MAP_SIZE) {
							m.reveal(h.getLocation());
							h.goEast();
							validDirection = true;
							System.out.println(h.getName() + " successfully ran east!");
						}
						break;

					case 4:
						if (h.getLocation().getX() - 1 > MAP_SIZE) {
							m.reveal(h.getLocation());
							h.goWest();
							validDirection = true;
							System.out.println(h.getName() + " successfully ran west!");
						}
						break;
				}
			}
		}
		return false;
	}

	/**
	* Method that executes when hero object encounters an item room
	* @param h - Type Hero class that passes in the current Hero object
	* @param m - Type Map Class that passes in the current map object
	* @param ig - Type ItemGenerator class that passes in current item object 
	*/
	public static void itemRoom(Hero h) {
		Item newItem = ItemGenerator.getInstance().generateItem();
		Map m = Map.getInstance();

		System.out.println("You found a " + newItem.getName());
		if (!h.pickUpItem(newItem)) {
			System.out.println("Inventory Full. Select Item To Drop");
			System.out.print(h.itemsToString());
			System.out.println(h.getNumItems() + 1 + " (new item): " + newItem.getName());
			int itemToDrop = CheckInput.getIntRange(1, h.getNumItems() + 1);
			if (itemToDrop <= h.getNumItems()) {
				h.dropItem(itemToDrop - 1);
				h.pickUpItem(newItem);
				System.out.println(h.getName() + " picked up " + newItem.getName());
        		m.removeCharAtLoc(h.getLocation());
			} else {
				System.out.println(h.getName() + " did not pick up " + newItem.getName());
			}
		} else {
			System.out.println(h.getName() + " picked up " + newItem.getName());
      		m.removeCharAtLoc(h.getLocation());
		}
	}
	/**
	* Method that allows interaction with in-game store. Hero can now buy and sell items from store. Store is only available at the start position.
	*@param h - Passes in Hero object
	*/
	public static void storeRoom(Hero h) {
		Item healthPotion = ItemGenerator.getInstance().getPotion();
		Item key = ItemGenerator.getInstance().getKey();
		Item armor = ItemGenerator.getInstance().getArmor();
		int healthPotionPrice = healthPotion.getValue();
		int keysPrice = key.getValue();
		int armorPrice = armor.getValue();

		int buyOrSell, buyChoice, sellChoice;

		System.out.println("WELCOME TO THE STORE!\nIn this store, you can buy or sell things from/to the store.\nWhat would you like to do?\n1.Buy\n2.Sell\n3.Exit store");
		buyOrSell = CheckInput.getIntRange(1, 3);
		
		while (buyOrSell != 3) {
			if (buyOrSell == 1) {
				System.out.println("The store currently is selling these products:\n1.Health Potions @ " + healthPotionPrice + " Gold\n2.Keys @ " + keysPrice + " gold\n3.Armor @ " + armorPrice + " Gold\n4.Exit\nWhat would you like to choose?");
				buyChoice = CheckInput.getIntRange(1, 4);
				// somehow I have to add the item to the inventory, but I don't think I can use pickUpItem() Method 11/30/20
				
				if (buyChoice != 4 && buyChoice == 1) {
					if (h.pickUpItem(healthPotion)) {
						System.out.println("You just bought a Health Potion for " + healthPotionPrice + " Gold!");
						h.spendGold(healthPotionPrice);
					} else {
						System.out.println("You can't buy this item because your inventory is full!\nTry selling an item.");
					}
				} else if (buyChoice != 4 && buyChoice == 2) {
					if (h.pickUpItem(key)) {
						System.out.println("You just bought a Key for " + keysPrice + " Gold!");
						h.spendGold(keysPrice);
					} else {
						System.out.println("You can't buy this item because your inventory is full!\nTry selling an item.");
					}
				} else if (buyChoice != 4 && buyChoice == 3) {
					if (h.pickUpItem(armor)) {
						System.out.println("You just bought Armor for " + armorPrice + " Gold!");
						h.spendGold(armorPrice);
					} else {
						System.out.println("You can't buy this item because your inventory is full!\nTry selling an item.");
					}
				} else {
					break;
				} 
			} else {
				System.out.println("You're in luck.\nThe store will buy anything from your invetory.\nIt looks like your current inventory is:\n" + h.toString() + (h.getNumItems() + 1) + ".Exit\nWhich would you like to sell to the store?");
				sellChoice = CheckInput.getIntRange(1, h.getNumItems() + 1);
				if (sellChoice != (h.getNumItems() + 1)) {
					System.out.println("You sold item: " + h.dropItem(sellChoice).getName() + " to the store!\nThe store gave you " + h.dropItem(sellChoice).getValue() + " gold!\nYou got a damn good price!\nBe happy.");
					h.collectGold(h.dropItem(sellChoice).getValue());
				} else {
					break;
				}
			}
			System.out.println("\nIn this store, you can buy or sell things from/to the store.\nWhat would you like to do?\n1.Buy\n2.Sell\n3.Exit store");
			buyOrSell = CheckInput.getIntRange(1, 3);
		}

		System.out.println("You are now leaving the store.\nSee ya next time.\nYou can always return to the store\nby simply navigating to the 's'!");
	}
}