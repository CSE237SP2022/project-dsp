package src.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Company;

public class CompanyTests {

private Company Apple;
	
	@Before
	public void setup() {
			Apple = new Company("Apple", "Tech", "Makes iPhones", 10);
		}
	
	@Test
	public void testGetName() {
		String checkName = Apple.getName();
		assertEquals("Apple", checkName);
	}
	
	@Test
	public void testGetIndustry() {
		String checkName = Apple.getIndustry();
		assertEquals("Tech", checkName);
	}
	
	@Test
	public void testGetDescription() {
		String checkName = Apple.getDescription();
		assertEquals("Makes iPhones", checkName);
	}
	
	@Test
	public void testGetNumStudents() {
		int checkName = Apple.getNumStudents();
		assertEquals(10, checkName);
	}
	
	@Test
	public void testUpdateName() {
		String checkName = Apple.getName();
		assertEquals("Apple", checkName);
		
		Apple.updateName("Google");
		checkName = Apple.getName();
		assertEquals("Google", checkName);
	}
	
	@Test
	public void testUpdateIndustry() {
		String checkName = Apple.getIndustry();
		assertEquals("Tech", checkName);
		
		Apple.updateIndustry("Finance");
		checkName = Apple.getIndustry();
		assertEquals("Finance", checkName);
	}
	
	@Test
	public void testUpdateDescription() {
		String checkName = Apple.getDescription();
		assertEquals("Makes iPhones", checkName);

		Apple.updateDescription("Makes airpods");
		checkName = Apple.getDescription();
		assertEquals("Makes airpods", checkName);
	}
	
	@Test
	public void testJoinCompany() {
		int checkName = Apple.getNumStudents();
		assertEquals(10, checkName);
		
		int returnV = Apple.joinCompany();
		checkName = Apple.getNumStudents();
		
		assertEquals(checkName, returnV, 11);
	}
	
	@Test
	public void testLeaveCompany() {
		int checkName = Apple.getNumStudents();
		assertEquals(checkName, 10);
		
		int returnV = Apple.leaveCompany();
		checkName = Apple.getNumStudents();
		
		assertEquals(checkName, returnV, 9);
	}
	
	@Test
	public void testToString() {
		String output = Apple.toString().replace("\n", "");
		String result = "Company Name: Apple" + "Industry: Tech" +  "Description: Makes iPhones" + "Student Count: 10";
		assertEquals(result, output);
	}

}
