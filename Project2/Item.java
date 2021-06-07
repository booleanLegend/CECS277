/**
* Class that constructs and returns the name of an item
*/
class Item {
	/**
	* Instance variable that saves the name of item
	*/
	private String name;
	/**
	* Instance variable that saves the amount of gold the item is worth at the store
	*/
	private int value;
	/**
	* Instance variable that saves the type of Item
	*/
	private char type;
	/**
	* Constructor that Initializes with specific value of name
	* @param n - Passes in the name of the item
	* @param val - Passes in the value of the item
	* @param ty - Passes in the type of the item
	*/
	public Item(String n, int val, char ty ) {
		name = n;
    	value = val;
    	type = ty;
	}
	/**
	* Overloaded Constructor that passes in an item to save
	* @param i - a clone of an item
	*/
	public Item (Item i) {
		if (i != null) {
			this.name = i.name;
			this.value = i.value;
			this.type = i.type;
		}
	}
	/**
	* Gets name of the item and returns it
	* @return A string
  	*/
	public String getName() {
		return name;
	}
	/**
	* Method that gets the value of the item
	* @return An int
	*/
	public int getValue() {
		return value;
	}
	/**
	* Method that gets the type of the item
	* @return A char
	*/
	public char getType() {
		return type;
	}
	/**
	* Clones the current Item and returns a new Item when called
	* @return A new Item
	*/
	public Item clone() {
		return new Item(this);
	}
}	