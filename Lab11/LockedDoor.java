import java.util.Random;
/** LockedDoor Class
*/
public class LockedDoor implements Door {
	private int keyLocation;
	private int keyChoice;

/** LockedDoor constructor assigns a random number to keyLocation for the user to solve
*/
	public LockedDoor() {
		Random rn = new Random();
		keyLocation = rn.nextInt(3) + 1;
	}

/** Method will display examine message to user
* @return string message of examine 
*/		

    @Override
  public String examine(){
		return "A door that can be opened with a key. Look around to see if you can find it.";
  }

/** Method will display menu message to user
* @return string message of menu
*/	
  @Override
  public String menu(){
		return "1. Look Under Cat\n2. Look Under Flask\n3. Look Under Keyboard";
  }

/** Method will display unlock message to user and pass the keyLocation to the correct option 
* @param option the user chose
* @return string message based of different options the user chooses
*/		
  @Override
  public String unlock(int option){
		if (option == 1) {
			if(option == keyLocation) {
				keyChoice = option;
				return "You've found the key!";
			}
			else {
				return "You see nothing under the cat...";
			}
    }
		else if (option == 2) {
			if(option == keyLocation) {
				keyChoice = option;
				return "You've found the key!";
			}
			else {
				return "You see nothing under the flask...";
			}
		}
		else if (option == 3) {
			if(option == keyLocation) {
				keyChoice = option;
				return "You've found the key!";
			}
			else {
				return "You see nothing under the keyboard...";
			}	

			
  	}
			return "Invalid option!";
	}

/** Method return true or false based on whether the door is open 
* @return true or false if door is opened 
*/	
  @Override
  public boolean open(){
		if(keyChoice == keyLocation) {
			return true;
		}
		else {
			return false; 
		}
  }

/** Method will give the user a clue when their choice is incorrect 
* @return string message of clue 
*/	
  @Override
  public String clue(){
		return "Try another choice!";
  }

/** Method will give the user a message if they are successful in opening door 
* @return string message of success
*/	
  @Override
  public String success(){
		return "Congratulations, you opened a door!";
  }
}