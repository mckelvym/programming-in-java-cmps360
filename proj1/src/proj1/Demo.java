/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * This is a demonstration of the keystream generator, the key generator, the
 * encrypting and decrypting of text all rolled into one.
*/

package proj1;

import javax.swing.*;

/**
 * This is a demonstration of the keystream generator, the key generator, the
 * encrypting and decrypting of text all rolled into one.
 * @author mark
 */
public class Demo {
    
    /**
     *This is the encrypting class.
     */
    public EncryptText enc;
    
    /**
     *This is the decrypting class.
     */
    public DecryptText dec;
    
    /**
     *This class will generate the keyed_deck file
     */
    public GenerateSolitaireKey gsk;
    
    /**
     *Starts the demo.
     */
    public static void main(String args[]){
        new Demo();
    }
    
    private String output = "";
    
    /** Creates a new instance of Demo */
    public Demo() {
        JOptionPane.showMessageDialog(null, "The output of the demo will be\nshown on the following dialog.");
        
        String deck_file = "keyed_deck.txt";
        String ptxt = "HELLO AGAIN WORLD";
        String etxt = "";
        
        o("Creating a keyed deck file \"" + deck_file + "\"");
        gsk = new GenerateSolitaireKey(deck_file);
        o("Encrypting the text \"" + ptxt + "\"");
        enc = new EncryptText(deck_file);
        etxt = enc.encryptText(ptxt);
        o("The encrypted text is \"" + etxt + "\"");
        o("Decrypting the text \"" + etxt + "\"");
        dec = new DecryptText(deck_file);
        ptxt = dec.decryptText(etxt);
        o("The decrypted text is \"" + ptxt + "\"");
        o("Done.");
        
        JOptionPane.showMessageDialog(null, output);
    }
    
    /**
     *Easier to output text this way.
     */
    private void o(Object o){
        output += o + "\n";
        
        //System.out.println(o);
    }
}
