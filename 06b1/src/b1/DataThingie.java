/*
 * DataThingie.java
 *
 * Created on November 29, 2006, 8:18 AM
 *
 * generics with a Collections API class
 */

package b1;

/**
 *
 * @author fdd5501
 */
public class DataThingie implements Cloneable, Comparable<DataThingie> {
    private int i;
    private double d;
    
    public DataThingie(int i, double d) {
        this.i = i;
        this.d = d;
    }
    
    public int getI() {
        return i;
    }
    
    public double getD() {
        return d;
    }
    
    public int compareTo(DataThingie o) {
        if (o.i > i) return -1;
        if (o.i == i) return 0;
        return 1;
    }
    
    public String toString() {
        return "i = " + i + ", d = " + d;
    }
    
}
