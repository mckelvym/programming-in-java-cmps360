/*
 * Box.java
 *
 * Created on February 13, 2007, 9:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ex01;

/**
 *
 * @author Mark
 */
public class Box implements Shape{
    
    /**
     *Length of the box.
     */
    private double length;
    
    /**
     *Width of the box.
     */
    private double width;
    
    /**
     *Height of the box.
     */
    private double height;
    
    /** Creates a new instance of Box */
    public Box() {
        length = width = height = 0;
    }

    /**
     *Blah parameterized constructor.
     */
    public Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    /**
     *The area of the box.
     *@return The area.
     */
    public double Volume() {
        return length*width*height;
    }
    
}
