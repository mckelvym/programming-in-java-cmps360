import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Animation extends JFrame {
    
    MyWindowListener mwl;
    
    public Animation() {
        mwl = new MyWindowListener();
        addWindowListener(mwl);
        setSize(200, 225);
        setLocation(300, 300);

        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(new FlowLayout());
        
        JLabel red = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605b_jpanel/red.gif"));
        JLabel green = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605b_jpanel/green.gif"));
        JLabel yellow = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0605b_jpanel/yellow.gif"));
        
        boolean doubleBuffered = true;
        JPanel jp = new JPanel(doubleBuffered);
        jp.setBackground(Color.white);
        
        c.add(jp);
        setVisible(true);
        
        while (true) {
            AddIt(jp,red);
            AddIt(jp, green);
            AddIt(jp, yellow);
        }
        
    }
    
    public static void main(String[] args) {
        Animation demo = new Animation();
    }
 
    public void AddIt(JPanel jp, JLabel o) {
        jp.removeAll();
        jp.add(o);
        jp.setVisible(false);
        jp.setVisible(true);
        Sleeper(1000);
    }
    
    
    public void Sleeper(int mil) {
        try {
            Thread.sleep(mil);
        } catch (Exception e) {}
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
