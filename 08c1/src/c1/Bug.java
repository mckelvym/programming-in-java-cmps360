package c1;

import java.awt.*;
import javax.swing.*;


public class Bug {
	
    protected int x, y;
    protected double rx, ry;
    protected int color;
    protected int bugPoints=12;		// number of points in a bug
    protected int speed;
    protected int width;
    protected int height;
    protected int direction;
    protected int oledirection;
    protected int MAXDIRECTION=16;
    protected int R=255, G=255, B=255;
    protected int impactzone = 5;
    protected boolean alive = true;


    protected double xpto[ ]={2.0,2.0,5.0,5.0,2.0,1.0,-1.0,-2.0,-5.0,-5.0,-2.0, -2.0};
    protected double ypto[ ]={0.0,3.0,2.0,6.0,5.0,9.0, 9.0,  5.0, 6.0, 2.0,  3.0,  0.0};
    protected double xpt[ ] = {2.0,2.0,5.0,5.0,2.0,1.0,-1.0,-2.0,-5.0,-5.0,-2.0, -2.0};
    protected double ypt[ ] = {0.0,3.0,2.0,6.0,5.0,9.0, 9.0,  5.0, 6.0, 2.0,  3.0,  0.0};
	
    public Bug(int w, int h, int initx, int inity) {
	width = w;
	height = h;
	speed = 5;
	x = initx;
	y = inity;
	rx = x;
	ry = y;
	direction = 0;
	oledirection = 0;
	alive = true;
    }
		
    public void go( ) {
        if (direction > 0) {
            double cpts[ ] = new double[3];
            cpts[0] = 0.0;
            cpts[1] = (double)speed;
            cpts[2] = 1.0;
		
            double newpoints[ ] = new double[3];

            double rotation = 6.28 * ((double) direction) / ((double)MAXDIRECTION);
            double c = Math.cos(rotation);
            double s = Math.sin(rotation);
			
            double trt[ ][ ] = new double[3][3];
            trt[0][0] = c;  trt[0][1] = -s;  trt[0][2] = 0;
            trt[1][0] = s;  trt[1][1] = c;   trt[1][2] = 0;
            trt[2][0] = 0;  trt[2][1] = 0;  trt[2][2] = 1;

            double newpoint[ ] = new double[3];
            for (int i=0; i<3; i++) {
                newpoint[i] = 0;		
                for (int j=0; j<3; j++) newpoint[i] += trt[i][j] * cpts[j];
            }
            rx -= newpoint[0];
            ry -= newpoint[1];
        } else if (direction == 0) ry -= (double)speed;
				
        if ((rx+0.5) >= ((double)width)) rx = (double)(width-1);
        else if (rx < 0.0) rx = 0.0;
        if ((ry+0.5) >= ((double)height)) ry = (double)(height-1);
        else if (ry < 0.0) ry = 0.0;
		
        x = (int)(rx+0.5);
        y = (int)(ry+0.5);
    }

    public int returnx( ) { return x; }
    public int returny( ) { return y; }
	
    public void setdirection(int d) {
        if (d >=0 & d < MAXDIRECTION) {
            direction = d;
            oledirection = -1;
        }
    }

    public void turnright( ) {
        oledirection = direction;
        direction++;
        if (direction >= MAXDIRECTION) direction = 0;
    }

    public void turnleft( ) {
        oledirection = direction;
        direction--;
        if (direction < 0) direction = MAXDIRECTION-1;
    }
	
    public void setBugColor(int r, int g, int b) {
        if (r<256 & r>=0) R = r;
        if (g<256 & g>=0) G = g;
        if (b<256 & b>=0) B = b;
    }
	
    public void paintComponent(Graphics g) {
        if (oledirection != direction) calculateBugParts( );
        paintBug(g);
    }

    public void calculateBugParts( ) {
        if (direction > 0) {
            double rotation = 6.28 * ((double) direction) / ((double)MAXDIRECTION);
            double c = Math.cos(rotation);
            double s = Math.sin(rotation);
			
            double trt[ ][ ] = new double[3][3];
            trt[0][0] = c;  trt[0][1] = -s;  trt[0][2] = 0;
            trt[1][0] = s;  trt[1][1] = c;   trt[1][2] = 0;
            trt[2][0] = 0;  trt[2][1] = 0;   trt[2][2] = 1;

            double point[ ] = new double[3];
            double newpoint[ ] = new double[3];
            for (int p=0; p<bugPoints; p++) {			
                point[0] = xpto[p];  
                point[1] = ypto[p];
                point[2] = 1;
				
                for (int i=0; i<3; i++) {
                    newpoint[i] = 0;		
                    for (int j=0; j<3; j++) 
                        newpoint[i] += trt[i][j] * point[j];
                }
                xpt[p] = newpoint[0];
                ypt[p] = newpoint[1];
                oledirection = direction;
                }
            }
            else if (direction == 0) {
                for (int p=0; p<bugPoints; p++) {
                    xpt[p] = xpto[p];
                    ypt[p] = ypto[p];
                }
                oledirection = direction;
            }
    }

    public void paintBug(Graphics g) {
        Polygon p = new Polygon();
        for (int i=0; i<bugPoints; i++) 
            p.addPoint(x+((int)(xpt[i]+0.5)), y+((int)(ypt[i]+0.5)));
        Color mycolor = new Color(R,G,B);
        g.setColor(mycolor);
        g.fillPolygon(p);
    }

    public boolean isAlive( ){ return alive; }

    public void isDead( ){ alive = false; }

    public boolean impactBug(Bug p) {
        if (p.returnx( )<x+impactzone & p.returnx( )>x-impactzone &
	    p.returny( )<y+impactzone & p.returny( )>y-impactzone) {
            return true;
        } else return false;
    }
}
