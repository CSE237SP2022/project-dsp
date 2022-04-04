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
		assertEquals(checkName, "Apple");
	}
	
	@Test
	public void testGetIndustry() {
		String checkName = Apple.getIndustry();
		assertEquals(checkName, "Tech");
	}
	
	@Test
	public void testGetDescription() {
		String checkName = Apple.getDescription();
		assertEquals(checkName, "Makes iPhones");
	}
	
	@Test
	public void testGetNumStudents() {
		int checkName = Apple.getNumStudents();
		assertEquals(checkName, 10);
	}
	
	@Test
	public void testUpdateName() {
		String checkName = Apple.getName();
		assertEquals(checkName, "Apple");
		
		Apple.updateName("Google");
		checkName = Apple.getName();
		assertEquals(checkName, "Google");
	}
	
	@Test
	public void testUpdateIndustry() {
		String checkName = Apple.getIndustry();
		assertEquals(checkName, "Tech");
		
		Apple.updateIndustry("Finance");
		checkName = Apple.getIndustry();
		assertEquals(checkName, "Finance");
	}
	
	@Test
	public void testUpdateDescription() {
		String checkName = Apple.getDescription();
		assertEquals(checkName, "Makes iPhones");

		Apple.updateDescription("Makes airpods");
		checkName = Apple.getDescription();
		assertEquals(checkName, "Makes airpods");
	}
	
	@Test
	public void testJoinCompany() {
		int checkName = Apple.getNumStudents();
		assertEquals(checkName, 10);
		
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

}
