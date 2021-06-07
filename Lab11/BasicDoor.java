import java.util.Random;
/** BasicDoor class implements the Door Interface*/
public class BasicDoor implements Door {
  /** Boolean value to see if the door has been pushed*/
  private boolean push;
  /** Boolean value to see if input is true (e.g. input is push)*/
  private boolean input;
/** Creates a constructor for the BasicDoor class
* push is set equal to a random boolean
*/
  public BasicDoor() {
    Random rand = new Random();
    this.push = rand.nextBoolean();
  }
  /** Method returns the type of door the user is dealing with
  * @return String representation of door
  */
  @Override
  public String examine() {
    return "Door that can be pushed or pulled.";
  }
  /** Menu options for what the use can door
  * @return String representation of menu
   */

  @Override
  public String menu() {
    return "1. Push\n2. Pull";
  }
  /** Takes in a user choice for menu options, checks that the user input is in the valid boundaries
  * updates the instance variables input if the user pucked the right option
  * @param option the user chose
  * @return String representation of use action 
   */
  @Override
  public String unlock(int option) {
    if (option == 1) {
      this.input = true;
      return "You push the door.";
    }
    else if (option == 2) { 
      this.input = false;
      return "You pull the door.";
    }
    return "Invalid option for type basic door.";
  } 
  /** Method tests to see if the door has been unlocked, returns true if it is
  * @return boolean t/f to see if the door is open
  */
  @Override
  public boolean open() {
    if (push == input) {
      return true;
    }
    return false;
  } 
  /**Method to give the use a clue to unlock the door
  * @return String representation of clue
   */
  @Override
  public String clue() {
    if (push == true) return "Door has a sign that says: \"PUSH\"";
    return "Door has a sign that says: \"PULL\"";
  }
  /** Method gives a success message when the door has been successfully opened
  *@return String representtation of praise
   */
  @Override
  public String success(){
    return "You successfully opened the door!!!";
  }
}