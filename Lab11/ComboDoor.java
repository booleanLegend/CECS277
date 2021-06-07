import java.util.Random;
// ComboDoor - Door that must have correct
// value for door to open.
public class ComboDoor implements Door {
  int comboValue;
  int guess;
/* ComboDoor - Creates a ComboDoor intiialized
 * with a random integer for its combo value.
**/
  public ComboDoor() {
    Random rand = new Random();
    this.comboValue = rand.nextInt(10) + 1;
  }
/* examine - Gives information about how door works
 * and how it is opened.
 * @return String telling how door works.
**/
  @Override
  public String examine() {
    return "A door with a combination lock.  You can spin the dial to a number 1-10.";
  }
/* menu - Gives options related to current door.
 * @return String representing menu of options.
**/ 
  @Override
  public String menu() {
    return "Enter a number 1-10.";
  }
/* unlock - User applies choice to try and unlock door
* @param option the user chose
* @return String representing how user choice affected door.
**/
  @Override
  public String unlock(int option) {
    this.guess = option;
    return "You turn the dial.";
  }
/* open - checks if doors is open
 * @return boolean that is true if door is open
**/
  @Override
  public boolean open() {
    if (this.guess == comboValue) {
      return true;
    }
    return false;
  }
/* clue - gives a clue about how to open door.
 * @return String representing the clue.
**/ 
  @Override
  public String clue(){
    if (this.guess > comboValue) return "Too high.";
    if (this.guess < comboValue) return "Too low.";
    return "Just right.";
  }
/* success - Gives a message that the door is open
 * @return String representing message of door being opened.
**/
  @Override
  public String success(){
    return "You have succesfully opened the door!!!";
  }
}