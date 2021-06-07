import java.util.Random;
// DeadboltDoor - Door that must have two deadbolts
// set to correct position before opening.
public class DeadboltDoor implements Door {
  /** Instance variable that store boolean values t/f for the first bolt */
  private boolean bolt1;
  /** Instance variable that store boolean values t/f for the second bolt */
  private boolean bolt2;

  /** constructor -  initializes the instance variable bolt1 and bolt2 with random boolean values t/f */
  public DeadboltDoor(){
    Random ran = new Random();
    this.bolt1 = ran.nextBoolean();
    this.bolt2 = ran.nextBoolean();
  }
/* examine - Gives information about how door works
 * and how it is opened.
 * @return String telling how door works.
**/
  @Override
  public String examine(){
    return "A door with two deadbolts. Both need to be unlocked for the door to open, but you can't tell if they are locked or unlocked";
  }
/* menu - Gives options related to current door.
 * @return String representing menu of options.
**/ 
  @Override
  public String menu(){
    return "1. Toggle Bolt 1\n2. Toggle Bolt 2";
  }
/* unlock - User applies choice to try and unlock door
* @param option the user chose
* @return String representing how user choice affected door.
**/
  @Override
  public String unlock(int option){
    if (option >= 1 && option <= 2){
      if (option == 1){
        this.bolt1 = !this.bolt1;
        return "You toggle the first bolt";

      } else if (option == 2){
        this.bolt2 = !this.bolt2;
        return "You toggle the second bolt";
      }
    }
    return "Error";
  }
/* open - checks if doors is open
 * @return boolean that is true if door is open
**/
  @Override
  public boolean open(){
    if (bolt1 == true && bolt2 == true) {
      return true;
    }
    
    return false;
  }
/* clue - gives a clue about how to open door.
 * @return String representing the clue.
**/ 
  @Override
  public String clue(){
		if (bolt1 == true || bolt2 == true) return "One is in the correct position";
    return "None are in the correct position";
  }
/* success - Gives a message that the door is open
 * @return String representing message of door being opened.
**/
  @Override
  public String success(){
		return "You have successfully opened the deadbolt door!!";
  }
}
