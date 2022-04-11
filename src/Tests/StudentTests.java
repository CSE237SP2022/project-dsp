package src.Tests;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import src.Company;
import src.Role;
import src.Student;


public class StudentTests {
	
	private Student s;
	private Company company;
	private Role currentRole;
	
	@Before
	public void setup() {
			s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
			company = new Company("Apple", "Tech", "Makes iPhones");
			currentRole = new Role(company, "CEO", LocalDate.of(2020, 1, 8));
		}

	@Test
	public void testName() {
		String name = s.getName();
		assertEquals("Gavin Frank", name);
	}
	
	@Test
	 public void testGradYear() {
		Student s = new Student("Gavin Frank", 2024, 10, true, false, false, "Olin", "Business", "CS", "Psych", "NA");
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
	}
	
	@Test
	public void testChangeGradYear() {
		int gradYear = s.getGradYear();
		assertEquals(2024, gradYear);
		gradYear = s.changeGradYear(2025);
		assertEquals(2025, gradYear);
	}
	
	@Test
	public void testinitYear() {
		int initYear = s.getInitYear();
		assertEquals(10, initYear);
	}

	@Test
	public void testIsActive() {
		boolean isActive = s.getIsActive();
		assertEquals(true, isActive);
	}
	
	//checks to see whether the member joined in the Fall
	@Test
	public void testisFall() {
		boolean isFall = s.getIsFall();
		assertEquals(false, isFall);
	}
	
	@Test
	public void testVoteEligible() {
		boolean voteEligible = s.getIsEligible();
		assertEquals(false, voteEligible);
	}
	
	@Test
	public void testSchoolName() {
		String school = s.getSchool();
		assertEquals("Olin", school);
	}
	
	@Test
	public void testChangeSchool() {
		String school = s.getSchool();
		assertEquals("Olin", school);
		school = s.changeSchool("Artsci");
		assertEquals("Artsci", school);
	}
	
	@Test 
	public void testMajors() {
		List<String> fieldOfStudy = s.getMajors();
		String[] output = {"Business", "CS"};
		assertArrayEquals(output, fieldOfStudy.toArray());
	}
	
	@Test 
	public void testMinors() {
		List<String> fieldOfStudy = s.getMinors();
		String[] output = { "Psych", "NA"};
		assertArrayEquals(output, fieldOfStudy.toArray());
	}
	
	@Test
	 public void testAddPoints() {
		s.addPoints(2);
		assertEquals(2, s.getPoints());
		s.addPoints(8);
		assertEquals(10, s.getPoints());
	}
	
	@Test
	public void testWillNotBeTrialed() {
		s.addPoints(65);
		boolean sTrialStatus = s.willBeTrialed();
		assertEquals(false, sTrialStatus);
	}	
	
	@Test
	public void testWillBeTrialed() {
		s.addPoints(45);
		boolean sTrialStatus = s.willBeTrialed();
		assertEquals(true, sTrialStatus);
	}
	
	@Test
	public void testToString() {
		String studentInfo = s.toString().replace("\n", "");
		String finalString = "Name: Gavin Frank"
		+ "School: Olin"
		+ "Majors: [Business, CS]"
		+ "Minors: [Psych, NA]"
		+ "Graduation Year: 2024"
		+ "Initiation Year: 10"
		+ "Brother is active: true"
		+ "Brother joined in the fall: false"
		+ "Brother is eligible for bid vote: false";
		assertEquals(studentInfo, finalString);
		
	}
	
	@Test
	public void testGetResumeNoEntries() {
		List<Role> r = s.getResume();
		List<Role> testResume = new ArrayList<Role>();
		assertEquals(r, testResume);
	}
	
	@Test
	public void testResumePrint() {
		s.addResumeItem(company, "CEO", LocalDate.of(2020, 1, 8));
		s.addResumeItem(company, "test2", LocalDate.of(2020, 1, 8));
		
		String resume = s.printResume().replace("\n", "");
		String output = "Company: Apple"
				+ "Title: CEO"
				+ "Started: 2020-01-08"
				+ "Company: Apple"
				+ "Title: test2"
				+ "Started: 2020-01-08";
		assertEquals(resume, output);
	}
	
	@Test
	public void testAddResumeItem() {
		s.addResumeItem(company, "CEO", LocalDate.of(2020, 1, 8));
		List<Role> r = s.getResume();
		
		List<Role> testResume = new ArrayList<Role>();
		testResume.add(currentRole);
		
		assertEquals(r.toString(), testResume.toString());
	}

}
