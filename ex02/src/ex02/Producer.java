/*
 * Producer.java
 *
 * Created on November 29, 2006, 8:33 AM
 *
  * Example of mutual exclusion by synchronization
*/

package ex02;

/**
 *
 * @author fdd5501
 */
public class Producer extends Thread implements Limits{
    private ChubbyHole ch;
    private Data d;
    
    /** Creates a new instance of Producer */
    public Producer(ChubbyHole ch, int pid) {
        this.ch = ch;
        d = new Data();
        d.producer = pid;
    }
    
    public void run() {
        super.run();
        for (int i=0; i<Limits.PRODUCER_LIMIT; i++) {
            d.data = i * i * Math.PI;

            System.out.println("putting data - producer: " + d.producer +
                               "\tdata: " + d.data);
            ch.put(d);
        
            try {
                sleep((int)(Math.random() * 1000));  // simulate time for data
                                                     // creation
                                                     // option for try/sleep
                                                     // is yield();               
            }
            catch (InterruptedException e) {}
        }
    }
}
