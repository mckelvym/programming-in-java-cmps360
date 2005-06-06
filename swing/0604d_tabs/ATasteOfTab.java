import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATasteOfTab extends JFrame {
    
    public ATasteOfTab() {
        MyWindowListener mwl = new MyWindowListener();
        addWindowListener(mwl);
        setTitle("The Aftertaste of Tab");
    	setSize(500,400); 
        setLocation(250,125);   	
    	
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setFont(new Font("Monospaced", Font.PLAIN, 12));
        c.setBackground(Color.white);
        c.setForeground(Color.black);
        
        JLabel tux1 = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0604d_tabs/robintux.jpg"));
        JLabel tux2 = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0604d_tabs/plaintux.jpg"));
        
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Robin Tux", tux1);
        jtp.addTab("Plain Tux", tux2);
        
        c.add(jtp);
    }
    
    public static void main(String[] args) {
        ATasteOfTab afterTaste = new ATasteOfTab();
    	afterTaste.show();
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
