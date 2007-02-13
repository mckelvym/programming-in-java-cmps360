/*
 * Main.java
 *
 * Created on February 13, 2007, 9:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ex01;

/**
 * Class example 01. 
 * This class contains commented out code for Comparable and Comparator.
 * @author Mark
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
        Box b = new Box(2,2,2);
        Sphere s = new Sphere(1);
        
        System.out.println("Volume of the box: " + b.Volume());
        System.out.println("Voluem of the sphere: " + s.Volume());
        
        showArea(b);
        showArea(s);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }
    
    /**
     *Example of how to use interfaces.
     */
    public void showArea(Shape s){
        System.out.println("Volume of the object is: " + s.Volume());
    }
}

/*
// throws ClassCastException if element does not implement Comparable
public interface Comparable <T> {
    public int compareTo(T t);
}
*/

/*
public interface Comparator <T> {
    int compare(T t1, T t2);
    boolean equals(Object o);
}
*/
