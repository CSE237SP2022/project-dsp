package src;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.*;

import argsProcessor.ArgsProcessor;

public class Run {
	
	//TODO: can all the iterating be done in an individual method and then do .command on that method?
	//TODO: stay in "exec" mode until quit

	public static List<Student> allStudents = new ArrayList<Student>();
	public static String studentName;
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String args[]) {
		ArgsProcessor ap = new ArgsProcessor(args);
		readJSONs();
		
		while(true) {
			String userInput = menu_options(ap);
			displayInfoCommand(ap, userInput);
			quitCommand(userInput);
			execCommands(ap, userInput);

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

	private static void execCommands(ArgsProcessor ap, String userInput) {
		if (userInput.equals("rose")) {
			System.out.println("S: create a student; R: remove a brother");
			System.out.println("C: change someone's points");
			System.out.println("Cr: create a company");
			System.out.println("E: create an event");
			System.out.println("A: Add events");
			System.out.println("Q: to quit");
			System.out.println("----------------------\n\n");
			String execCommand = ap.nextString("Welcome exec member. Here are some commands");
			execCreateStudentCommand(ap, execCommand);
			execRemoveBrother(ap, execCommand);
			execChangeBrotherPoints(ap, execCommand);
			quitCommand(execCommand);
			//TODO: add events command
		}
	}

	private static void execChangeBrotherPoints(ArgsProcessor ap, String userInput) {
		if (userInput.equals("C")) {
			String brotherName = ap.nextString("What is the name of the brother to change points");
			int pointsChange = ap.nextInt("How many points would you like to add (include minus sign if you want to lower points)");
			int len=allStudents.size();
			for(int i=0; i<len; i++) {
				if (allStudents.get(i).getName().equals(brotherName)) {
					allStudents.get(i).addPoints(pointsChange);
					updateStudentJSON();
					System.out.println(pointsChange + " have been added to " + brotherName + ". Current points: " + allStudents.get(i).getPoints());
					System.out.println("----------------------\n\n");
				}
			}
		}
	}

	private static void execRemoveBrother(ArgsProcessor ap, String userInput) {
		if (userInput.equals("R")) {
			String brotherName = ap.nextString("What is the name of the brother to be removed?");
			int len=allStudents.size();
			for(int i=0; i<len; i++) {
				if (allStudents.get(i).getName().equals(brotherName)) {
					allStudents.remove(i);
					updateStudentJSON();
					System.out.println(brotherName + " has been removed.");
					System.out.println("----------------------\n\n");
				}
			}
		}
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
						System.out.println("----------------------\n\n");
					}
				}
				else {
					System.out.println("Brother not found. Please check the spelling");
					System.out.println("----------------------\n\n");
				}
			}

		}
	}


	private static void execCreateStudentCommand(ArgsProcessor ap, String userInput) {
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
		createStudent.displayAllInfo();
		allStudents.add(createStudent);
		updateStudentJSON();
		return name;
	}

	private static String menu_options(ArgsProcessor ap) {
		//for future iteration, you'll need to login
		System.out.println("Welcome to the DSP database. Here are some commands to use:");
		System.out.println("Type DisplayInfo to show all information for student given full name");
		System.out.println("If you're on exec, you can also type your secret key");
		System.out.println("----------------------\n\n");
		String userInput = ap.nextString("Please type your command");
		return userInput;
	}
	
	private static void updateStudentJSON() {
		try (Writer writer = new FileWriter("students.json")) {
			gson.toJson(allStudents, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readJSONs() {
	    Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("students.json"));
		    List<Student> importStudentList = Arrays.asList(gson.fromJson(reader, Student[].class));
		    importStudentList.forEach((student) -> allStudents.add(student));
		    reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
