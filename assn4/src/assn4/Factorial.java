/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn4
 * Date Assigned:   Sunday, 28 January 2007, 03:40 PM 	
 * Due Date:        Wednesday, 14 February 2007, 10:00 PM
 * Description:     This class prompts the user for input and calculates the 
                    factorial of the number that is entered, and displays the 
                    result back to the user. It also has exception handling.
 */

package assn4;

import javax.swing.*;

/**
 * This class prompts the user for input and calculates the factorial of the
 * number that is entered, and displays the result back to the user. It also
 * has exception handling.
 * @author Mark
 */
public class Factorial {
    
    public static void main(String args[]){
        Factorial factorialProg = new Factorial();
    }
    
    /**
     * Simple constructor, calls calculateFactorial()
     */
    public Factorial(){
        calculateFactorial();
    }
    
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
     * Prompts the user for a number to use in the factorial. Throws and catches
     * exceptions if the number <= 0
     * @return The users input, provided it is a positive integer (it may be casted).
     */
    private int prompt(){
        int tmp = -1;
        boolean continue_looping;
        /*
        do{
            tmp = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input a number for the factorial method:"));
        }while(tmp < 0);
        */
        do{
            continue_looping = false;
            try{
                tmp = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input a number for the factorial method:"));
                if(tmp <= 0){
                    throw (new Exception());
                }
            }
            catch(Exception e){
                System.out.println("Exception thrown, and caught.");
                continue_looping = true;
            }
        }while(continue_looping);      
        
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
