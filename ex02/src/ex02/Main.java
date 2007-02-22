/*
 * Main.java
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
public class Main implements Limits {
    
    public static void main(String[] args) {
        ChubbyHole ch = new ChubbyHole();
        Producer p = new Producer(ch, 1);
        Consumer c[] = new Consumer[Limits.NUM_CONSUMERS];

        for (int i=0; i<Limits.NUM_CONSUMERS; i++){
            c[i] = new Consumer(ch,i+1);
        }
        
        p.start();
        for (int i=0; i<Limits.NUM_CONSUMERS; i++){
            c[i].start();
        }    
    }
    
}
