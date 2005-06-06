import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MoreSwing {
    
    private JFrame jf, jf2;
    private Container jfc, jfc2;

    private MyActionListener mal;
    private MyWindowListener mwl;

    private JRadioButton tall, extraTall, grande;
    private ButtonGroup latte;

    public MoreSwing(String label, int x, int y) {
        mwl = new MyWindowListener();
        mal = new MyActionListener();
        jf = new JFrame(label);

        jf.setSize(x,y);
        jf.setLocation(x,y);
        jf.addWindowListener(mwl);
        
        jfc = jf.getContentPane();
        jfc.setLayout(new FlowLayout());
        jfc.setBackground(Color.white);
        
        tall = new JRadioButton("Tall");
        extraTall = new JRadioButton("Extra Tall");
        grande = new JRadioButton("Grande");
        
        tall.setBackground(Color.white);
        extraTall.setBackground(Color.white);
        grande.setBackground(Color.white);
        
        tall.addActionListener(mal);
        extraTall.addActionListener(mal);
        grande.addActionListener(mal);

        latte = new ButtonGroup();
        latte.add(tall);
        latte.add(extraTall);
        latte.add(grande);

        jfc.add(tall);
        jfc.add(extraTall);
        jfc.add(grande);
        
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        MoreSwing demo1 = new MoreSwing("One",300,75);
    }
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tall) {
                String message = "... a bran muffin, a tall latte and a traffic jam on the bassin.";
                JOptionPane.showMessageDialog(null, message, "Terror is ...", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == extraTall) {
                String message = "... a bran muffin, an extra tall latte and a traffic jam on the bassin.";
                JOptionPane.showMessageDialog(null, message, "Terror is ...", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == grande) {
                String message = "... a bran muffin, a grande latte and a traffic jam on the bassin.";
                JOptionPane.showMessageDialog(null, message, "Terror is ...", JOptionPane.INFORMATION_MESSAGE);
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
