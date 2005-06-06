package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Midlet extends MIDlet {
   
    private Hello demo;
    
    public Midlet(){}
    
    public void startApp() {
        if (demo == null) {
            demo = new Hello();
            demo.init();
            Display.getDisplay(this).setCurrent(demo);
        }
    }
    
    public void pauseApp() {}
    
    public void destroyApp(boolean unconditional) {
        if (demo != null) demo.destroy();
    }
}
 