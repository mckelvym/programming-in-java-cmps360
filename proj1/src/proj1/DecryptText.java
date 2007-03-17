/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * This class has two modes, interactive and non-interactive. Both modes
 * allow an encrypted text string to be passed and using a keyed deck file and
 * a keystream generator, help you to get a plaintext string.
*/

package proj1;

import javax.swing.*;

/**
 * This class has two modes, interactive and non-interactive. Both modes
 * allow an encrypted text string to be passed and using a keyed deck file and
 * a keystream generator, help you to get a plaintext string.
 * @author Mark
 */
public class DecryptText extends CharacterConversion{
    
    /**
     *A keystream generator for this class.
     */
    private GenerateSolitaireKeystream gsk;
    
    /**
     *Begins the interactive mode.
     */
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "You will now be prompted for a string to decrypt.");
        String string = JOptionPane.showInputDialog(null, "Please input the string to decrypt.");
        String path = JOptionPane.showInputDialog(null, "Please input the path to a keyed deck.");
        JOptionPane.showMessageDialog(null, "Decrypted message is: " + (new DecryptText(path).decryptText(string)));
    }
    /** Creates a new instance of DecryptText */
    public DecryptText(String path_to_keyed_deck){
        gsk = new GenerateSolitaireKeystream(path_to_keyed_deck);
    }

    /*
     *Takes a string in encrypted text and using a defined keystream generator 
     * returns a plaintext string.
     */
    public String decryptText(String encText){
        
        String plainText="";
        
        int encText_length=encText.length();
        String keystream="";
        for(int i = 0; i < encText_length; i++){
            keystream += gsk.getKeystreamValue();
        }
        
        // --- STEP 3,4,5,6 ---
        int enc_val;
        int keystream_val;
        int plain_val;
        for(int i = 0; i < encText_length; i++){
            enc_val = convertCharToEquivalentInt(encText.substring(i,i+1));
            keystream_val = convertCharToEquivalentInt(keystream.substring(i,i+1));
            plain_val = ((enc_val - keystream_val) % 26);
            if(plain_val <= 0) plain_val += 26;
            plainText += convertIntToEquivalentChar(plain_val);
        }       
        
        return plainText;
    }     
}
