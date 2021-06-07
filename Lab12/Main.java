/**
* Group#: 7
 * Name: Benjamin Okenwa and Matthew Zaldana
 * Date: 11-17-2020
 * Purpose: Purpose of the lab was to create a Monster creator that would build a monster based off of a Monster abstract * * * class. You can add abilities to the monster by calling their respective classes
*/
class Main {
  /**
  * displays the menu to the user
  */
	public static void main(String[] args) {
		System.out.print("Monster Creator!");
		int choice;
		System.out.println("Choose a base monster:\n1. Alien\n2. Beast\n3. Zombie\n");
		choice = CheckInput.getIntRange(1, 3);
		Monster m = new Alien();
		switch (choice) {
			case 1:
				m = new Alien();
        System.out.println("Alien has " + m.getHp() + " hp," + "and attacks for " + m.attack() + " damage");
			case 2:
				m = new Beast();
        System.out.println("Beast has " + m.getHp() + " hp," + "and attacks for " + m.attack() + "damage");
			case 3:
				m = new Zombie();
        System.out.println("Zombie has " + m.getHp() + " hp," + "and attacks for " + m.attack() + "damage");
		}
		System.out.println("Add an ability:\n1. Fire\n2. Flying\n3. Lasers\n4. Poison\n5. Speed\n6. Strength\n7. Quit\n");
		choice = CheckInput.getIntRange(1, 7);
		while (choice != 7) {
			if (choice == 1) {
				m = new Fire(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else if (choice == 2) {
				m = new Flying(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else if (choice == 3) {
				m = new Lasers(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else if (choice == 4) {
				m = new Poison(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else if (choice == 5) {
				m = new Speed(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else if (choice == 6) {
				m = new Strength(m);
				System.out.println(m.getName() + "has " + m.getHp() + " and can attack with this much damage:" + m.attack());
			} else {
				break;
			}
		System.out.println("Add an ability:\n1. Fire\n2. Flying\n3. Lasers\n4. Poison\n5. Speed\n6. Strength\n7. Quit\n");
			choice = CheckInput.getIntRange(1, 7);
		}
		System.out.println("Exiting...");
	}
}