package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) throws IOException {

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

public class Reader implements Runnable {
	
	InputStream input;
	Socket soc;
	
	public Reader(Socket soc, InputStream input) {
		
		this.soc = soc;
		this.input = input;
	}

	public void run() {
		
		while ((dataFeed = System.in.read()) != -1) {
			System.out.write(dataFeed);
			System.out.flush();
		}
		
		soc.shutdownOutput();
	}
}

public class Writer implements Runnable {
	
	OutputStream output;
	Socket soc;

	public Writer (Socket soc, OutputStream output) {
		this.soc = soc;
		this.output = output;
	}
	
	while ((dataFeed = System.in.read()) != -1) {
		output.write(dataFeed);
		output.flush();
	}
	
	soc.shutdownOutput();
}
