import java.util.Random;
// CodeDoor - Door that has a code that must
// be entered properly to open.
public class CodeDoor implements Door {
  /* Stores value of users current key values */
  private char[] keys;
  /* Stores value of the doors correct key value 
     to be compared against user keys.*/
  private char[] code;

/* CodeDoor - Creates a CodeDoor object
 * initialized with a random code.
**/
  public CodeDoor(){
    Random rand = new Random();
    char c1 = rand.nextBoolean() ? 'X' : 'O';
    char c2 = rand.nextBoolean() ? 'X' : 'O';
    char c3 = rand.nextBoolean() ? 'X' : 'O';
    code = new char[]{c1, c2, c3};
    keys = new char[]{'O', 'O', 'O'};
  }
/* examine - Gives information about how door works
 * and how it is opened.
 * @return String telling how door works.
**/
  @Override
  public String examine(){
    return "A door with a coded keypad with three characters. Each key toggles a value with X or O.";
  }
/* menu - Gives options related to current door.
 * @return String representing menu of options.
**/ 
  @Override
  public String menu(){
		return "1. Press Key 1\n2. Press Key 2\n3. Press Key 3";
  }
/* unlock - User applies choice to try and unlock door
 * @param option the user chose
 * @return String representing how user choice affected door.
**/
  @Override
  public String unlock(int option){
		if (option == 1) {
      keys[0] = keys[0] == 'O' ? 'X' : 'O';
      return "Key 1 set to " + keys[0];
    } else if (option == 2) {
      keys[1] = keys[1] == 'O' ? 'X' : 'O';
      return "Key 2 set to " + keys[1];
    } else if (option == 3) {
      keys[2] = keys[2] == 'O' ? 'X' : 'O';
      return "Key 3 set to " + keys[2];
    }
    return "Invalid key number";
  }
/* open - checks if doors is open
 * @return boolean that is true if door is open
**/
  @Override
  public boolean open(){
		if(code[0] == keys[0] && code[1] == keys[1] && code[2] == keys[2]) {
			return true;
		}
    return false;
  }
/* clue - gives a clue about how to open door.
 * @return String representing the clue.
**/ 
  @Override
  public String clue(){
    int numCorrect = 0;
		for (int i = 0; i < 3; ++i) {
      if (code[i] == keys[i]) {
        numCorrect++;
      }
    }
    return "Number of correct items: " + numCorrect;
  }
/* success - Gives a message that the door is open
 * @return String representing message of door being opened.
**/
  @Override
  public String success(){
    return "Code entered successfully, the door is now open!";
  }
}
