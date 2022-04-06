// some code adapted from GSON blog for reading/writing files
// https://attacomsian.com/blog/gson-read-write-json

package src;
import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.*;

public class JsonToList {

	public List<Student> readJSONStudents(String filename) {
		//to return a list of Student objects from a JSON file
		
		try {
			
			//instantiate empty list of students
			List<Student> studentList = new List<Student>();
			
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(filename));

		    // convert JSON string to User object
		    Student student = gson.fromJson(reader,Student.class);

		    // print user object ( see what happens )
		    System.out.println(student);
		    
		    // add students to studentList
		    // do we need a for loop to catch more than one student? will this work?
		    studentList.add(student);

		    // close reader
		    reader.close();
		    
		    return studentList;

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
//	public List<Event> readJSONEvents(String filename) {
//		//to return a list of Event objects from a JSON file
//		
//		try {
//		    // create Gson instance
//		    Gson gson = new Gson();
//
//		    // create a reader
//		    Reader reader = Files.newBufferedReader(Paths.get(filename));
//
//		    // convert JSON string to User object
//		    Student student = gson.fromJson(reader,Student.class);
//
//		    // print user object
//		    System.out.println(student);
//
//		    // close reader
//		    reader.close();
//
//		} catch (Exception ex) {
//		    ex.printStackTrace();
//		}
//	}
	
}
