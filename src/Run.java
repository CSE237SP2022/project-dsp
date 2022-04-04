package src;
import java.util.ArrayList;
import java.util.List;

import argsProcessor.ArgsProcessor;

public class Run {

	public static List<Student> allStudents = new ArrayList<Student>();
	public static String studentName;

	public static void main(String args[]) {
		ArgsProcessor ap = new ArgsProcessor(args);

		while(true) {
			String userInput = menu_options(ap);
			createStudentCommand(ap, userInput);
			displayInfoCommand(ap, userInput);
			quitCommand(userInput);

		}

		//		String choice = ap.nextString("Please type Login or Register.");

		//		if (choice == "Login") {
		//			
		//			String username = ap.nextString("Username:");
		//			String password = ap.nextString("Password:");
		//			
		//			while (Login.login(username, password)==false) {
		//				System.out.println("Try again!");
		//				username = ap.nextString("Username:");
		//				password = ap.nextString("Password:");
		//			}
		//			
		//		}



	}

	private static void quitCommand(String userInput) {
		if (userInput.equals("Q")) {
			return;
		}
	}

	private static void displayInfoCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("DisplayInfo")) {
			String nameSearch = ap.nextString("What is the name of the member you want to display information for?");
			boolean showPoints = ap.nextBoolean("Do you only want to see your points? true/false");
			int len=allStudents.size();
			for(int i=0; i<len; i++) {
				if (allStudents.get(i).getName().equals(nameSearch)) {
					if (!showPoints) {
						allStudents.get(i).displayAllInfo();
					}
					else {
						int numPoints = allStudents.get(i).getPoints();
						System.out.println(allStudents.get(i).getName() + " has " + numPoints + " points!");
					}
				}
			}

		}
	}

	private static void createStudentCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("S")) {
			studentName = createStudent(ap, userInput);
		}
	}

	private static String createStudent(ArgsProcessor ap, String input) {
		String name = ap.nextString("Please input your name");
		int gradYear = ap.nextInt("Input your grad year");
		int initYear = ap.nextInt("Input your current year");

		boolean isActive = ap.nextBoolean("Are you an active member?; true/false");
		boolean isFall = ap.nextBoolean("Did you join in the fall? true/false");
		boolean voteElgible = true;

		String school = ap.nextString("What is your primary school?");
		String major1 = ap.nextString("What is your primary major");
		String major2 = ap.nextString("What is your second major");
		String minor1 = ap.nextString("What is your minor?");
		String minor2 = ap.nextString("What is your second minor?");

		Student createStudent = new Student(name, gradYear, initYear, isActive, isFall, voteElgible, school, major1, major2, minor1, minor2);
		allStudents.add(createStudent);
		return name;
	}

	private static String menu_options(ArgsProcessor ap) {
		//for future iteration, you'll need to login
		System.out.println("Welcome to the DSP database. Here are some commands to use:");
		System.out.println("S: create a student; DisplayInfo: show all information for student given full name");
		System.out.println("C: create a company");
		System.out.println("E: create an event");
		System.out.println("Q: to quit");
		String userInput = ap.nextString("Please type your command");
		return userInput;
	}
}
