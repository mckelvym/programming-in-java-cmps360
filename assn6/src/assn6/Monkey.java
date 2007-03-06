/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * This simulates a monkey that catches and eats a coconut using a cubbyhole.
*/

package assn6;

/**
 * This simulates a monkey that catches and eats a coconut using a cubbyhole.
 * @author Mark
 */
public class Monkey extends Thread implements Limits{
    
    /**
     * Cubbyhole to eat coconuts from
     */
    private Cubby cubbyhole;
    
    /**
     *A "name" for this monkey
     */
    private int monkey_id;
    
    /**
     *A representation of a coconut
     */
    private Coconut coconut;
    
    /**
     *Time in milliseconds that the monkey takes to eat a coconut
     */
    private final int EAT_TIME = 500;
    
    /** Creates a new instance of Monkey that has access to a specific cubby hole
     * is given the "name" of monkey_id
     */
    public Monkey(Cubby cubbyhole, int monkey_id) {
        this.cubbyhole = cubbyhole;
        this.monkey_id = monkey_id;
    }

    /**
     *Starts this monkey to check the cubbyhole for coconuts.
     */
    public void run() {
        super.run();
        for (int i = 0; i < (Limits.MONKEY_EATING_LIMIT/Limits.NUM_MONKEYS); i++){
            // grab from cubbyhole
            coconut = cubbyhole.eat(monkey_id);
            
            // signify monkey got the coconut
            //System.out.println("Monkey " + monkey_id + " eating coconut " + coconut.getName() + " from tree " + coconut.getTree());
            
            // start eating
            try {
                sleep(EAT_TIME);              
            }
            catch (InterruptedException e) {}
            
            // signify monkey is done eating
            System.out.println("Monkey " + monkey_id + " finished coconut " + coconut.getName() + 
                           " from tree " + coconut.getTree());
        }
    }
    
}
