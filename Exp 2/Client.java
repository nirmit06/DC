import java.net.*;
import java.io.*;

public class Client{
	public static void main(String [] args){
		try(Socket socket= new Socket("localhost",5000)){
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				
				out.println("Hello Server");
				out.println("How are you?");
				
				String response;
				
				while((response=in.readLine())!=null){
					System.out.println("Server says: "+response);
				}
				
				in.close();
				out.close();
		}
		catch(IOException e){
			System.err.println("Client exception: "+e.getMessage());
		}
	}
}