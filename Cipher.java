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
    private static String SHIFTED;

    /**
     *  Constructs a Cipher object.
     */

    public Cipher(String subCipher) {
        SHIFTED = subCipher;
        if(SHIFTED.equalsIgnoreCase("caesar"));
            SHIFTED = "defghijklmnopqrstuvwxyzabc";
    }

    /**
     * Encodes a single character.
     *   @param ch the character to be encoded
     *   @return the character three later in the alphabet, with wrap-around
     */

    // Part 3: Modify your Cipher class so that it performs a rotation after each character
    //  is encoded/decoded. You should define a private method named rotate that rotates 
    // the key field. Then, this method should be called by both
    // encode and decode after a character has been processed.
	public char encode(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            //lowercase
            int index = Cipher.ALPHABET.indexOf(ch);
            return Cipher.SHIFTED.charAt(index);
        } else if (ch >= 'A' && ch <= 'Z') {
            ch = Character.toLowerCase(ch); //convert to lower so i can use the given shift method
            int index = Cipher.ALPHABET.indexOf(ch);
            return Character.toUpperCase(Cipher.SHIFTED.charAt(index));
            //have to return the uppercase version of whats shifted
        } else {
        //not a letter
        return ch;
        }
    }
	
    /**
     * Decodes a single character.
     *   @param ch the character to be decoded
     *   @return the character three earlier in the alphabet, with wrap-around
     */
    public char decode(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            //lowercase
            int index = Cipher.SHIFTED.indexOf(ch);
            return Cipher.ALPHABET.charAt(index);
        } else if (ch >= 'A' && ch <= 'Z') {
            ch = Character.toLowerCase(ch); //convert to lower so i can use the given shift method
            int index = Cipher.SHIFTED.indexOf(ch);
            return Character.toUpperCase(Cipher.ALPHABET.charAt(index));
            //have to return the uppercase version of whats shifted
        } else {
        //not a letter
        return ch;
        }
        //just copied my encode implementation but swapped shifted and alphabet
	}
}
