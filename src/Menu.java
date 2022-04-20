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

public class Menu {

	public static List<Student> allStudents = new ArrayList<Student>();
	public static List<Event> allEvents = new ArrayList<Event>();
	public static String studentName;
	public static String eventName;
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String args[]) {
		ArgsProcessor ap = new ArgsProcessor(args);
		readJSONs();
		boolean brotherQuit = false;
		
		while(!brotherQuit) {
			String userInput = menu_options(ap);
			if (brotherQuit(userInput)) {
				brotherQuit = true;
			}
			commandMaster(ap, userInput);
		}
	}

	private static void commandMaster(ArgsProcessor ap, String userInput) {
		displayInfoCommand(ap, userInput);
		displayEventsCommand(ap, userInput);
		quitCommand(userInput);
		execCommands(ap, userInput);
	}
	
	private static boolean brotherQuit(String userInput) {
		if (userInput.equals("Q")) {
			return true;
		}
		return false;
	}

	private static void execCommands(ArgsProcessor ap, String userInput) {
		if (userInput.equals("rose")) {
			System.out.println("S: create a brother; R: remove a brother");
			System.out.println("C: change someone's points");
			System.out.println("AllPoints: view all brothers and their points");
			System.out.println("Cr: create a company");
			System.out.println("E: create an event");
			System.out.println("Q: to quit");
			System.out.println("----------------------\n\n");
			allExecCommands(ap);
			//TODO: add display events command
		}
	}

	private static void allExecCommands(ArgsProcessor ap) {
		String execCommand = ap.nextString("Welcome exec member. Here are some commands");
		execCreateStudentCommand(ap, execCommand);
		execRemoveBrother(ap, execCommand);
		execChangeBrotherPoints(ap, execCommand);
		execDisplayAllPoints(ap, execCommand);
		execCreateEventCommand(ap, execCommand);
		quitCommand(execCommand);
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
	
	private static void execCreateEventCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("E")) {
			eventName = createEvent(ap, userInput);
		}
	}

	private static String createEvent(ArgsProcessor ap, String userInput) {
		String dateOfEvent = ap.nextString("What is the date of the event");
		String nameOfEvent = ap.nextString("What is the name of the event");
		int pointsForEvent = ap.nextInt("How many points is this event worth");
		boolean isRequired = ap.nextBoolean("Is the event required? true/false");
		Event createEvent = new Event(dateOfEvent, nameOfEvent, pointsForEvent, isRequired);
		allEvents.add(createEvent);
		updateEventJSON();
		return nameOfEvent;
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
			boolean brotherFound = searchBrotherName(nameSearch, showPoints);
			if (!brotherFound) {
				System.out.println("Brother not found. Please check the spelling");
				System.out.println("----------------------\n\n");
			}
		}
	}
	
	private static void displayEventsCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("Events")) {
			int len=allEvents.size();
			for(int i=0; i<len; i++) {
				System.out.printf("%-20s %s\n", allEvents.get(i).getDate(), allEvents.get(i).getName());
			}
			System.out.println();
		}
	}

	private static boolean searchBrotherName(String nameSearch, boolean showPoints) {
		boolean brotherFound = false;
		int len=allStudents.size();
		for(int i=0; i<len; i++) {
			if (allStudents.get(i).getName().equals(nameSearch)) {
				brotherFound = true;
				if (!showPoints) {
					allStudents.get(i).displayAllInfo();
				}
				else {
					int numPoints = allStudents.get(i).getPoints();
					System.out.println(allStudents.get(i).getName() + " has " + numPoints + " points!");
					System.out.println("----------------------\n\n");
				}
			}
		}
		return brotherFound;
	}

	public static void execDisplayAllPoints(ArgsProcessor ap, String userInput) {
		if (userInput.equals("AllPoints")) {
			int len=allStudents.size();
			for(int i=0; i<len; i++) {
				System.out.printf("%-20s %s\n", allStudents.get(i).getName(), allStudents.get(i).getPoints());
			}
			System.out.println("----------------------\n\n");
		}
	}


	private static void execCreateStudentCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("S")) {
			studentName = createStudent(ap, userInput);
		}
	}

	private static String createStudent(ArgsProcessor ap, String input) {
		String name = ap.nextString("Please input your name");
		int len=allStudents.size();
		for(int i=0; i<len; i++) {
			if (allStudents.get(i).getName().equals(name)) {
				name = ap.nextString("This student name already exists. Please input a new name");
			}
		} 
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
		System.out.println("Type Events to see a list of all DSP events");
		System.out.println("Type Q to quit");
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

	private static void updateEventJSON() {
		try (Writer writer = new FileWriter("events.json")) {
			gson.toJson(allEvents, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readJSONs() {
		try {
			Reader readerStudents = Files.newBufferedReader(Paths.get("students.json"));
			List<Student> importStudentList = Arrays.asList(gson.fromJson(readerStudents, Student[].class));
			importStudentList.forEach((student) -> allStudents.add(student));
			readerStudents.close();
			
			Reader readerEvents = Files.newBufferedReader(Paths.get("events.json"));
			List<Event> importEventsList = Arrays.asList(gson.fromJson(readerEvents, Event[].class));
			importEventsList.forEach((event) -> allEvents.add(event));
			readerEvents.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
