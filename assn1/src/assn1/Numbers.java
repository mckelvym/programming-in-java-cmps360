/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn1
 * Date Assigned:   Monday, 22 January 2007, 10:00 AM
 * Due Date:        Thursday, 1 February 2007, 10:00 PM
 * Description:     Uses Math.random() and prints some random numbers, 10 per 
                    line for 5 lines.
 */

package assn1;

/**
 * Uses Math.random() and prints some random numbers, 10 per line for 5 lines.
 * @author Mark
 */
public class Numbers {
    
    /**
     * Multiplier for the random number.
     */
    private static double multiplier;
    
    public static void main(String args[]){
        (new Numbers(10)).printNumbers();
    }
    
    /**
     * Constructor initializes the multiplier for the random numbers.
     * @param mult A number that servers as a multiplier
     */
    public Numbers(double mult){
        multiplier = mult;
    }
    
    /**
     * Prints 10 random numbers on 5 different lines.     
     */
    public void printNumbers(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(Math.round((Math.random()*multiplier)) + " ");
            }
            System.out.println();
        }
    }    
}
