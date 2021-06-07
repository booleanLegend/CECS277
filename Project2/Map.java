import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
* class Map - The Map class provides the overall structure for navigating the game. It can display a new map after each level has been cleared and presents the map with cleared spaces the Hero has visited
*/
class Map {
	/**
	* Instance variable that contains an instance of a Map object
	*/
	private static Map instance = null;
	/**
	* map - Map of dungeon
	*/
	private char[][] map;
	/**
	* Map of what spaces the user can see while playing game
	*/
	private boolean[][] revealed;
	/**
	* Private Constructor that initializes map to be completely unrevealed to map1 as given to us and removes public access to said constructor so that map object is stored in instance 
	*/
	private Map() {
		final int MAP_DIMENSION = 5;
    	final int STARTING_MAP = 1;

		map = new char[MAP_DIMENSION][MAP_DIMENSION];
		revealed = new boolean[MAP_DIMENSION][MAP_DIMENSION];

		loadMap(STARTING_MAP);
	}
	/**
	* Loads the current map and displays by getting the map number the hero is currently exploring
	* @param mapNum - Passes in the current map number the hero is exploring
	*/
	public void loadMap(int mapNum) {
		File mapFile;
		Scanner input;

		final int MAP_DIMENSION = 5;

		if (mapNum >= 4) {
			mapNum = (mapNum % 4) + 1;
		}

		switch (mapNum) {
			case 1:
				mapFile = new File("Map1.txt");
				break;

			case 2:
				mapFile = new File("Map2.txt");
				break;

			case 3:
				mapFile = new File("Map3.txt");
				break;

			default:
				System.out.println("MAP NUMBER DOES NOT EXIST FIRST MAP WILL BE LOADED");
				mapFile = new File("Map1.txt");
				break;
		}
		try {
			input = new Scanner(mapFile);
			String nextLine = "";

			// Y index of row being initialized on map
			int yValue = 0;

			while (input.hasNextLine()) {
				nextLine = input.nextLine();

				// Removes white space from line read in
				nextLine = nextLine.replaceAll("\\s", "");

				// Insert single row into map
				for (int lineParser = 0; lineParser < nextLine.length(); ++lineParser) {
					map[yValue][lineParser] = nextLine.charAt(lineParser);
				}
				++yValue;
			}

			// Make map hidden to user
			for (int yIterator = 0; yIterator < MAP_DIMENSION; ++yIterator) {
				for (int xIterator = 0; xIterator < MAP_DIMENSION; ++xIterator) {
					revealed[yIterator][xIterator] = false;
				}
			}
			input.close();
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
	}
	/**
	* Method that will check whether a Map object has been created, if it hasn't, then returns a new Map, else, returns the stored object
	* @return A Map Object
	*/
	public static Map getInstance() {
		if (instance == null) {
			instance = new Map();
		}
		return instance;
	}
	/**
	* Gets the character at a given location on the map and returns the character
	* @param p Location of character to be returned
	* @return A char
	*/
	public char getCharAtLocation(Point p) {
		if (p.getY() < map.length && p.getY() >= 0 && p.getX() < map.length && p.getX() >= 0) {
			return map[p.getY()][p.getX()];
		} else {
			return '0';
		}
	}
	/**
	* Displays the map to the console, only spots that have been visitied will have its space character revealed. Position of hero will be marked on map
	* Key: s = start, f = finish, m = monster, i = item, n = nothing, * = hero
	* @param p - Current location of hero to be marked when displaying the map
	*/
	public void displayMap(Point p) {
		for (int yIterator = 0; yIterator < map.length; ++yIterator) {
			for (int xIterator = 0; xIterator < map[0].length; ++xIterator) {
				if (yIterator == (int)p.getY() && xIterator == (int)p.getX()) {
					System.out.print("* ");
				} else if (revealed[yIterator][xIterator]) {
					System.out.print(map[yIterator][xIterator] + " ");
				} else {
					System.out.print("x ");
				}
			}
			System.out.println("\n");
		}
	}
	/**
	* Gets the start point location on the map and returns it;
	* @return A Point
	*/
	public Point findStart() {
		final char START_CHAR = 's';
		for (int yIterator = 0; yIterator < map.length; ++yIterator) {
			for (int xIterator = 0; xIterator < map[0].length; ++xIterator) {
				if (map[yIterator][xIterator] == START_CHAR) {
					return new Point(xIterator, yIterator);
				}
			}
		}
		return new Point(0,0);
	}
	/**
	* Sets point p in revealed array to true so that spot is revealed when displaying the map.
	* @param p - Point to be revealed on map
	*/
	public void reveal(Point p) {
		if (p.getY() < map.length && p.getY() >= 0 && p.getX() < map.length && p.getX() >= 0) {
			revealed[(int)p.getY()][(int)p.getX()] = true;
		}
	}
	/**
	* Sets whatever character is at location p to n for nothing
	* @param p - Point to be set to n
	*/
	public void removeCharAtLoc(Point p) {
		final char NOTHING_CHAR = 'n';
		if (p.getY() < map.length && p.getY() >= 0 && p.getX() < map.length && p.getX() >= 0) {
			map[(int)p.getY()][(int)p.getX()] = NOTHING_CHAR;
		}
	}
}
