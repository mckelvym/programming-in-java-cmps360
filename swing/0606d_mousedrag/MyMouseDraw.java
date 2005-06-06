import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMouseDraw extends JPanel implements Runnable {

    private boolean pressed = false;
    private boolean entered = false;
    private int h, w;
    private int tempStartX, tempStartY, tempNewX, tempNewY;
    private int startX, startY, newX, newY;
    Thread t;
    
    MyMouseListener mml;
    
    public MyMouseDraw(int width, int height) {
        mml = new MyMouseListener();
        
        tempStartX = tempStartY = tempNewX = tempNewY = 0;
        startX = startY = newX = newY = 0;
        
        h = height; 
        w = width;
        
        setSize(w,h);
        setLayout(new FlowLayout());
        
        t = new Thread(this);
        
        addMouseListener(mml);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(100,150,200));
        g.fillRect(0,0,w,h);
        g.setColor(Color.red);
        g.fillOval(startX,startY,newX-startX,newY-startY);
    }

    public void run() {
        while (true) {
            repaint();
            try {
                t.sleep(100);
            } catch (Exception e) {}
        }
    }  
        
    public void start() {
        t.start();
    }
        
    public class MyMouseListener implements MouseListener {
      
        public void mouseEntered(MouseEvent e) {
            System.out.println("entered");
            entered = true;
        }
    
        public void mouseExited(MouseEvent e) {
            System.out.println("exited");
            entered = false;
        }
        
        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
            if (entered) {
                pressed = true;
                startX = 0;
                startY = 0;
                newX = 0;
                newY = 0;
                tempStartX = e.getX();
                tempStartY = e.getY();
            }
        }
        
        public void mouseReleased(MouseEvent e) {
            System.out.println("released");
            if (entered && pressed) {
                pressed  = false;
                tempNewX = e.getX();
                tempNewY = e.getY();
                startX   = Math.min(tempNewX,tempStartX);
                startY   = Math.min(tempNewY,tempStartY);
                newX     = Math.max(tempNewX,tempStartX);
                newY     = Math.max(tempNewY,tempStartY);
            }
        }

        public void mouseClicked(MouseEvent e) {
        }
    
    }
    
}

