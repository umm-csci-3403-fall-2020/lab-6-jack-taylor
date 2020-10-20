package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) throws IOException {

	String server;
	
	// Setting up the constructor
	public static void main(String[] args) throws Interrupted Exception {
		EchoClient client = new EchoClient();
		client.start();
	}

   	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		InputStream socketInputStream = socket.getInputStream();
		OutputStream socketOutputStream = socket.getOutputStream();
		Thread firstThread = new Thread(socketInputStream);
		Thread secondThread = new Thread(socketOutputStream);
		firstThread.start();
		secondThread.start();
    	}
}
