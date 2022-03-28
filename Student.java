public class Student {
	
	private String name;
	private int gradYear;
	private int initYear;
	private int points;
	
	private boolean isActive;
	private boolean isFall;
	private boolean voteElgible;
	
	private String school;
	private String major1;
	private String major2;
	private String minor1;
	private String minor2;
	
	
	public Student(String name, int gradYear, int initYear, boolean isActive, boolean isFall, boolean voteEligible, String school, String major1, String major2, String minor1, String minor2) {
		this.name = name;
		this.gradYear = gradYear;
		this.initYear = initYear;
		this.points = 0;
		this.isActive = isActive;
		this.isFall = isFall;
		this.voteElgible = voteEligible;
		this.school = school;
		this.major1 = major1;
		this.major2 = major2;
		this.minor1 = minor1;
		this.minor2 = minor2;
	}
	public String getName() {
		return this.name;
	}
	public int getGradYear() {
		return this.gradYear;
	}
	
	public int changeGradYear(int newGradYear) {
		this.gradYear = newGradYear;
		return this.gradYear;
	}
	
	public int getInitYear() {
		return this.initYear;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public boolean getIsFall() {
		return this.isFall;
	}
	
	public boolean getIsEligible() {
		return this.voteElgible;
	}
	
	public String getSchool() {
		return this.school;
	}
	
	public String changeSchool(String newSchool) {
		this.school = newSchool;
		return this.school;
	}
	
	public String[] getMajorsMinors() {
		String[] majorsMinors= {this.major1, this.major2, this.minor1, this.minor2};
		return majorsMinors;
	}
	
	public void displayAllInfo() {
		System.out.println("Name: " + this.getName());
		System.out.println("School: " + this.getSchool());
		System.out.println("Majors/Minors: " + this.getMajorsMinors());
		System.out.println("Graduation Year: " + this.getGradYear());
		System.out.println("Initiation Year: " + this.getInitYear());
		System.out.println("Brother is active: " + this.getIsActive());
		System.out.println("Brother joined in the fall: " + this.getIsFall());
		System.out.println("Brother is eligible for bid vote: " + this.getIsEligible());
	}
	
}
