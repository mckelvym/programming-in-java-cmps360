import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dump extends JFrame {
    
    MyWindowListener mwl;
    
    public Dump() {
        mwl = new MyWindowListener();
        addWindowListener(mwl);
        setSize(200,150);
        setLocation(300, 300);

        Container c = getContentPane();
        c.setBackground(Color.white);
       
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        
        JLabel usPic = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605f_screendump/us.jpeg"));

        c.add(new JButton("First"));
        c.add(usPic);
        c.add(new JButton("Last"));

        setVisible(true);
        
        ScreenDump();
    }
    
    public static void main(String[] args) {
        Dump demo = new Dump();
    }
    
    
    public void ScreenDump() {
        Toolkit t = getToolkit();
        PrintJob pj = t.getPrintJob(this, "Example Screen Dump", null);
        Graphics pg = pj.getGraphics();
        printAll(pg);
        pg.dispose();
        pj.end();
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

