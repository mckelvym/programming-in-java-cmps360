/*
 * Shape.java
 *
 * Created on February 13, 2007, 9:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ex01;

/**
 *
 * @author Mark
 */
public interface Shape {
    /**
     *Typdef for PI
     */
    public final double PI = Math.PI;
    
    /**
     * Force an implementing class to create a method called Volume.
     * 
     * @return Returns the area of the shape.
     */
    public double Volume();
}
