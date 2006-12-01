// note:  In LInux, copy test.html to /home/user-clid/httpd/test.html
//        when running, access http://localhost:8081/test.html

package a4;

import java.io.*;
import java.net.*;

public class OneConnection implements Runnable {
    
    Socket sock;
    BufferedReader in = null;
    DataOutputStream out = null;
    
    public OneConnection(Socket sock)throws Exception {
        this.sock = sock;
        in = new BufferedReader(new InputStreamReader(
                                    sock.getInputStream())
                               );
        out = new DataOutputStream(sock.getOutputStream());
    }
    
    String getRequest() throws Exception {
        String s = null;
        while ((s=in.readLine()) != null) {
            System.out.println("got: " + s);
            if (s.indexOf("GET") > -1) {
                out.writeBytes("HTTP-1.0 200 OK\r\n");
                s = s.substring(4);
                int i= s.indexOf(" ");
                System.out.println("file: " + s.substring(0, i));
                
                return s.substring(0,i);
            }
        }
        
        return null;
    }

    public void sendFile(String fname) throws Exception {
        String where = "/home/fdd5501/httpd" + fname;
        if (where.indexOf("..") > -1) 
            throw new SecurityException("No access to parent dirs.");
        System.out.println("looking for " + where);
        File f = new File(where);
        DataInputStream din = new DataInputStream(new FileInputStream(f));
        int len = (int)f.length();
        byte[] buf = new byte[len];
        din.readFully(buf);
        out.writeBytes("Content-Length: " + len + "\r\n");
        out.writeBytes("Content-Type: text/html\r\n\r\n");
        out.write(buf);
        out.flush();
        out.close();
    } 

    public void run() {
        try {
            String filename = getRequest();
            sendFile(filename);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
} // end of class One Connection
