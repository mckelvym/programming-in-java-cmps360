/*
 * Main.java
 *
 * Created on March 8, 2007, 10:02 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame{
    
    public Main() {
        super("Hello World");
        this.setSize(300,100);
        this.setLocation(400,200);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLayout(new GridLayout(2,1));
        this.getContentPane().add(new JLabel("Copying music to your computer."));
        JProgressBar pb = new JProgressBar();
        pb.setIndeterminate(true);
        this.add(pb);
        
        this.addWindowListener(new WindowListener(){
            public void windowClosing(WindowEvent we){
                System.out.println("WINDOW CLOSING");
                System.exit(0);
            }
            public void windowActivated(WindowEvent we){
                System.out.println("WINDOW ACTIVATED");                
            }
            public void windowDeactivated(WindowEvent we){
                System.out.println("WINDOW DEACTIVATED");                
            }
            public void windowDeiconified(WindowEvent we){
                System.out.println("WINDOW DEICONIFIED");
            }
            public void windowIconified(WindowEvent we){
                System.out.println("WINDOW ICONIFIED");
            }
            public void windowClosed(WindowEvent we){
                System.out.println("WINDOW CLOSED");
            }
            public void windowOpened(WindowEvent we){
                System.out.println("WINDOW OPENED");
            }
        });
        
        this.setVisible(true);
                
        JFrame jframe = new JFrame("Hello World 2");
        jframe.setSize(300,100);
        jframe.setLocation(400,300);
        //jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(new JLabel("Notifying the RIAA."));
        
        jframe.setVisible(true);
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
}
