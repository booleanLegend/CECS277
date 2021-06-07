// Door - Interface for objects of type Door
// mimics a door with varying unlock types.
public interface Door{
/* Door - Creates a Door object.
**/
  public String examine();
/* menu - Gives options related to current door.
 * @return String representing menu of options.
**/ 
  public String menu();
/* unlock - User applies choice to try and unlock door
* @return String representing how user choice affected door.
**/
  public String unlock(int option);
/* open - checks if doors is open
 * @param option the user chose
 * @return boolean that is true if door is open
**/
  public boolean open();
/* clue - gives a clue about how to open door.
 * @return String representing the clue.
**/ 
  public String clue();
/* success - Gives a message that the door is open
* @return String representing message of door being opened.
**/
  public String success();
}