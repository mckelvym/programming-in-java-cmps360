/*
 * NewClass.java
 *
 * Created on March 20, 2007, 10:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui2;

/**
 *
 * @author mark
 */
public class ValueClass {
    private int value;
    
    /** Creates a new instance of NewClass */
    public ValueClass() {
        value=0;
    }
    
    public void up(){
        value++;
    }
    
    public int getValue(){
        return value;
    }
    
}
