import java.util.Scanner;
/**
*   Cipher is a representation of a inverted alphabet letters
*/
public class Cipher {
  /**
  *   Array of Alphabet letters
  */
	protected char[] alphabet;

  /** Default Constructor for Cipher which creates a array of Capitalized Characters
  */
	public Cipher() {
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();   
	}

	/** Encrypt function loops through each character and returns a new encrypted message
  *   @param msg      Is used as the inputted String while returning the new characters 
  *   @return         Encrypted String
  */
	public String encrypt(String msg) {
		// While you loop through the message, you will call encyrpt letter
		// encryptLetter does all the work
    msg = msg.toUpperCase();
    String msgEncrypted = ""; 

    for (int i = 0; i < msg.length(); i++){ 
      msgEncrypted += encryptLetter(msg.charAt(i));
    }
    return msgEncrypted;
	}
	/** decrypt function loops through each character while inverting the string back to its original
  *   @param msg      Is used as the inputted String while returning the updated character values 
  *   @return         The Decrypted String to its original
  */
	public String decrypt(String msg) {
		String msgDecrypted = ""; 
		msg = msg.toUpperCase();
		for (int i = 0; i < msg.length(); i++){
			msgDecrypted += decryptLetter(msg.charAt(i));
		}
		return msgDecrypted;
	}
  /** encryptLetter function loops through each character while inverting the String by each character
  *   @param c        Is used as the current character for testing the current location
  *   @param invert   Is an array used to form a new array from the original alphabet to new location value
  *   @return         New encrypted character value
  */
	protected char encryptLetter(char c) {
    char[] invert = new char[26];
    int location = 0;
    if (Character.isAlphabetic((int)c)){
      for (int i = 0; i < this.alphabet.length; ++i){
        invert[i] = this.alphabet[alphabet.length - (i + 1)];
        if (this.alphabet[i] == c){
          location = i;
        }
      }
      return invert[location];
    }
    return c;
	}
	/** encryptLetter function loops through each character while inverting the String by each character
  *   @param c      Is used as the current character for testing the current location
  *   @param        Invert is an array used to form a new array from the original alphabet to new location value
  *   @return       New decrypted character value
  */
	protected char decryptLetter(char c) {
		int location = 0;
		char decryptedLetter = ' ';
    if (Character.isAlphabetic((int)c)){
      for (int i = 0; i < alphabet.length; i++) {
        if (alphabet[i] == c) {
          location = i;
        }
      }
      decryptedLetter = alphabet[alphabet.length - location - 1];
      return decryptedLetter;
    }
  return c;
	}
}