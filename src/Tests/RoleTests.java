package src.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Company;
import src.Role;

public class RoleTests {
	
	private Role currentRole;
	private Role previousRole;
	private Company Apple;
	
	@Before
	public void setup() {
			Apple = new Company("Apple", "Tech", "Makes iPhones");
			currentRole = new Role(Apple, "CEO", 2020);
			previousRole = new Role(Apple, "CEO", 2020, 2022);
		}

	@Test
	public void testGetCompany() {
		Company retrieveCompany = currentRole.getCompany();
		assertEquals(retrieveCompany, Apple);
	}
	
	@Test
	public void testGetTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "CEO");
	}
	
	@Test
	public void testGetActive() {
		boolean checkCurrent = currentRole.getActive();
		boolean checkPrevious = previousRole.getActive();
		
		assertEquals(checkCurrent, true);
		assertEquals(checkPrevious, false);
		assertNotEquals(checkCurrent, checkPrevious);
	}
	
	@Test
	public void testGetStartDate() {
		int checkStart = currentRole.getStartDate();
		assertEquals(checkStart, 2020);
	}
	
	@Test
	public void testGetEndDate() {
		int checkEndCurrent = currentRole.getEndDate();
		int checkEndPrev = previousRole.getEndDate();
		assertEquals(checkEndCurrent, 0);
		assertEquals(checkEndPrev, 2022);
	}
	
	@Test
	public void testTimeSpent() {
		long timeSpent = previousRole.getTimeSpent();
		assertEquals(timeSpent, 2);
	}
	
	@Test
	public void testUpdateTitle() {
		String retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "CEO");
		currentRole.updateTitle("COO");
		retrieveTitle = currentRole.getTitle();
		assertEquals(retrieveTitle, "COO");
	}
	
	@Test
	public void testEndRoll() {
		boolean checkCurrent = currentRole.getActive();
		int checkEnd = currentRole.getEndDate();
		assertEquals(checkCurrent, true);
		assertEquals(checkEnd, 0);
		
		currentRole.endRoll(2022);
		
		checkCurrent = currentRole.getActive();
		checkEnd = currentRole.getEndDate();
		assertEquals(checkCurrent, false);
		assertEquals(checkEnd, 2022);
	}
	
	@Test
	public void testToStringCurrent() {
		System.out.println(currentRole.toString());
		String output = currentRole.toString().replace("\n", "");
		String result = "Company: Apple"+ "Title: CEO" + "Started: 2020";
		assertEquals(output, result);
	}
}
