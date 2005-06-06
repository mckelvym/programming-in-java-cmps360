import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OldGraphics4 extends JFrame {

    MyWindowListener mwl;
    Container c;
    MyPanel4 mp;
    Thread go;
    
    public OldGraphics4() {
        mwl = new MyWindowListener();
        setSize(300, 100);
        setLocation(300, 200);
        addWindowListener(mwl);        
        
        c = getContentPane();
        c.setBackground(new Color(100,150,200));
        c.setLayout(new FlowLayout());        
        
        mp = new MyPanel4();
        c.add(mp);
        mp.start();
    }
    

    public static void main(String[] args) {
        OldGraphics4 demo = new OldGraphics4();
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
