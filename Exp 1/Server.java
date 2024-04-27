import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server{
		public static void main(String[] args){
			try{
				Calculator calculator =new CalculatorImpl();
				LocateRegistry.createRegistry(2000);
				Naming.rebind("CalculatorService",calculator);
				System.out.println("Server is running....");
			}catch (Exception e){
				System.err.println("Server Exception: "+ e.toString());
				e.printStackTrace();
			}
		}
}