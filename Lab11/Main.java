//CECS277 LAB 8
//@author Benjamin Okenwa
//@author Gabriel Zermeno
//@author Francisco Rivera
import java.util.*;
class Main {
/* getPositiveInt - Returns a user integer that is positive
 * @return the integer value the user inputs.
**/
  public static int getPositiveInt() {
    Scanner scnr = new Scanner(System.in);
    boolean inputError = true;
    int in = 0;
    do {
      try {
        in = scnr.nextInt();
        inputError = false;
      } catch ( InputMismatchException e ) {
        System.out.println("Invalid input, must enter a number:");
        scnr.next();
      }
    } while (inputError == true);
    while (in < 0) {
      System.out.println("Enter a valid positive number:");
      inputError = true;
      do {
        try {
          in = scnr.nextInt();
          inputError = false;
        } catch ( InputMismatchException e ) {
          System.out.println("Invalid input, must enter a number:");
          scnr.next();
        }
      } while (inputError == true);
    }
    return in;
  }
/** Method will have user attempt to open a door 
* @param method is passed a door from main
*/	
  public static void openDoor( Door d ) {
    System.out.println(d.examine());
    do {
      System.out.println(d.menu());
      int input;
      input = getPositiveInt();
      System.out.println(d.unlock(input));
      if (d.open() == true) {
        System.out.println(d.success());
      } else {
        System.out.println(d.clue());
      }
    } while (d.open() == false);
  }
  public static void main(String[] args) {
    Random rand = new Random(); 
		ArrayList<Door> doors =  new ArrayList<Door>(); // list of doors 
    BasicDoor basicDoor = new BasicDoor();
    ComboDoor comboDoor = new ComboDoor();
    CodeDoor codeDoor = new CodeDoor();
    LockedDoor lockedDoor = new LockedDoor();
    DeadboltDoor deadDoor = new DeadboltDoor();
    doors.add(basicDoor);
    doors.add(comboDoor);
		doors.add(codeDoor);
		doors.add(lockedDoor);
		doors.add(deadDoor);

    // Game loop
    System.out.println("Welcome to the Escape Room\nYou must unlock 3 doors to leave...\n");
    for (int i = 0; i < 3; ++i) {
      int index = rand.nextInt(doors.size());
      openDoor(doors.get(index));
      doors.remove(index);
      System.out.println();
    }
    System.out.println("You have finished the escape room!!!!!");
  }
}