/*
 * Main.java
 *
 * Created on December 1, 2006, 10:47 AM
 *
 * example of input with String.split
 */

package a1_io_split;

import javax.swing.*;
import java.io.*;

public class Main {
    
    public Main() {
        FileReader reader = null;
        String line; 
        String path;
        String lineArray[];
        int sum=0;
        
        path = JOptionPane.showInputDialog(null, "Enter path:");
        
        try {
            reader = new FileReader(path);
            BufferedReader bReader = new BufferedReader(reader);
            
            while ((line = bReader.readLine()) != null) {

                sum = 0;
                lineArray = line.split(" ");
                
                for (int i=1; i<lineArray.length; i++) 
                    sum += Integer.parseInt(lineArray[i]);
                
                System.out.print("ID-" + lineArray[0] + ", avg: ");
                if (lineArray.length != 0)
                    System.out.println(sum / lineArray.length);
                else
                    System.out.println(0);
                
            }

            bReader.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return;
        }
    }
    
        
    public static void main(String []argv) {
        Main demo = new Main();
    }
    
}
