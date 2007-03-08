package gui2;

import java.awt.event.*;
import javax.swing.*;

public class Main {
    private JFrame jf;
    private myWinderListener mwl;
    
    public Main() {
        jf = new JFrame("My Window, II");
        
        jf.setSize(400,200);
        jf.setLocation(0,0);
        // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mwl = new myWinderListener();
        jf.addWindowListener(mwl);
        
        jf.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }

    private class myWinderListener implements WindowListener {
        public void windowOpened(WindowEvent e) {
            System.out.println("wo");
        }

        public void windowIconified(WindowEvent e) {
            System.out.println("wi");
        }

        public void windowDeiconified(WindowEvent e) {
            System.out.println("wd");
        }

        public void windowDeactivated(WindowEvent e) {
            System.out.println("wda");
        }

        public void windowClosing(WindowEvent e) {
            System.out.println("wc");
            System.exit(0);
        }

        public void windowClosed(WindowEvent e) {
            System.out.println("wcld");
        }

        public void windowActivated(WindowEvent e) {
            System.out.println("wa");
        }
        
    }
    
    
}



















