package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    
	public static final int PORT_NUMBER = 6013;

	// Setting up the constructor
	public static void main(String[] args) throws IOException {
		
		EchoClient client = new EchoClient();
		client.start();
	
	}

   	private void start() throws IOException {
		
		Socket soc = new Socket("localhost", PORT_NUMBER);
		
		InputStream socketInputStream = soc.getInputStream();
		OutputStream socketOutputStream = soc.getOutputStream();
		
		Reader reader = new Reader(soc, socketInputStream);
		Writer writer =  new Writer(soc, socketOutputStream);

		Thread firstThread = new Thread(reader);
		Thread secondThread = new Thread(writer);
		
		firstThread.start();
		secondThread.start();
	}

public class Reader implements Runnable {
	
	InputStream input;
	Socket soc;
	
	public Reader(Socket soc, InputStream input) {
		this.soc = soc;
		this.input = input;
	}

	public void run() {
		
		try{
			int dataFeed;
		while ((dataFeed = System.in.read()) != -1) {
			System.out.write(dataFeed);
			System.out.flush();
		}
		
		soc.shutdownOutput();
	} catch (IOException ioe){
		System.out.println("We caught an unexpected exception");
	}
}
}

public class Writer implements Runnable {
	
	OutputStream output;
	Socket soc;

	public Writer (Socket soc, OutputStream output) {
		this.soc = soc;
		this.output = output;
	}
	
	public void run() {
	try {
		int dataFeed;
		while ((dataFeed = System.in.read()) != -1) {
			output.write(dataFeed);
			output.flush();
	} }catch (IOException ioe) {
		System.out.println("We caught an unexpected exception");
	}
	}
}
}

