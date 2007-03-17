/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      proj1
 * Date Assigned:   Monday, 5 March 2007, 10:05 AM
 * Due date:        Monday, 19 March 2007, 10:00 PM
 * Description:
 * Allows for common code for character conversions to be used in child classes.
 */

package proj1;

/**
 * Allows for common code for character conversions to be used in child classes.
 * @author Mark
 */
public abstract class CharacterConversion {
    
    /**
     *Converts an upper case letter to its corresponding numerical sequence value.
     *For example, "A" becomes "1" and "B" becomes "2", etc..
     */
    public int convertCharToEquivalentInt(String onechar){
        char array[] = onechar.toCharArray();
        return (int)array[0] - 64;
    }
    
    /**
     *Converts a number to its corresponding alphabetical uppercase sequence value.
     *For example, "1" becomes "A" and "2" becomes "B", etc..
     */
    public String convertIntToEquivalentChar(int oneint){
        return String.valueOf((char)(oneint + 64));
    }

}
