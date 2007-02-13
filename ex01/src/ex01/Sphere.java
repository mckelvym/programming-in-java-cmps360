/*
 * Sphere.java
 *
 * Created on February 13, 2007, 10:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ex01;

/**
 *
 * @author Mark
 */
public class Sphere implements Shape{
    
    private double radius;
    
    /** Creates a new instance of Sphere */
    public Sphere() {
        radius = 0;
    }
    
    /**
     *Blah parameterized constructor.
     */
    public Sphere(double radius){
        this.radius = radius;
    }

    /**
     *Get the volume of this sphere
     */
    public double Volume() {
        return (4.0/3.0)*PI*Math.pow(radius, 3.0);
    }    
}
