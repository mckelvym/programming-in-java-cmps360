/*
 * Data.java
 *
 * Created on November 29, 2006, 8:18 AM
 *
 * Example of mutual exclusion by synchronization
 */

package ex02;

/**
 *
 * @author fdd5501
 */
public class Data implements Cloneable {
    int producer;
    double data;
    
    public Data() {
        producer = -1;
        data = 0;
    }
}
