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
	public static List<Company> allCompanies = new ArrayList<Company>();
	public static String studentName;
	public static String eventName;
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	
	//it's easy to get lost with all of these small methods, so they are categorized
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

	//menu options and command methods are used below
	private static String menu_options(ArgsProcessor ap) {
		System.out.println("Welcome to the DSP database. Here are some commands to use:");
		System.out.println("Type DisplayInfo to show all information for student given full name");
		System.out.println("Type Events to see a list of all DSP events");
		System.out.println("Type Companies to see a list of all DSP companies");
		System.out.println("Type CreateCompany to create a company");
		System.out.println("Type AddResume to add a resume item to a brother");
		System.out.println("Type RemoveResume to remove a resume item of a brother");
		System.out.println("Type EditResume to edit a resume item of a brother");
		System.out.println("Type Q to quit");
		System.out.println("If you're on exec, you can also type your secret key");
		System.out.println("----------------------\n\n");
		String userInput = ap.nextString("Please type your command");
		return userInput;
	}
	
	private static void commandMaster(ArgsProcessor ap, String userInput) {
		displayInfoCommand(ap, userInput);
		displayEventsCommand(ap, userInput);
		displayCompaniesCommand(ap, userInput);
		createCompanyCommand(ap, userInput);
		addResumeCommand(ap, userInput);
		removeResumeCommand(ap, userInput);
		editResumeCommand(ap, userInput);
		quitCommand(userInput);
		execCommands(ap, userInput);
	}
	
	private static void execCommands(ArgsProcessor ap, String userInput) {
		if (userInput.equals("rose")) {
			System.out.println("S: create a brother; R: remove a brother");
			System.out.println("C: change someone's points");
			System.out.println("AllPoints: view all brothers and their points");
			System.out.println("E: create an event");
			System.out.println("Q: to quit");
			System.out.println("----------------------\n\n");
			allExecCommands(ap);
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
	
	//execution of commands
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
	
	//used to quit out of program altogether
	private static boolean brotherQuit(String userInput) {
		if (userInput.equals("Q")) {
			return true;
		}
		return false;
	}

	//quits out of "exec mode" (after typing rose)
	private static void quitCommand(String userInput) {
		if (userInput.equals("Q")) {
			return;
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
	
	private static void editResumeCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("EditResume")) {
			String nameSearch = ap.nextString("What is the name of the member you want to add a resume item for?");
			
			for(int i=0; i<allStudents.size(); i++) {
				if (allStudents.get(i).getName().equals(nameSearch)) {
					int editChoice = ap.nextInt("Submit 1 to change the role title, and 2 to end the role?");
					String companyName = ap.nextString("What is the name of the company you want to change?");
					if(editChoice == 1) {
						String newTitle = ap.nextString("What is your new title?");
						allStudents.get(i).updateResumeRollTitle(companyName, newTitle);
					}
					else if(editChoice == 2) {
						int yearEnded = ap.nextInt("What year did you end the positon?");
						allStudents.get(i).endResumeRoll(companyName, yearEnded);
					}
					updateStudentJSON();
					updateCompanyJSON();
					break;
				}
			}
		}
	}
	
	private static void removeResumeCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("RemoveResume")) {
			String nameSearch = ap.nextString("What is the name of the member you want to add a resume item for?");
			
			for(int i=0; i<allStudents.size(); i++) {
				if (allStudents.get(i).getName().equals(nameSearch)) {
					String companyName = ap.nextString("What is the name of the company you want to remove?");
					allStudents.get(i).removeRole(companyName);
					
					updateStudentJSON();
					updateCompanyJSON();
					break;
				}
			}
		}
	}
	
	private static Company resumeCompanyHelper(ArgsProcessor ap) {
		String companySearch = ap.nextString("What is the name of the company?");
		for(int j =0; j< allCompanies.size(); j++) {
			if (allCompanies.get(j).getName().equals(companySearch)) {
				return allCompanies.get(j);
			}
		}
		return createCompanyHelper(ap, companySearch);
	}
	
	private static void addResumeCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("AddResume")) {
			String nameSearch = ap.nextString("What is the name of the member you want to add a resume item for?");
			
			for(int i=0; i<allStudents.size(); i++) {
				if (allStudents.get(i).getName().equals(nameSearch)) {
					Company companyInsert = resumeCompanyHelper(ap);
					
					String roleName = ap.nextString("What is the title of the role?");
					boolean isActive = ap.nextBoolean("Is this an active role? true/false");
					int yearStarted = ap.nextInt("What year did you start the positon?");
					
					if(isActive) {
						allStudents.get(i).addResumeItem(companyInsert, roleName, yearStarted);
					}
					else {
						int yearEnded = ap.nextInt("What year did you end the positon?");
						allStudents.get(i).addResumeItem(companyInsert, roleName, yearStarted, yearEnded);
					}
					updateStudentJSON();
					updateCompanyJSON();
					break;
				}
			}
		}
	}
	
	//event, student, and company creation
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

	private static void createCompanyCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("CreateCompany")) {
			String nameOfCompany = ap.nextString("What is the name of the company?");
			createCompanyHelper(ap, nameOfCompany);
		}
	}
	
	private static Company createCompanyHelper(ArgsProcessor ap, String nameOfCompany) {
		String industry = ap.nextString("What is the industry of the company?");
		String description = ap.nextString("What is the company description?");
		Company createCompany = new Company(nameOfCompany, industry, description);
		allCompanies.add(createCompany);
		updateCompanyJSON();
		return createCompany;
	}
	
	//displaying information 
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
				System.out.println(allEvents.get(i) + "\n");
			}
			System.out.println();
		}
	}
	
	private static void displayCompaniesCommand(ArgsProcessor ap, String userInput) {
		if (userInput.equals("Companies")) {
			int len=allCompanies.size();
			for(int i=0; i<len; i++) {
				System.out.println(allCompanies.get(i) + "\n");
			}
		}
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

	//all JSON file material
	private static void updateStudentJSON() {
		try (Writer writer = new FileWriter("students.json")) {
			gson.toJson(allStudents, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void updateEventJSON() {
		try (Writer writer = new FileWriter("events.json")) {
			gson.toJson(allEvents, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateCompanyJSON() {
		try (Writer writer = new FileWriter("companies.json")) {
			gson.toJson(allCompanies, writer);
		} catch (IOException e) {
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
			
			Reader readerCompany = Files.newBufferedReader(Paths.get("companies.json"));
			List<Company> importCompaniesList = Arrays.asList(gson.fromJson(readerCompany, Company[].class));
			importCompaniesList.forEach((insertCompany) -> allCompanies.add(insertCompany));
			readerCompany.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
