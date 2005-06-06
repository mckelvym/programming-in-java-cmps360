import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Border extends JFrame {
    
    MyWindowListener mwl;
    
    public Border() {
        mwl = new MyWindowListener();
        addWindowListener(mwl);
        setSize(300,200);
        setLocation(300, 10);

        Container c = getContentPane();
        c.setBackground(Color.white);
       
        c.setLayout(new BorderLayout());
        
        JLabel usPic = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605d_borderlayout/us.jpeg"));
        JLabel yankeeText = new JLabel("The North");
        JLabel leftCostText = new JLabel("The West");
        JLabel rightCostText = new JLabel("The East");
        JLabel suthenText = new JLabel("The South");

        yankeeText.setHorizontalAlignment(JLabel.CENTER);
        suthenText.setHorizontalAlignment(JLabel.CENTER);
        
        c.add(usPic,"Center");
        c.add(yankeeText,"North");
        c.add(suthenText,"South");
        c.add(leftCostText,"West");
        c.add(rightCostText,"East");

        setVisible(true);
    }
    
    public static void main(String[] args) {
        Border demo = new Border();
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
