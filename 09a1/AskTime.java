import java.io.*;
import java.net.*;

public class AskTime {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: java AskTime  <systemname>");
            System.exit(0);
        }

        String machine = args[0];
        final int dayTimePort = 13;
        Socket sock = new Socket(machine, dayTimePort);
        BufferedReader br 
	    = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        br.readLine();
	System.out.println(machine + " says it is " + br.readLine());
    }
}
