package hello;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import javax.microedition.m3g.*;

public class Hello extends GameCanvas {
    
    private static final String M3G_FILE = "/hello/helloworld.m3g";
    private static final int USER_ID_MESH = 1;
    private World world;
    private Mesh mesh;
    private Graphics3D graphics3d;
    private Graphics graphics;
    
    public Hello() {
        super(true);
    }
    
    public void init() {
        graphics3d = Graphics3D.getInstance();
        graphics = getGraphics();
        try{
            Object3D[] objects=Loader.load(M3G_FILE);
            world =(World)objects[0];
            Camera camera = world.getActiveCamera();
            float aspect = (float)getWidth() / (float)getHeight();
            camera.setPerspective(60,aspect, 1, 1000);
            mesh = (Mesh)world.find(USER_ID_MESH);
        } catch (Exception e) {
            System.out.println("Error loading " + M3G_FILE);
            e.printStackTrace();
        }
        
        render(graphics);
        flushGraphics();
    }
    
    public void destroy() {}
    
    protected void render(Graphics graphics) {
        graphics3d.bindTarget(graphics);
        graphics3d.setViewport(0,0, getWidth(), getHeight());
        graphics3d.render(world);
        graphics3d.releaseTarget();
    }

}
