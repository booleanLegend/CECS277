import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
* class ItemGenerator - generates Items from the file ItemList.txt
*/
public class ItemGenerator {
	/**
	* ArrayList that contains items that can be generated
	*/
	private ArrayList<Item> itemList = new ArrayList<Item>();
	/**
	* Instance variable that stores the ItemGenerator object if it has been created
	*/
  	private static ItemGenerator instance = null;
	/**
	* Constructor that generates Items from the file, created when enemy is created, either magical or regular
	*/
	private ItemGenerator() {
		File ItemList = new File("ItemList.txt");
		try {
			Scanner sn = new Scanner(ItemList);
			do {
				String line = sn.nextLine();
				String [] values = line.split(",");
				Item item = new Item(values[0], Integer.parseInt(values[1]), values[2].charAt(0));
				this.itemList.add(item);
			} while (sn.hasNextLine());
			sn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}		
	}
	/**
	* Method that checks whether an ItemGenerator object has been created, if not, then it makes one, else, it returns the current instance
	* @return An ItemGenerator object
	*/	
	public static ItemGenerator getInstance() {
		if (instance == null) {
			instance = new ItemGenerator();
		}
		return instance;
  	}
	/**
	* Generates item randomly from ItemList.txt
	* @return An item
	*/
	public Item generateItem() {
		Random rand = new Random();
		int ran = rand.nextInt(this.itemList.size());
		return itemList.get(ran).clone();
	}
	/**
	* Method that gets a potion from the itemList and returns it
	* @return An item
	*/
	public Item getPotion() {
		return itemList.get(0);
	}
	/**
	* Method that gets a key from the itemList and returns it
	* @returns An item
	*/
	public Item getKey() {
		return itemList.get(1);
	}
	/**
	* Method that gets armor from the itemList and returns it
	* @return An item
	*/
	public Item getArmor() {
		int index = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getType() == 'a') {
				index = i;
				break;
			}
		}
		return itemList.get(index);
	}
}	