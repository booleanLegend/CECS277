import java.util.Scanner;
/**
* Group# 09
* Name: Erik Nguyen and Matthew Zaldana
* Date: 11-24-2020
* Purpose: Make an interactive Puppy simulator implmenting the State Pattern Design. 
*/
class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Puppy p = new Puppy();
		int userChoice = 0;
		// Beginning of the program
    	System.out.println("Congratulations on your new puppy!\nWhat would you like to do?");
		do
		{
			System.out.println("1. Feed\n2. Play\n3. Quit");
			userChoice = CheckInput.getIntRange(1, 3);
			switch(userChoice) {
				case 1:
					p.feed();
					break;
				case 2:
					p.play();
					break;
			}
		} while (userChoice == 1 || userChoice == 2);
		System.exit(0);
  	}
}