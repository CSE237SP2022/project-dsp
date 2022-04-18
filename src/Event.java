package src;


public class Event {
	private String dateOfEvent;
	private String nameOfEvent;
	private int pointsForEvent;
	private boolean isRequired;

	public Event(String dateOfEvent, String nameOfEvent, int pointsForEvent, boolean isRequired) {
		this.dateOfEvent = dateOfEvent;
		this.nameOfEvent = nameOfEvent;
		this.pointsForEvent = pointsForEvent;
		this.isRequired = isRequired;
	}

	public String getDate() {
		return this.dateOfEvent;
	}
	
	public String getName() {
		return this.nameOfEvent;
	}
	
	public int getPoints() {
		return this.pointsForEvent;
	}
	
	public boolean isRequired() {
		return this.isRequired;
	}
}


