import java.rmi.Naming;

public class Client{
	public static void main(String[] args){
		try{
			Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
			int result = calculator.add(10,20);
			System.out.println("Result from server: "+ result);
		}
		catch(Exception e){
			System.err.println("Client Exception: "+ e.toString());
			e.printStackTrace();
		}
	}
}