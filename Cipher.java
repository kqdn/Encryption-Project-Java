/**
 *  Class that encodes and decodes individual characters using the "Caesar cipher".
 *    @author Dave Reed
 */
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
	public char encode(char ch) {
	    int index = Cipher.ALPHABET.indexOf(ch);
	    return Cipher.SHIFTED.charAt(index);
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
