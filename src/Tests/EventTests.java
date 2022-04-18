package src.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Event;

public class EventTests {

	private Event e;
	
	@Before
	public void setup() {
			e = new Event("11/22", "Bid Vote", 10, true);
		}
	
	@Test
	public void testDate() {
		String date = e.getDate();
		assertEquals("11/22", date);
	}
	
	@Test
	public void testNameOfEvent() {
		String name = e.getName();
		assertEquals("Bid Vote", name);
	}
	
	@Test
	public void testPoints() {
		int points = e.getPoints();
		assertEquals(10, points);
	}
	
	@Test
	public void testBidVoteRequired() {
		boolean isRequired = e.isRequired();
		assertEquals(true, isRequired);
	}

}