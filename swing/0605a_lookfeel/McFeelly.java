import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class McFeelly {
    
    MyWindowListener mwl;
    MyActionListener mal;
    JButton exitWindoze, exitUnix, exitJava;

    public static void main(String[] args) {
        McFeelly demo = new McFeelly();
    }

    public McFeelly() {
        mwl = new MyWindowListener();
        mal = new MyActionListener();
        WindowsWin();
        UnixWin();
        JavaWin();
    }
    
    public void WindowsWin() {
        JFrame billy = new JFrame();
        SetLF(billy,"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        billy.addWindowListener(mwl);
        billy.setTitle("Windoze");
    	billy.setSize(200,75);
    	billy.setLocation(200,200);
    	
        Container c = billy.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        
        exitWindoze = new JButton("Click Me!");
        exitWindoze.addActionListener(mal);
        c.add(exitWindoze);
        
        billy.setVisible(true);
    }
    
    public void UnixWin() {
        JFrame sunny = new JFrame();
        SetLF(sunny,"com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        sunny.setTitle("Unix");
    	sunny.setSize(200,75);
    	sunny.setLocation(300,275);   	
    	
        Container c = sunny.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);

        exitUnix = new JButton("Click Me!");
        exitUnix.addActionListener(mal);
        c.add(exitUnix);
        
        sunny.setVisible(true);
    }
    
    public void JavaWin() {
        JFrame tJava = new JFrame();
        SetLF(tJava,"javax.swing.plaf.metal.MetalLookAndFeel");
        tJava.setTitle("Java");
    	tJava.setSize(200,75);
    	tJava.setLocation(400,350);   	
    	
        Container c = tJava.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);

        exitJava = new JButton("Click Me!");
        exitJava.addActionListener(mal);
        c.add(exitJava);

        tJava.setVisible(true);
    }

    public void SetLF(JFrame f, String lf) {
        try {
            UIManager.setLookAndFeel(lf);
            SwingUtilities.updateComponentTreeUI(f);
            f.pack();
        } catch (Exception e) {
            System.out.println("error: " + e);
        };
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitWindoze) {
                System.exit(0);
            } else if (e.getSource() == exitUnix) {
                System.exit(0);
            } else if (e.getSource() == exitJava) {
                System.exit(0);
            } 
        }
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
