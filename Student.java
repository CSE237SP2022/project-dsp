public class Student {
	
	private String name;
	private int gradYear;
	private int initYear;
	
	private boolean isActive;
	private boolean isFall;
	private boolean voteElgible;
	
	private String school;
	private String major1;
	private String major2;
	private String minor1;
	private String minor2;
	
	
	public Student(String name, int gradYear, int initYear, boolean isActive, boolean isFall, boolean voteElgible, String school, String major1, String major2, String minor1, String minor2) {
		this.name = name;
		this.gradYear = gradYear;
		this.initYear = initYear;
		this.isActive = isActive;
		this.isFall = isFall;
		this.voteElgible = voteElgible;
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
	
	public boolean getIsElgible() {
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
	
}
