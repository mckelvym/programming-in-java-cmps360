import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowText extends JFrame {

    public static void main(String [] args) {
        ShowText showWindow = new ShowText("/home/fdd5501/classes/370/2005/lectures/06/06/0604b_textarea/text.txt");
    	showWindow.show();
    }
	
    public ShowText(String fileName) {
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
        
        String aLine;
        String actualText = " ";	    
        try {
    	    FileReader reader = new FileReader(fileName);
            BufferedReader in = new BufferedReader(reader);
        	    
            while((aLine = in.readLine())!=null) {
                actualText = actualText + aLine + "\n ";
            }
            reader.close();
		            
	} catch (FileNotFoundException e) {
	    actualText = "File Not Found\n";
        } catch (IOException e) {
	    actualText = "File Broken\n";
    	} 
    	
        JTextArea textArea = new JTextArea(actualText);
	JScrollPane jsp = new JScrollPane(textArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
   	    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	c.add(jsp, BorderLayout.CENTER);

    } // end of ShowText constructor
    
    public class MyWindowListener implements WindowListener {
        public void windowActivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {System.exit(0);}
        public void windowDeactivated(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
    }
    

} // end of ShowText class

