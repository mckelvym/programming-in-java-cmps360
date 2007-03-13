/*
 * MasterControl.java v1.0
 *
 * Created on July 18, 2004, 12:01 AM
 */

package contesttimer;

/** cubbyhole-like class designed to insure that the startup thread is complete 
 *  before proceeding with the main bookkeeping portion of the program.
 *
 * @author  Frank Ducrest
 */
public class MasterControl {
    private boolean proceed = false;
    
    /** releases paused threads */
    public synchronized void Proceed() {
        proceed = true;
        notifyAll(); 
    }
    
    /** pauses a thread until relased */
    public synchronized void Pause() {
        while (!proceed) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    } 
}
    




