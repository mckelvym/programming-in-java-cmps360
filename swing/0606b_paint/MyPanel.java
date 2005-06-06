import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
    
    private final int H, W;
    
    public MyPanel() {
        W = 200;
        H = 150;

        setSize(W,H);
        setLayout(new FlowLayout());

        JLabel jl = new JLabel("Go!");
        jl.setFont(new Font("SansSerif", Font.BOLD, 24));
        jl.setForeground(new Color(250,250,100));
        JButton jb = new JButton("Click!");
        
        add(jl);
        add(jb);
    }
    
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        g.setColor(Color.red); 
        g.fillRect(0,0,W/4,H); 
        g.setColor(Color.yellow); 
        g.fillRect(W/4,0,W/2,H); 
    }    
    
}
