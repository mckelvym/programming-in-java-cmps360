/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * Simulates a tree that drops coconuts into a cubbyhole every so often, based
 * upon a random interval
*/

package assn6;

/**
 * Simulates a tree that drops coconuts into a cubbyhole every so often, based
 * upon a random interval
 * @author Mark
 */
public class CoconutTree extends Thread implements Limits{
    
    /**
     *Cubbyhole to drop coconuts in.
     */
    private Cubby cubbyhole;
    
    /**
     *Max interval for dropping coconuts.
     */
    private final int MAX_INTERVAL = 250;
    
    /**
     *Represents a coconut to be dropped.
     */
    private Coconut coconut;
    
    /**
     * Creates a new instance of CoconutTree with specified cubby hole and tree.
     */
    public CoconutTree(Cubby cubbyhole, int tree_id) {
        this.cubbyhole = cubbyhole;
        coconut = new Coconut(tree_id);
    }
         
    /**
     *Starts up the process of tree dropping coconuts over some interval.
     */
    public void run() {
        super.run();
        for (int i = 0; i < Limits.PRODUCER_LIMIT; i++) {
            coconut.setName(i+1);

            //System.out.println("Tree " + coconut.getTree() + " dropping coconut " + coconut.getName());        
            cubbyhole.drop(coconut);
        
            try{
                sleep((int)(Math.random()*MAX_INTERVAL));                
            }
            catch(Exception e) {}
        }
    }
}