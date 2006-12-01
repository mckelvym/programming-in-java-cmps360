package c1;
                
import java.awt.*;
import javax.swing.*;

public class EvilBug extends Bug {

    private Bug victim;

    public EvilBug(int w, int h, int initx, int inity, Bug initVictim) {
        super(w, h, initx, inity);
        victim = initVictim;
    }

    public void calcDirection() {
        double vx = victim.returnx();
        double vy = victim.returny();
        int direction = 0;        
        if (y == vy) {
            if (x > vx) direction = 12;
            else direction = 4;
        } else if (x == vx) {
            if (y > vy) direction = 8;
            else direction = 0;
        } else {
            double slope = (vy - y) / (vx - x);
            if (slope > 0) {
                if (slope < .5) {
                    if (x > vx) direction = 12;
                    else direction = 4;
                }            
                else if (slope > 2) {        
                    if (x > vx) direction = 0;
                    else direction = 8;
                }
                else {                        
                    if (x > vx) direction = 14;
                    else direction = 6;
                }
            }
            else if (slope < 0) {
                if (slope > -.5) {            
                    if (x > vx) direction = 12;
                    else direction = 4;
                }
                else if (slope < -2) {        
                    if (x > vx) direction = 8;
                    else direction = 0;
                }
                 else {                         
                    if (x > vx) direction = 10;
                    else direction = 2;
                }
            }
        }
        setdirection(direction);
    }
}
