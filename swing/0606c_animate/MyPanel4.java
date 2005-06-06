import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel4 extends JPanel implements Runnable {
    
    private final int H, W;
    Thread go;

    char randChar;
    int pass=0;
    
    
    public MyPanel4() {
        go = new Thread(this);
        W = 200;
        H = 150;
        
        randChar = (char)((int)(Math.random()*26)+65);

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

        Image buffer =  createImage(W,H);
        Graphics hiddenG = buffer.getGraphics();
        
        hiddenG.setColor(Color.black); 
        hiddenG.fillRect(0,0,W,H); 
        
        pass = (pass+1) % 2;
        if (pass == 0) {
            hiddenG.setColor(Color.red); 
            hiddenG.fillRect(0,0,W/4,H); 
            hiddenG.setColor(Color.yellow); 
            hiddenG.fillRect(W/4,0,W/2,H); 
        } else {
            hiddenG.setColor(Color.yellow); 
            hiddenG.fillRect(0,0,W/4,H); 
            hiddenG.setColor(Color.red); 
            hiddenG.fillRect(W/4,0,W/2,H); 
        }
        g.drawImage(buffer,0,0,this);
        Sleep();
    }    
    
    public void run() {
        while(true) {
            repaint();
        }
    }
    
    public void start() {
        go.start();
    }

    public void Sleep() {
        try {
            go.sleep(100);
        } catch(Exception e) {}
    }
    
}

