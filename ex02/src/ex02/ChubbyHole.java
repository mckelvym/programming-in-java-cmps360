/*
 * ChubbyHole.java
 *
 * Created on November 29, 2006, 8:16 AM
 *
 * Example of mutual exclusion by synchronization
 */

package ex02;

/**
 *
 * @author fdd5501
 */
public class ChubbyHole {
    private Data dt = new Data();
    private boolean available = false;
    
    public synchronized void put (Data dataIn) {
        while (available == true) {  // while data already in place, wait
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }            

        dt.producer = dataIn.producer;
        dt.data = dataIn.data;
        System.out.println("Accepting data - producer: " + dt.producer +
                               "\tdata: " + dt.data);

        available = true;
        notifyAll();

    }
    
    public synchronized Data get(int cid) {
        while (available == false) { // while no data available, wait
            try {
                wait();   
            }    
            catch (InterruptedException e) {}
        }
        
        System.out.println("returning data - consumer: " + cid + 
                           "\tproducer: " + dt.producer + 
                           "\tdata: " + dt.data);
        
        available = false;
        notifyAll();
        
        return dt;
    }
    
}
