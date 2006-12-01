package c1;

import java.awt.*;
import javax.swing.*;


public class BugZapper {

    private int x;
    private int y;
    private int scale;
	
	
    public void set(int initX, int initY, int initScale) {
        x = initX;
        y = initY;
        scale = initScale;	
    }


    public void paintComponent(Graphics g)	{
        Color runnyGray = new Color(128,96,64);
        g.setColor(runnyGray);
        g.fillArc(x,y,scale/2,scale/2,0,45);
        g.fillArc(x,y,scale/2,scale/2,90,45);
        g.fillArc(x,y,scale/2,scale/2,180,45);
        g.fillArc(x,y,scale/2,scale/2,270,45);
        Color runnyBrown = new Color(128,84,64);
        g.setColor(runnyBrown);
        g.fillArc(x,y,scale/2,scale/2,45,45);
        g.fillArc(x,y,scale/2,scale/2,135,45);
        g.fillArc(x,y,scale/2,scale/2,225,45);
        g.fillArc(x,y,scale/2,scale/2,315,45);
    }


    public BugZapper(int initX, int initY, int initScale) {
        x = initX;
        y = initY;
        scale = initScale;	
    }


    public boolean impactBug(Bug p) {				
        int halfscale = scale/2;
        if (p.returnx( )>x & p.returnx()<x+halfscale &
            p.returny( )>y & p.returny( )<y+halfscale) 
            return true;
        else return false;
    }
}
