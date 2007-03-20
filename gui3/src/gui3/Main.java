package gui3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main { 
    private JFrame jf;
    private Container jfc;
    private JButton exit;        
    private MyActionListener mal;
    
    public Main() {
        mal = new MyActionListener();
        jf = new JFrame("My First Button");
        
        jf.setSize(400,300);
        jf.setLocation(400,200);
        jf.setLayout(new FlowLayout());
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        jfc = jf.getContentPane();
        
        exit = new JButton("Exit");
        exit.addActionListener(mal);
        
        jfc.add(exit);
        
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        Main demo = new Main();
    }
    
    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit){
                System.out.println("Pushed");
                System.exit(0);
            }                
        }
    }
    
    
}
