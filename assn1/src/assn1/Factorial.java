/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn1
 * Date Assigned:   Monday, 22 January 2007, 10:00 AM
 * Due Date:        Thursday, 1 February 2007, 10:00 PM
 * Description:     This class prompts the user for input and calculates the 
                    factorial of the number that is entered, and displays the 
                    result back to the user.
 */

package assn1;

import javax.swing.*;

/**
 * This class prompts the user for input and calculates the factorial of the
 * number that is entered, and displays the result back to the user.
 * @author Mark
 */
public class Factorial {
    
    public static void main(String args[]){
        Factorial factorialProg = new Factorial();
    }
    
    /**
     * Simple constructor, doesn't do anything.
     */
    public Factorial(){}
    
    /**
     * Calculates the factorial of a number by prompting the user for input, 
     * doing the necessary calculations, and then displaying the result back
     * to the user in a dialog.
     */
    public void calculateFactorial(){
        int input = prompt();
        int result = factorial(input);
        display("The result of " + input + "! is " + result + ".");
    }
    
    /**
     * Prompts the user for a number to use in the factorial.
     * @return The users input, provided it is a positive integer (it may be casted).
     */
    private int prompt(){
        int tmp;
        do{
            tmp = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input a number for the factorial method:"));
        }while(tmp < 0);
        
        return tmp;
    }
    
    /**
     * Displays a message to the user using a dialog box.
     */
    private void display(Object msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
     * Calculates the factorial of a number.
     * @param f The number to use in the factorial.
     * @return The result of the factorial calculation.
     */
    private int factorial(int f){
        if(f == 0)
            return 1;
        else return f*factorial(f-1);
    }
}
