package c1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    private final int HEIGHT = 400;
    private final int WIDTH  = 500;

    private MainPanel gamePanel;

    
    public Main() {
        
        setSize(WIDTH, HEIGHT);
        setTitle("Javabybugs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,50);
                
        Container c = getContentPane();
        
        c.setLayout(new BorderLayout());
        c.setFont(new Font("SansSerif", Font.BOLD, 12));
        c.setBackground(Color.white);
        
        gamePanel = new MainPanel(WIDTH, HEIGHT);
        c.add(gamePanel, BorderLayout.CENTER);
        
        gamePanel.start();
        setVisible(true);
    }

    public static void main(String args[]) {
    Main mainFrame = new Main();
    }

}

