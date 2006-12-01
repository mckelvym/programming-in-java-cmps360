package Input;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class In {
    
    public In() {
        StringTokenizer st;
        FileReader reader = null;
        String line; 
        String path;
        String id="";
        int sum=0, count=0;
        
        path = JOptionPane.showInputDialog(null, "Enter path:");
        
        // version 1
        try {
            reader = new FileReader(path);
            BufferedReader bReader = new BufferedReader(reader);
            
            while ((line = bReader.readLine()) != null) {

                sum = count = 0;
                st = new StringTokenizer(line);
                id = st.nextToken();
                
                while (st.hasMoreTokens()) { 
                    sum += Integer.parseInt(st.nextToken());
                    count ++;
                }
                
                System.out.print("ID-" + id + ", avg: ");
                if (count != 0)
                    System.out.println(sum / count);
                else
                    System.out.println(0);
                
            }

            bReader.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return;
        }






        








        
        // version 2
        try {

            reader = new FileReader(path);
            BufferedReader bReader = new BufferedReader(reader);
            
            while ((line = bReader.readLine()) != null) {
                sum = count = 0;
                st = new StringTokenizer(line);
                id = st.nextToken();
                
                try {
                    while (true) { 
                        sum += Integer.parseInt(st.nextToken());
                        count ++;
                    }
                } catch (NoSuchElementException e) {
                    System.out.print("ID-" + id + ", avg: ");
                    if (count != 0) 
                        System.out.println(sum / count);
                    else
                        System.out.println(0);
                }

            }
            
            bReader.close();
            
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return;
        }
        
    }
    
    public static void main(String []argv) {
        In demo = new In();
    }
    
}
