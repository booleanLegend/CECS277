
/**
*   CaesarCipher is a representation of a encrypted/decrypted messages after finding corresponding letter in shifted alphabet
*/
public class CaesarCipher extends Cipher {
  /** shift represents the CeasarCipher shift amount that is to be allocated */
	private int shift;
  /**
  *   CeasarCipher initializes the shift while also calling the superclass constructor
  *   @param s    s passes the shift length.
  */ 
	public CaesarCipher(int s){
    super();
		this.shift = s;
	}
  /**
  *   encryptLetter gets the ascii value of the encrypted character after the shift then returns the character
  *   @param c    c is the character that is passed to encrypt
  *   @return     returns the new encrypted character
  */ 
  @Override
	protected char encryptLetter(char c) {
    if (Character.isAlphabetic((int)c)){
		  char encryptedChar = (char)((((int)c + this.shift - 65) % 26) + 65);
    //
      return encryptedChar;
    }
    return c;
	}
  /**
  *   encryptLetter gets the ascii value of the decrypted character after the shift then returns the character
  *   @param c    c is the character that is passed to decrypt
  *   @return     returns the new decrypted character
  */ 
  @Override
	protected char decryptLetter(char c){
    if (Character.isAlphabetic((int)c)){
		  char decryptedChar = (char)((((int)c - this.shift - 65) % 26) + 65);
    	  return decryptedChar;
    }
    return c;
	}
}