package a2;

import java.io.*;
import java.net.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Socket sock;
		DataInputStream dis;
		BufferedReader bis;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps;

		String mailFrom = "";
		String addressee = "";
		String subject = "";
		String message = "";
		String line = "";
		try{
			System.out.println("From:");
			mailFrom = stdin.readLine();
			System.out.println("To:");
			addressee = stdin.readLine();
			System.out.println("Subject:");
			subject = stdin.readLine();
			System.out.println("Message:");
			line = stdin.readLine();
			while(!line.equals(".")){
				message += "\n" + line;
				line = stdin.readLine();
			}
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Sending mail...");
		sock = new Socket("mailer.louisiana.edu", 25);
		dis = new DataInputStream(sock.getInputStream());
		bis = new BufferedReader(new InputStreamReader(dis));
		ps = new PrintStream(sock.getOutputStream());
		System.out.println(bis.readLine());
		ps.println("mail from: " + mailFrom);
		System.out.println(bis.readLine());
		ps.println("rcpt to: " + addressee);
		System.out.println(bis.readLine());
		ps.println("data");
		System.out.println(bis.readLine());
		ps.println("subject: " + subject);
		ps.println("To: " + addressee);
		ps.println(message);
		ps.println(".");
		System.out.println(bis.readLine());
		ps.flush();
		sock.close();
	}
}
