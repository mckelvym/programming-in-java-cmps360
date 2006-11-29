/*
 * Main.java
 *
 * Created on November 29, 2006, 1:30 PM
 *
 * generics with a Collections API class
 */

package b1;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author fdd5501
 */
public class Main {
    private LinkedList<DataThingie> ll; 
    private ListIterator<DataThingie> it;
    private DataThingie dt;
            
    /** Creates a new instance of Main */
    public Main() {
        ll = new LinkedList<DataThingie>();
        String s, sa[];

        s = JOptionPane.showInputDialog("Enter int-key<space>double-value:");
        sa = s.split(" ");
        while (!s.equals("q") && sa.length == 2) {
            dt = new DataThingie(Integer.parseInt(sa[0]), 
                                 Double.parseDouble(sa[1])
                                );
            ll.add(dt);
            s = JOptionPane.showInputDialog("Enter int-key<space>double-value:");
            sa = s.split(" ");
        }
        
        ShowList();
        Collections.sort(ll);
        ShowList();
    
    }
    
    public void ShowList() {
        it = ll.listIterator();
        String message = "The list is:\n";
        for (int i=0; i<ll.size(); i++)
            message += it.next() + "\n";
        JOptionPane.showMessageDialog(null, message);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}
