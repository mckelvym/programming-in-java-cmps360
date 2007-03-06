/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * This is an interface for limits in the cubbyhole example.
*/

package assn6;

/**
 * This is an interface for limits in the cubbyhole example.
 * @author Mark
 */
public interface Limits {
    /**
     *Limit for number of coconuts to stuff in the cubbyhole
     */
    public final int PRODUCER_LIMIT=100;
    
    /**
     *Number of monkeys to take from the cubbyhole (consumers)
     */
    public final int NUM_MONKEYS=3;
    
    /**
     *Limit for number of coconuts to take from the cubbyhole
     */
    public final int MONKEY_EATING_LIMIT=100;
}
