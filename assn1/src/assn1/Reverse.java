/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn1
 * Date Assigned:   Monday, 22 January 2007, 10:00 AM
 * Due Date:        Thursday, 1 February 2007, 10:00 PM
 * Description:     Prompts the user for an input string and reverves it, 
                    showing the user the reverse via a dialog box.
 */

package assn1;

import javax.swing.*;

/**
 * Prompts the user for an input string and reverves it, showing the user the
 * reverse via a dialog box.
 * @author Mark
 */
public class Reverse {
    
    public static void main(String args[]){
        new Reverse();
    }
    
    /**
     * Prompts the user for an input string, reverses it, and displays it back 
     * to the user via a dialog box. 
     */
    public Reverse(){
        String original = prompt();
        String reverse = reverse(original);
        display("The reverse of \"" + original + "\" is \"" + reverse + "\"");
    }
    
    /**
     * Reverses a string.
     * @param original The original string to be reversed.
     * @return The result of reversing the original string.
     */
    private String reverse(String original){
        String tmp[] = original.split(" ");
        String reverse = "";
        for(int i = (tmp.length - 1); i >= 0; i--){
            reverse += tmp[i];
            if(i != 0)
                reverse += " ";
        }
        return reverse;
    }
    
    /**
     * Prompts the user for a sentence.
     * @return The users input.
     */
    private String prompt(){
        return JOptionPane.showInputDialog("Please input a sentence to be reversed:");
    }
    
    /**
     * Displays a message to the user via a dialog box.
     * @param msg The string to be displayed.
     */
    private void display(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
