import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OldGraphics3 extends JFrame {

    MyWindowListener mwl;
    Container c;
    MyPanel mp1, mp2, mp3, mp4;
    
    public OldGraphics3() {
        mwl = new MyWindowListener();
        setSize(300, 200);
        setLocation(300, 200);
        addWindowListener(mwl);        
        
        c = getContentPane();
        c.setBackground(new Color(100,150,200));
        c.setLayout(new FlowLayout());        
        
        mp1 = new MyPanel();
        mp2 = new MyPanel();
        mp3 = new MyPanel();
        mp4 = new MyPanel();

        c.add(mp1);
        c.add(mp2);
        c.add(mp3);
        c.add(mp4);
    }

    
    public static void main(String[] args) {
        OldGraphics3 demo = new OldGraphics3();
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
