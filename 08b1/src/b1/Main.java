/*
 * Main.java
 *
 * Created on December 1, 2006, 11:19 AM
 *
 * Example of many Swing Compoents
 */

package b1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fdd5501
 */
public class Main extends JFrame{
    private Container jfc;
    private JButton exit, stop, halt;
    private MyActionListener mal;
    private JTextField jtf;
    private JLabel jtfLabel = new JLabel("Enter your name: ");
    private String name;
    private JPanel jp;
    
public Main(String label, int x, int y) {
        super(label);
        mal= new MyActionListener();

        setSize(x,y);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jfc = getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        jfc.setLayout(gridbag);
         
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 1;                
        gbc.gridheight = 3; 
        exit = new JButton("Exit");
        exit.addActionListener(mal);
        gridbag.setConstraints(exit, gbc);
        jfc.add(exit);
        
        gbc.weighty = 0.0;                 
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        stop = new JButton("Stop");
        stop.addActionListener(mal);
        gridbag.setConstraints(stop, gbc);
        jfc.add(stop);
        halt = new JButton("Halt");
        halt.addActionListener(mal);
        gridbag.setConstraints(halt, gbc);
        jfc.add(halt);
        
        jp = new JPanel();
        jp.setLayout(new GridLayout(2,1));
        jtf = new JTextField(25);
        jtf.addActionListener(mal);
        jp.add(jtfLabel);
        jp.add(jtf);
        jfc.add(jp);

        setVisible(true); 
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit ||
                e.getSource() == stop ||
                e.getSource() == halt) {
                System.exit(0);
            } else if (e.getSource() == jtf) {
                try{
                    name = jtf.getText();
                } catch (Exception de) {
                    name = "nobody";
                }
                jtf.setText("");
                System.out.println(name);
            }
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main demo = new Main("Big Window",500,400);
    }
    
    
    
}
