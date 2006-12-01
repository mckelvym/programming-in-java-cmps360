package a3;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class StockBot {
    
    public static void main(String[] args) throws Exception {
        String stock = JOptionPane.showInputDialog(null,"Enter Stock Symbol");
        String yahoo= "finance.yahoo.com";
        final int httpd = 80;
        Socket sock = new Socket(yahoo, httpd);
        
        BufferedWriter out = new BufferedWriter(
        	  new OutputStreamWriter(sock.getOutputStream()));
        
        String cmd = "GET /q?" + "s=" + stock + "\n";
        out.write(cmd);
        out.flush();        
        
        BufferedReader in = new BufferedReader(
            new InputStreamReader(sock.getInputStream()));
        String s = null;
        int j,k,l,m;

        while ((s=in.readLine()) != null) {
            if (s.length() < 100) continue;
            if (s.indexOf("Change:") < 0) continue;
            s = s.substring(s.indexOf("Change:"));
            j = s.indexOf("</b> <b style=");
            s = s.substring(j-12,j); 
            k = s.indexOf(">");
            s = s.substring(k+1);
            String message = "Change in " + stock + " is " + s;
            JOptionPane.showMessageDialog(null,message);
            break;
        }
    }
} // end of class StockBot
         