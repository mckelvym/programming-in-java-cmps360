import javax.swing.*;
import java.awt.event.*;

public class FirstEvent {
    
    private JFrame jf;

    public FirstEvent(String label, int x, int y) {
        jf = new JFrame(label);
        jf.setSize(300,200);
        jf.setLocation(x,y);
        jf.setVisible(true);
        
        myWindowListener mwl = new myWindowListener();
        jf.addWindowListener(mwl);
    }
    
    public static void main(String[] args) {
        FirstEvent demo1 = new FirstEvent("One",300,200);
        FirstEvent demo2 = new FirstEvent("Two",50,300);
        FirstEvent demo3 = new FirstEvent("Three",600,100);
    }
    
    private class myWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {System.exit(0);}
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
    }
    
}
