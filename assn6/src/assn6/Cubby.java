/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * Represents a cubbyhole where coconuts are dropped and monkeys catch them
 * and eat them. If more than one is dropped at the same time and not caught
 * by a monkey, it is lights out man.
*/

package assn6;

/**
 * Represents a cubbyhole where coconuts are dropped and monkeys catch them
 * and eat them. If more than one is dropped at the same time and not caught
 * by a monkey, it is lights out man.
 * @author Mark
 */
public class Cubby {
    
    /**
     *A representation of a coconut to be stuffed in the cubby
     */
    private Coconut coconut;
    
    /**
     *Signifies if a coconut is available in the cubby hole.
     */
    private boolean available;
    
    private int count;
    /** Creates a new instance of Cubby with available equal to false. */
    public Cubby() {
        coconut = new Coconut();
        available = false;
        count=0;
    }
    
    /**
     *Represents the process of dropping a coconut from a tree.
     */
    public synchronized void drop(Coconut input){
       
        count++;
        while (available == true) {  // while data already in place, wait
            if(count >= 2){
               System.out.println("Tree " + input.getTree() + " dropped coconut " + input.getName()); 
               System.out.println("Light out for the stupid monkeys!");
               System.exit(0);
            } 
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }  
               
        coconut.setTree(input.getTree());
        coconut.setName(input.getName());
        System.out.println("Tree " + coconut.getTree() + " dropped coconut " + coconut.getName());        
           
        available = true;
        notifyAll();
    }
    
    /**
     *Represents the process of eating a coconut when a monkey snatches it from
     *the cubbyhole
     */
    public synchronized Coconut eat(int monkey_id){
        while (available == false) { // while no data available, wait
            try {
                wait();   
            }    
            catch (InterruptedException e) {}
        }
        
        count--;
        System.out.println("Monkey " + monkey_id + " caught coconut " + coconut.getName() + 
                           " from tree " + coconut.getTree());
        available = false;
        notifyAll();
        
        return coconut;
    }
    
}
