// note:  In LInux, copy test.html to /home/user-clid/httpd/test.html
//        when running, access http://localhost:8081/test.html

package a4;

import java.net.*;

public class HTTPServer {
    
    public static void main(String[] args) throws Exception {
        final int httpd = 8081;
        ServerSocket serverSock = new ServerSocket(httpd);
        System.out.println("listening on local port 8081");
        
        while (true) {
            Socket sock = serverSock.accept();
            System.out.println("client has connected to the socket");
            OneConnection client = new OneConnection(sock);
            new Thread(client).start();
        }
    }
    
}

