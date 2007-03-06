/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn5
 * Date Assigned:   Thursday, 15 February 2007, 09:20 AM
 * Due date:        Monday, 26 February 2007, 10:00 PM
 * Description:
 * This initializes a "cubbyhole", creates a coconut tree that drops coconuts, and
 * a set of monkeys that eats coconuts, and starts the process up that the tree
 * starts dropping coconuts and the monkeys start catching and eating coconuts.
*/

package assn6;

/**
 * This initializes a "cubbyhole", creates a coconut tree that drops coconuts, and
 * a set of monkeys that eats coconuts, and starts the process up that the tree
 * starts dropping coconuts and the monkeys start catching and eating coconuts.
 * @author Mark
 */
public class Main implements Limits{
    
    /**
     * This initializes a "cubbyhole", creates a coconut tree that drops coconuts, and
     * a set of monkeys that eats coconuts, and starts the process up that the tree
     * starts dropping coconuts and the monkeys start catching and eating coconuts.
     */
    public static void main(String[] args) {
        Cubby cubbyhole = new Cubby();
        CoconutTree tree = new CoconutTree(cubbyhole, 1);
        Monkey monkeyarray[] = new Monkey[Limits.NUM_MONKEYS];

        tree.start();
        for (int i = 0; i < Limits.NUM_MONKEYS; i++){
            monkeyarray[i] = new Monkey(cubbyhole, i+1);
            monkeyarray[i].start();
        }
    }
}
