
import java.util.Random;
import java.util.Arrays;

public class CodeDoor implements Door{
	char [] keys;
	char [] code;
	
	public CodeDoor() {
		code = new char[3];
		keys = new char[3];
		Random rand = new Random();
		for (int i = 0; i <3;i++){
			int randNum = rand.nextInt(3) + 1;
			if ( 1 == randNum) {
				code[i] = 'O';
			} else if (2 == randNum) {
				code[i] = 'X';
			} else {
				code[i] = 'X';
			}
		}
	}
	@Override
	public String examine() {
		return "A door with a coded keypad with three characters. Each key toggles a value with X or O";
	}
	@Override
	public String menu() {
		return "1. Press Key 1 \n2. Press Key 2\n3. Press Key 3 ";
	}
	@Override
	public String unlock(int choice) {
		if (choice < 1 || choice >3){
			try{
				throw new Exception();
			} catch (Exception e){
				return ("Array Index Out of Bounds");
			}
		}

		for ( int i = 0; i<3;i++){
			if (choice == 1) {
				keys[i] = 'O';
				System.out.println("Pressing key "+ choice + "\n" +menu());
				choice = CheckInput.getIntRange(1,3);	// Precondition for Parameter
			} else if (choice == 2) {
				keys[i] = 'X';
				System.out.println("Pressing key "+ choice + "\n" +menu());
				choice = CheckInput.getIntRange(1,3);	// Precondition for Parameter
			} else {
				keys[i] = 'X';
				System.out.println("Pressing key "+ choice + "\n" +menu());
				choice = CheckInput.getIntRange(1,3);	// Precondition for Parameter
			}	
		}
	return("Pressing key "+ choice + "\n" +examine());
	}
	@Override
	public boolean open() {
		int numRight = 0;	//Iterator for number of correct keys	
		if (Arrays.equals(code, keys)){		
			return true;
		}return false;
	}
	@Override
	public String clue(){
		int numRight = 0;
		for (int i = 0; i <=3; i++) {
			if (code[i] == keys[i]){
				numRight++;
			}
		}
		return("The number of correct keys you pressed were" + numRight);
	}
	@Override
	public String success(){
		return "You opened the Code Door!";
	}
}