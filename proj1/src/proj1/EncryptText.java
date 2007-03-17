/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * This class has two modes, interactive and non-interactive. Both modes
 * allow a plaintext string to be passed and using a keyed deck file and
 * a keystream generator, help you to get an encrypted string.
 */

package proj1;

import javax.swing.*;

/**
 * This class has two modes, interactive and non-interactive. Both modes
 * allow a plaintext string to be passed and using a keyed deck file and
 * a keystream generator, help you to get an encrypted string.
 * @author Mark
 */
public class EncryptText extends CharacterConversion{
    
    /**
     *A regular expression used for split
     */
    private String split_regex=" ";
    
    /**
     *A keystream generator
     */
    private GenerateSolitaireKeystream gsk;
    
    /**
     *Begins the interactive mode
     */
    public static void main(String args[]){
        JOptionPane.showMessageDialog(null, "You will now be prompted for a string to encrypt.");
        String string = JOptionPane.showInputDialog(null, "Please input the string to encrypt.");
        String path = JOptionPane.showInputDialog(null, "Please input the path to a keyed deck.");
        JOptionPane.showMessageDialog(null, "Encrypted message is: " + (new EncryptText(path).encryptText(string)));
    }
    
    /** Creates a new instance of EncryptText */
    public EncryptText(String path_to_keyed_deck){
        gsk = new GenerateSolitaireKeystream(path_to_keyed_deck);
    }
    
    /**
     *Takes a string in plainText and using a defined keystream generator returns
     *an encrypted string.
     */
    public String encryptText(String plainText){
        
        // --- STEP 1 ---
        String[] array = plainText.toUpperCase().split(split_regex);
        plainText="";
        
        for(int i = 0; i < array.length; i++){
            plainText += array[i];
        }
        
        // --- STEP 2 ---
        int plainText_length=plainText.length();
        String keystream="";
        for(int i = 0; i < plainText_length; i++){
            keystream += gsk.getKeystreamValue();
        }
        
        // --- STEP 3,4,5,6 ---
        int plain_val;
        int keystream_val;
        int enc_val;
        String encText="";
        for(int i = 0; i < plainText_length; i++){
            plain_val = convertCharToEquivalentInt(plainText.substring(i,i+1));
            keystream_val = convertCharToEquivalentInt(keystream.substring(i,i+1));
            enc_val = ((plain_val + keystream_val) % 26);
            if(enc_val <= 0) enc_val += 26;
            encText += convertIntToEquivalentChar(enc_val);
        }       
        
        return encText;
    }    
}
