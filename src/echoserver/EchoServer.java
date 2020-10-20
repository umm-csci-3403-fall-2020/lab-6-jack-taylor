package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EchoServer {
	
	public static final int PORT_NUMBER = 6013; 

        public static void main(String[] args) throws IOException, InterruptedException{
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
		ExecutorService executor = Executors.newCachedThreadPool();
		ThreadPoolExecutor butler = (ThreadPoolExecutor) executor;
		
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream socketInputStream = socket.getInputStream();
			OutputStream socketOutputStream = socket.getOutputStream();
			executor.submit(new Clients(socket, socketOutputStream, socketInputStream));
			executor.shutdown();
		}
	       }
    public class Clients implements Runnable{
	Socket socket;
	OutputStream output;
	InputStream input;
	// Constructor
	public Clients(Socket socket, OutputStream output, InputStream input){
	    this.socket = socket;
	    this.output = output;
	    this.input = input;
	}
	public void run(){
	    try{
		int inputbyte;
		while((inputbyte = input.read()) != -1){
		    output.write(inputbyte);

		}
		socket.shutdownOutput();
		socket.shutdownInput();
	    }catch(IOException ioe){
		System.out.println("we caught an unexpected exception");

	    }
	}

 //end Clients class
      } 
}
