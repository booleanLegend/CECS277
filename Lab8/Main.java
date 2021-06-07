/*
* Frank Alvarez
* Zaldana Matthew
* Lab 8
*/
import java.util.Random;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Door door1 = new BasicDoor();
		Door door2 = new LockedDoor();
		Door door3 = new DeadBoltDoor();
		Door door4 = new ComboDoor();
		//Door door5 = new CodeDoor();
		
		System.out.println("Welcome to the Escape Room.\n You must unlock 3 doors to escape...");
		openDoor(door1);
		openDoor(door2);
		openDoor(door3);
		openDoor(door4);
		//openDoor(door5);
		System.out.println("\nCongratulations! You escaped... this time.");
	}

	/**
	* @method openDoor - passes in the door the user will try to unlock. It calls 
	* examine, then menu, gets the user's input, passes the input to the unlock 
	* method. It then calls open, if successful, calls success, otherwise, calls 
	* clue and repeats until successful.
	* @param d - object of type Door, Door to be tested
	*/
	public static void openDoor(Door d) {
		// variable input - stores user's input to unlock the door
		boolean SherlockHolmes = false;
		System.out.println(d.examine());
		while (!SherlockHolmes) {
			System.out.println(d.menu());
			System.out.println(d.unlock(CheckInput.getPositiveInt()));
			SherlockHolmes = d.open();
			if (SherlockHolmes){
				System.out.println(d.success());
				break;
			}
			else {
				System.out.println(d.clue());
			}
		}
	}
}