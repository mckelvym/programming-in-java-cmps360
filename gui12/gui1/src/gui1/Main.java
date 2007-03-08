/*
 * Main.java
 *
 * Created on March 8, 2007, 10:01 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui1;

import javax.swing.*;
import java.awt.Event.*;

public class Main extends JFrame {
    
    public Main() {
        super("My Window");
        setSize(300, 200);
        setLocation(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}







