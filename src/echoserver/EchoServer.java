package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	// REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
	public static final int PORT_NUMBER = 6013; 
	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}public static void main(String[] args) throws IOException {
	    try {
		// Start listening on the specified port
		ServerSocket sock = new ServerSocket(PORT_NUMBER);

		while (true) {
		    Socket client = sock.accept();

		    InputStream input = client.getInputStream();
		    OutputStream output = client.getOutputStream();

		    int inputbyte;
		    while((inputbyte = input.read()) != -1){
			output.write(inputbyte);
		    }
		    output.flush();

		    client.close();
		    sock.close();
		}

	    } catch (IOException ioe) {
		System.out.println("We caught an unexpected exception");
		System.err.println(ioe);
	    }
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();

			// Put your code here.
			// This should do very little, essentially:
			//   * Construct an instance of your runnable class
			//   * Construct a Thread with your runnable
			//      * Or use a thread pool
			//   * Start that thread
		}
	}
}
