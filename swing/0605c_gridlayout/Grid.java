import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid extends JFrame {
    
    MyWindowListener mwl;
    
    public Grid() {
        mwl = new MyWindowListener();
        addWindowListener(mwl);
        setSize(400, 600);
        setLocation(300, 10);

        Container c = getContentPane();
        c.setBackground(Color.white);
       
        c.setLayout(new GridLayout(3,2));
        
        JLabel redPic = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605c_gridlayout/red.gif"));
        JLabel greenPic = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605c_gridlayout/green.gif"));
        JLabel yellowPic = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605c_gridlayout/yellow.gif"));
        JLabel redText = new JLabel("Stop if you feel like it.");
        JLabel greenText = new JLabel("Go!");
        JLabel yellowText = new JLabel("Go faster!");
        
        c.add(redPic);
        c.add(redText);
        c.add(greenPic);
        c.add(greenText);
        c.add(yellowPic);
        c.add(yellowText);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        Grid demo = new Grid();
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

