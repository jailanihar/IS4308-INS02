package week10.circlecalcmulticlientapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9101);
			System.out.println("Server started on " + new Date());
			
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client has connected.");
				
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							DataInputStream fromClient =
									new DataInputStream(socket.getInputStream());
							DataOutputStream toClient =
									new DataOutputStream(socket.getOutputStream());
							
							while(true) {
								double radius = fromClient.readDouble();
								double area = Math.PI * radius * radius;
								
								toClient.writeDouble(area);
								
								System.out.println("Radius received: " + radius);
								System.out.println("Area sent: " + area);
							}
						} catch (IOException e) {
							System.out.println("Problem with client.");
							e.printStackTrace();
						}
					}
					
				}).start();
			}
			
		} catch (IOException e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
	}
	
}




