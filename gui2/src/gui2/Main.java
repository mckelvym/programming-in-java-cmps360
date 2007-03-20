/*
 * Main.java
 *
 * Created on March 20, 2007, 10:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui2;

/**
 *
 * @author mark
 */
public class Main {
    
    private ValueClass vc;
    
    /** Creates a new instance of Main */
    public Main() {
        new JFrameClass();
        
        vc = new ValueClass();
        new JFrameClass(vc).setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
