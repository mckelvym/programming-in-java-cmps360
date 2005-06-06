import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstSwing {
    
    private JFrame jf;
    private Container jfc;
    private JButton exit;
    private MyActionListener mal;
    private MyWindowListener mwl;

    public FirstSwing(String label, int x, int y) {
        mwl = new MyWindowListener();
        mal= new MyActionListener();
        jf = new JFrame(label);

        jf.setSize(300,200);
        jf.setLocation(x,y);
        jf.addWindowListener(mwl);
        
        jfc = jf.getContentPane();
        jfc.setLayout(new FlowLayout());
        
        exit = new JButton("Exit");
        exit.addActionListener(mal);

        jfc.add(exit);

        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        FirstSwing demo1 = new FirstSwing("One",300,200);
        FirstSwing demo2 = new FirstSwing("Two",50,300);
        FirstSwing demo3 = new FirstSwing("Three",600,100);
    }
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit) {
                System.out.println("Pushed");
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
