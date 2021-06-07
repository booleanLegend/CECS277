import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;

/**
* EnemyGenerator reads EnemyList.txt to generate enemies
*/
public class EnemyGenerator {
	/**
	* enemyList - ArrayList that generates enemies from the file
	*/
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	/**
	* ig - Generated item from itemlist.txt file
	*/
	private ItemGenerator ig;
	/**
	* Instance variable that stores an EnemyGenerator Object
	*/
	private static EnemyGenerator instance = null;
	/**
	* Constructor that randomly generates one of the base enemies at the level of the hero
	*/
	private EnemyGenerator() {
	}
	/**
	* Randomly creates a new enemy with difficulty depending on level
	* @param level - Level of the hero, used to generate different enemy difficulty
	* @return An enemy Object
	*/
	public Enemy generateEnemy(int level) {
		Random rand = new Random();
		int randEnemy = rand.nextInt(4) + 1;
		int randDecEnemy = rand.nextInt(2) + 1;
		Enemy e = new Froglok();

		if (level == 1) {
			switch (randEnemy) {
				case 1:
					e = new Froglok();
				case 2:
					e = new Goblin();
				case 3:
					e = new Orc();
				case 4:
					e = new Troll();
			}
		} else {
			switch (randEnemy) {
				case 1:
					e = new Froglok();
					break;
				case 2:
					e = new Goblin();
					break;
				case 3:
					e = new Orc();
					break;
				case 4:
					e = new Troll();
					break;
			}
			for (int i = 1; i < level; i++) {
				switch (randDecEnemy) {
					case 1:
						e = new Warlock(e);
						break;
					case 2:
						e = new Warrior(e);
						break;
				}
			}
		}
		return e;
	}
	/**
	* Method that will check whether a EnemyGenerator object has been created, if it hasn't, then returns a new EnemyGenerator, else, returns the stored object
	* @return A Map Object
	*/
	public static EnemyGenerator getInstance() {
		if (instance == null) {
			instance = new EnemyGenerator();
		}
		return instance;
  	}
}	