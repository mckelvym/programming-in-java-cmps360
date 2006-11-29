/*
 * Main.java
 *
 * Created on November 29, 2006, 1:30 PM
 *
 * generics the useless way
 */

package a1;

/**
 *
 * @author fdd5501
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
        DataThingie dt1 = new DataThingie();
        DataThingie dt2;
        
        dt1.i = 1;
        dt1.d = 2.3;
                
        GenericClass<DataThingie> gcdt = new GenericClass<DataThingie>(dt1);

        dt2 = gcdt.get();
        
        System.out.println(dt2.i);
        System.out.println(dt2.d);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}
