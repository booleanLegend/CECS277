/** 
 * Static functions used to check console input for validity.
 *
 * Use:	Secret Decoder ring that encrypts and decrypts messages using different types of encryption methods
 *	
 *
 *
 * @author Jacob Sunia
 * @author Matthew Zaldana
 */

import java.util.Scanner;
import java.io.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Secret Decoder Ring:\n1.Encrypt\n2.Decrypt\n");
		int s = CheckInput.getIntRange(1,2);

		// For encryption
		if (s == 1) {
			System.out.println("Enter Encryption Type:\n1.Atbash\n2.Caesar\n");
			int str = CheckInput.getIntRange(1,2);
			if (str == 1) {
				// Pass to Cipher.encypt method (Atbash cipher)
				System.out.print("Enter message: ");
				String msg = in.nextLine();
				Cipher ci = new Cipher();
				try {
					PrintWriter message = new PrintWriter("message.txt");
					message.println(ci.encrypt(msg));
          System.out.println("Encrypted message was saved to \"message.txt\".");
          System.out.println("Encrypted Message written to file: " +ci.encrypt(msg));
					message.close(); 
				} catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
			}

			else {
				// Pass to CaesarCipher.encypt method (Caesar cipher)
				System.out.print("Enter message: ");
				String msg = in.nextLine();
				System.out.print("Enter shift value: ");
				int shift = CheckInput.getIntRange(1, 25);
				CaesarCipher ci = new CaesarCipher(shift);
				try {
					PrintWriter message = new PrintWriter("message.txt");
          System.out.println("Encrypted message was saved to \"message.txt\".");
          System.out.println("Encrypted Message written to file: " +ci.encrypt(msg));
					message.println(ci.encrypt(msg));
					message.close(); 
				} catch (FileNotFoundException e) {
            		System.out.println("File Not Found");
        }
		  }		
	  }

		// For decryption
		else {
			System.out.println("Enter Decryption Type:\n1.Atbash\n2.Caesar\n");
			int str = CheckInput.getIntRange(1,2);

			if (str == 1) {
				// Pass to Cipher.decrypt method (Atbash cipher)
				String message = readFile();
				Cipher ci = new Cipher();
				System.out.println("Decrypted Message: " + ci.decrypt(message));
			}
			else {
				System.out.println("Enter shift value:");
				int shift = CheckInput.getIntRange(1, 25);
				// Pass to CaesarCipher.decrypt method (Caesar cipher)
				String message = readFile();
				CaesarCipher ci = new CaesarCipher(shift);
				System.out.println("Decrypted Message: " + ci.decrypt(message));
		  }	
   	}
  }

	public static String readFile() {
		File infile = new File("message.txt");
		try{ 
			Scanner in = new Scanner(infile);
			String message = in.nextLine();
			return message;
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		return ""; 
	}				
} 