/**
 *  Class that encodes and decodes individual characters using the "Caesar cipher".
 *    @author Dave Reed
 */
// The Cipher class contains a partial implementation of the Caesar cipher. The encode and decode methods can
// be used to encode and decode lower-case letters by shifting them three positions in the alphabet. Modify
// these methods so that they handle upper-case letters and non-letters as well. An upper-case letter should be
// encoded/decoded just like its lower-case equivalent, producing the corresponding upper-case letter. For
// example, 'A' should be encoded as 'D'. Characters that are not letters should be left as is. For example, the
// encoding of a space or exclamation mark should be that same character unchanged.
// Hint: the isUpperCase and toUpperCase methods from the Character class should be of use here.
public class Cipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SHIFTED = "defghijklmnopqrstuvwxyzabc";

    /**
     *  Constructs a Cipher object.
     */
    public Cipher() {
	    // currently, does nothing
    }

    /**
     * Encodes a single character.
     *   @param ch the character to be encoded
     *   @return the character three later in the alphabet, with wrap-around
     */
    //isuppercase returns false if it is a char
	public char encode(char ch) {
        if(Character.isUpperCase(ch)) {
            int index = Cipher.ALPHABET.indexOf(Character.toLowerCase(ch)); 
            //converts it to lowercase because it is upppercase
            //then i can find the index of the character
	        return Character.toUpperCase(Cipher.SHIFTED.charAt(index));
            //uses the old shift implementation because it is lowercase
            //since the old shift changes to lowercase, i have to convert this back to uppercase
        }
        else if(Character.isLowerCase(ch)) {
            //lowercase, no change to original implementation
            int index = Cipher.ALPHABET.indexOf(ch);
	        return Cipher.SHIFTED.charAt(index);
        }
        else {
            //its not a char, don't shift
            return ch;
        }
	}
	
    /**
     * Decodes a single character.
     *   @param ch the character to be decoded
     *   @return the character three earlier in the alphabet, with wrap-around
     */
    public char decode(char ch) {
	    int index = Cipher.SHIFTED.indexOf(ch);
	    return Cipher.ALPHABET.charAt(index);
	}
}
