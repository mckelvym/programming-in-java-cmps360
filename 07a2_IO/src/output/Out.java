package output;

import javax.swing.*;
import java .io.*;

public class Out {
    
    public Out() {
        String message = "Enter File Path:";
        String path = JOptionPane.showInputDialog(null, message);
        String student;
        
        FileWriter writer;
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            System.out.println("IOException" + e);
            return;
        }
        
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter printer = new PrintWriter(buffer);
        
        message = "Enter ID and grades seperated by spaces:";
                
        student = JOptionPane.showInputDialog(null,message);
        while (student != null) {
            printer.println(student);
            student = JOptionPane.showInputDialog(null,message);
        }
        
        printer.close();
        
    }
    
    public static void main(String[] args) {
        Out demo = new Out();
    }
    
}
