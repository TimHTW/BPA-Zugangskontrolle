package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

    public class Client {
    	
        private Socket socket;
        
        private Client(String serverAddress, int serverPort) throws Exception {
            this.socket = new Socket(serverAddress, serverPort);
        }
        
        private void start() throws IOException {
        	
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            byte[] buffer = new byte[1024];
            int read;
            while((read = stream.read(buffer)) != -1) {
            	String output = new String(buffer, 0, read);
            	System.out.println(output.length() + " -- " + output);
            	//System.out.flush();
            }
        }
            
        
        public static void main(String[] args) throws Exception {
        	
            Client client = new Client("192.168.0.1", 2112);
            
            System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
            client.start();                
        }
    }
