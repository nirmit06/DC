import java.io.*;
import java.net.*;

public class Server{
	public static void main(String [] args){
		try(ServerSocket serverSocket =new ServerSocket(5000)){
			System.out.println("Server is running.Waiting for Client connection...");
			Socket clientSocket= serverSocket.accept();
			System.out.println("Client connected: "+ clientSocket);
			
			BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out= new PrintWriter(clientSocket.getOutputStream(),true);
			
			String message;
			while((message=in.readLine())!=null){
				System.out.println("Recieved from client: "+message);
				out.println("Server recieved: "+message);
			}
			
			
			in.close();
			out.close();
			clientSocket.close();
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}