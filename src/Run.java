package src;
import argsProcessor.ArgsProcessor;

public class Run {

	public static void main(String args[]) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String choice = ap.nextString("Please type Login or Register.");
		
		if (choice == "Login") {
			
			String username = ap.nextString("Username:");
			String password = ap.nextString("Password:");
			
			while (Login.login(username, password)==false) {
				System.out.println("Try again!");
				username = ap.nextString("Username:");
				password = ap.nextString("Password:");
			}
			
		}
		
		
		
	}
}
