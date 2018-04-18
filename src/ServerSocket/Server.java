package ServerSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
    private ServerSocket server;
    
    public Server(String ipAddress) throws Exception {
    	
        if (ipAddress != null && !ipAddress.isEmpty()) 
          this.server = new ServerSocket(2112, 1, InetAddress.getByName(ipAddress));
        else 
          this.server = new ServerSocket(2112, 1, InetAddress.getLocalHost());
    }
    
    public void listen() throws Exception {
    	
        String data = null;
        Socket client = this.server.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\r\nNew connection from " + clientAddress);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));        
        while ( (data = in.readLine()) != null ) {
            System.out.println("\r\nMessage from " + clientAddress + ": " + data);
        }
    }
    
    public InetAddress getSocketAddress() {
        return this.server.getInetAddress();
    }
    
    public int getPort() {
        return this.server.getLocalPort();
    }
    
    public static void main(String[] args) throws Exception {
    	
        Server app = new Server("IP");
        System.out.println("\r\nRunning Server: " + "Host=" + app.getSocketAddress().getHostAddress() + " Port=" + app.getPort());
        
        app.listen();
    }
}