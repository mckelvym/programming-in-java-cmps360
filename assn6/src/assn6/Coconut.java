/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * Simulates a coconuts that falls from a certain tree and is given a certain
 * numerical name.
*/

package assn6;

/**
 * Simulates a coconuts that falls from a certain tree and is given a certain
 * numerical name.
 * @author Mark
 */
public class Coconut implements Cloneable{
    
    /**
     *Tree from which this coconut came.
     */
    private int tree;
    
    /**
     *Name given to this coconut.
     */
    private double name;
    
    /**
     * Creates a new instance of Coconut
     * with tree set to -1 and name set to 0.
     */
    public Coconut() {
        tree = -1;
        name = 0;
    }
    
    /**
     * Creates a new instance of Coconut
     * with tree set to producer_id and name set to 0.
     */
    public Coconut(int producer_id){
        tree = producer_id;
        name = 0;
    }
    
    /**
     *Set tree from which this came.
     */
    public void setTree(int p){
        tree = p;
    }
    
    /**
     *Get tree from which this came.
     */
    public int getTree(){
        return tree;
    }
    
    /**
     *Set name of coconut.
     */
    public void setName(double d){
        name = d;
    }
    
    /**
     *Get name of coconut.
     */
    public double getName(){
        return name;
    }
    
}
