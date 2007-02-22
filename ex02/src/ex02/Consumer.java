/*
 * Consumer.java
 *
 * Created on November 29, 2006, 8:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ex02;

/**
 *
 * @author fdd5501
 */
public class Consumer extends Thread implements Limits {
    private ChubbyHole ch;
    private int consumerID;
    private Data d;
    
    /** Creates a new instance of Consumer */
    public Consumer(ChubbyHole ch, int cid) {
        this.ch = ch;
        consumerID = cid;
    }

    public void run() {
        super.run();
        for (int i=0; i<Limits.CONSUMER_LIMIT/Limits.NUM_CONSUMERS; i++) {
            d = ch.get(consumerID); 
            
            System.out.println("got data - consumer: " + consumerID +
                               "\tproducer: " + d.producer +
                               "\tdata: " + d.data);
            try {
                sleep((int)(Math.random() * 100));  // simulate time for data
                                                     // usage
                                                     // option for try/sleep
                                                     // is yield();               
            }
            catch (InterruptedException e) {}
        }
    }
    
    
    
}
