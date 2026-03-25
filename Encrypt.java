import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *  Class for encoding entire files.
 *    @author Dave Reed
 */
public class Encrypt {
	/**
	 * Encodes an entire file using a Cipher object.
	 */
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.println("Do you want to encode or decode? (e/d) ");
	    char response = input.next().toLowerCase().charAt(0);	    
	    System.out.println("Input file: ");
	    String infile = input.next();
	    System.out.println("Output file: ");
	    String outfile = input.next();
		String subCipher = "";
		System.out.println("""
                                    Enter the substitution key you want to use: (must be 26 charaacters long)
                                    Or you can enter "caesar" to use a caesar shift of 3.""");
		while(subCipher.length() != 26) {
			subCipher = input.next();
			if(subCipher.equalsIgnoreCase("caesar")) break; 
			if(subCipher.length()!=26) System.out.println("Key must be 26 characters long.");
			//breaks loop if caesar is entered
		} //prompts the user to enter a substitution cipher instead of the caesar shift
		//it repeats the prompt if the user enters invalid length
	    
	    Cipher coder = new Cipher(subCipher);
	    try {
	        FileReader inReader = new FileReader(infile);
	        PrintStream outWriter = new PrintStream(outfile);
	        while (inReader.ready()) {
	            char ch = (char)inReader.read();
	            if (response == 'e') {
	                outWriter.print( coder.encode(ch) );
	            }
	            else if (response == 'd') {
	                outWriter.print( coder.decode(ch) );
	            }
	        }
	        inReader.close();
	        outWriter.close();
	    }
	    catch (java.io.IOException e) {
	        System.out.println("FILE NOT FOUND");
	    }  
	}
}
