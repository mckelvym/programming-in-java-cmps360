import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PerryWhite extends JFrame {
    
    public PerryWhite(String fileName) {
        MyWindowListener mwl = new MyWindowListener();
        addWindowListener(mwl);
        setTitle("Text Reader");
    	setSize(500,400);
    	setLocation(250,125);   	
    	
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setFont(new Font("Monospaced", Font.PLAIN, 12));
        c.setBackground(Color.white);
        c.setForeground(Color.black);
        
        JEditorPane jep = null;
        try {
            jep = new JEditorPane("file://" + fileName);
        } catch (Exception e) {
            System.out.println("Booboo: " + e);
        }
        
        jep.setEditable(true);
        
        JScrollPane jsp = new JScrollPane(jep,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
   	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.add(jsp);
    }
    
    public static void main(String[] args) {
        PerryWhite pw = new PerryWhite("/home/fdd5501/classes/370/2005/lectures/06/06/0604c_jedtorpane/text.txt");
        pw.show();
    }
    
    public class MyWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {System.exit(0);}
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
    }
    
}
