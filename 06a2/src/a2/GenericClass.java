/*
 * GenericClass.java
 *
 * Created on November 29, 2006, 1:31 PM
 *
 * generics the useless way
 */

package a2;

/**
 *
 * @author fdd5501
 */
public class GenericClass <type> implements GenericInterface <type> {
    public type data;
    
    /** Creates a new instance of GenericClass */
    public GenericClass(type data) {
        this.data = data;
    }
    
    public type get() {
        return data;
    }
    
    
}
