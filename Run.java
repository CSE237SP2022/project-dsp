import cse131.ArgsProcessor //placeholder for now

public class Run {

	public static void main(String args[]) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String username = ap.nextString("Username:");
		String password = ap.nextString("Password:");
		
		while (Login.login(username, password)==false) {
			System.out.println("Try again!");
			username = ap.nextString("Username:");
			password = ap.nextString("Password:");
		}
		
	}
}
