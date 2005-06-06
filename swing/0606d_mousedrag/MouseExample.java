import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseExample extends JFrame {
    
    private MyMouseDraw mmd;
    private MyWindowListener mwl;
    private Container c;
    
    public MouseExample() {
        mwl = new MyWindowListener();
        setSize(300, 300);
        setLocation(300, 200); 
        addWindowListener(mwl);        
        
        c = getContentPane();
        c.setLayout(new BorderLayout()); 
        
        mmd = new MyMouseDraw(300,300);
        c.add(mmd,BorderLayout.CENTER);
        
        mmd.start();
    }
    
    public static void main(String[] args) {
        MouseExample demo = new MouseExample();
        demo.show();
    }

    public class MyWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {System.exit(0);}
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
    }
    
}
