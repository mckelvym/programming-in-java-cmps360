import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OldGraphics extends JFrame {

    MyWindowListener mwl;
    Container c;
    
    public OldGraphics() {
        mwl = new MyWindowListener();
        setSize(200, 75);
        setLocation(300, 200);
        addWindowListener(mwl);        
        
        c = getContentPane();
        c.setBackground(new Color(100,150,200));
        c.setLayout(new FlowLayout());        
        
        JLabel jl = new JLabel("Go!");
        jl.setFont(new Font("SansSerif", Font.BOLD, 24));
        jl.setForeground(new Color(250,250,100));
        JButton jb = new JButton("Click!");
        
        c.add(jl);
        c.add(jb);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        OldGraphics demo = new OldGraphics();
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
