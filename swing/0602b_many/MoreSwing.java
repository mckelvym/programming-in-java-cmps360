import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MoreSwing {
    
    private JFrame jf;
    private Container jfc;

    private MyActionListener mal;
    private MyWindowListener mwl;
    private MyItemListener mil;

    private JButton exit, closePanel;
    private JTextField jtf;
    private JCheckBox jck1, jck2;
    private JPanel jp;
    
    private double amount;
    private boolean flee=true, afterBurners=true;

    public MoreSwing(String label, int x, int y) {
        mwl = new MyWindowListener();
        mal = new MyActionListener();
        mil = new MyItemListener();
        jf = new JFrame(label);

        jf.setSize(x,y);
        jf.setLocation(x,y);
        jf.addWindowListener(mwl);
        
        jfc = jf.getContentPane();
        jfc.setLayout(new FlowLayout());
        jfc.setBackground(Color.white);

        JToolTip jtt = new JToolTip();
        jtt.setTipText("Exit now!");
        jfc.add(jtt);
        
        ImageIcon xIcon = new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0603a_many/x.jpg");
        exit = new JButton(xIcon);
        exit.addActionListener(mal);
        jfc.add(exit);
        
        JLabel jl = new JLabel("Exit Now!");
        jfc.add(jl); 
        
        JLabel jl2 = new JLabel("Enter the dollar amount: ");
        jtf = new JTextField(10);
        jtf.addActionListener(mal);
        jfc.add(jl2);
        jfc.add(jtf);
        
        jck1 = new JCheckBox("Flee", true);
        jck1.setBackground(Color.white);
        jck2 = new JCheckBox("After Burners", true);
        jck2.setBackground(Color.white);
        jck1.addItemListener(mil);
        jck2.addItemListener(mil);
        jfc.add(jck1); jfc.add(jck2);
        Border red = BorderFactory.createLineBorder(Color.red);
        JLabel pictureThis = new JLabel(new ImageIcon("/home/fdd5501/classes/370/2005/lectures/06/06/0603a_many/robintuxsmall.jpeg"));
        jp = new JPanel();
        jp.setBorder(red);
        jp.add(pictureThis);
        closePanel = new JButton("Close");
        closePanel.addActionListener(mal);
        jp.add(closePanel);
        jfc.add(jp);
        
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        MoreSwing demo1 = new MoreSwing("One",300,300);
    }
    
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == jtf) {
                try{
                    amount = Double.parseDouble(jtf.getText());
            	} catch (Exception de) {
                    amount = 0;
            	}
                System.out.println("$" + amount);
            } else if (e.getSource() == closePanel) {
                jp.setVisible(false);
            }
        }
    }
    
    public class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == jck1) {
                flee = !flee;
                System.out.println(flee);
            } else if (e.getSource() == jck2) {
                afterBurners = !afterBurners;
                System.out.println(afterBurners);
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
