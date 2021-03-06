	package src;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private int gradYear;
	private int initYear;
	private int points;
	
	private boolean isActive;
	private boolean isFall;
	private boolean voteElgible;
	
	private String school;
	private List<String> majors;
	private List<String> minors;	
	private List<Role> resume;
	
	public Student(String name, int gradYear, int initYear, boolean isActive, boolean isFall, boolean voteElgible, String school, String major1, String major2, String minor1, String minor2) {
		resume = new ArrayList<Role>();
		this.majors = new ArrayList<String>();
		this.minors = new ArrayList<String>();
		
		this.name = name;
		this.gradYear = gradYear;
		this.initYear = initYear;
		this.isActive = isActive;
		this.isFall = isFall;
		this.voteElgible = voteElgible;
		this.school = school;
		this.points = 0;
		this.majors.add(major1);
		this.majors.add(major2);
		this.minors.add(minor1);
		this.minors.add(minor2);
	}
	
	public Student(String name, int gradYear, int initYear, boolean isActive, boolean isFall, boolean voteElgible, String school, List<String> majors, List<String> minors) {
		resume = new ArrayList<Role>();
		
		this.name = name;
		this.gradYear = gradYear;
		this.initYear = initYear;
		this.isActive = isActive;
		this.isFall = isFall;
		this.voteElgible = voteElgible;
		this.school = school;
		this.points = 0;
		this.majors = majors;
		this.minors = minors;
	}
	
	public Student(String name, int gradYear, int initYear, boolean isActive, boolean isFall, boolean voteElgible, String school) {
		resume = new ArrayList<Role>();
		this.majors = new ArrayList<String>();
		this.minors = new ArrayList<String>();
		
		this.name = name;
		this.gradYear = gradYear;
		this.initYear = initYear;
		this.isActive = isActive;
		this.isFall = isFall;
		this.voteElgible = voteElgible;
		this.school = school;
		this.points = 0;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public String getName() {
		return this.name;
	}
	public int getGradYear() {
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
	
	public List<String> getMajors(){
		return this.majors;
	}
	
	public List<String> getMinors(){
		return this.minors;
	}
	
	public int addPoints(int newPoints) {
		this.points += newPoints;
		return this.points;
	}

	public int subtractPoints(int newPoints) {
		this.points -= newPoints;
		return this.points;
	}
	
	public int changeGradYear(int newGradYear) {
		this.gradYear = newGradYear;
		return this.gradYear;
	}
	
	public String changeSchool(String newSchool) {
		this.school = newSchool;
		return this.school;
	}
	
	public List<String> removeMajor(String removeMajor){
		this.majors.remove(removeMajor);
		return this.majors;
	}
	
	public List<String> removeMajor(int majorIndex){
		this.majors.remove(majorIndex);
		return this.majors;
	}
	
	public List<String> removeMinor(String removeMinor){
		this.minors.remove(removeMinor);
		return this.minors;
	}
	
	public List<String> removeMinor(int minorIndex){
		this.minors.remove(minorIndex);
		return this.minors;
	}
	
	public boolean changeActiveStatus(boolean isActive) {
		this.isActive = isActive;
		return this.isActive;
	}
	
	public boolean changeCanVote(boolean canVote) {
		this.voteElgible = canVote;
		return this.voteElgible;
	}
	
	public boolean willBeTrialed() {
		if (this.points <= 60) {
			return true;
		}
		return false;
	}
	
	public void displayAllInfo() {
		System.out.println("Name: " + this.getName());
		System.out.println("School: " + this.getSchool());
		System.out.println("Majors: " + this.majors.toString());
		System.out.println("Minors: " + this.minors.toString());
		System.out.println("Graduation Year: " + this.getGradYear());
		System.out.println("Initiation Year: " + this.getInitYear());
		System.out.println("Brother is active: " + this.getIsActive());
		System.out.println("Brother joined in the fall: " + this.getIsFall());
		System.out.println("Brother is eligible for bid vote: " + this.getIsEligible());
		System.out.println("Resume: \n" + this.printResume());
	}
	
	@Override
	public String toString() {
		String finalString = "Name: " + this.getName() + "\nSchool: " + this.getSchool() + "\nMajors: " + this.majors.toString() + "\nMinors: " + this.minors.toString();
		finalString = finalString + "\nGraduation Year: " + this.getGradYear() + "\nInitiation Year: " + this.getInitYear() + "\nBrother is active: " + this.getIsActive();
		finalString = finalString + "\nBrother joined in the fall: " + this.getIsFall() + "\nBrother is eligible for bid vote: " + this.getIsEligible() + "\nResume: " + this.printResume() + "\n";
		return finalString;
	}
	
	
	public List<Role> getResume() {
		return this.resume;
	}
	
	public String printResume() {
		String result = "";
		for(int i = 0; i<this.resume.size(); i++) {
			if(i == 0) {
				result = this.getResumeItem(i).toString(); 				
			}
			else {
				result = result + "\n" + this.getResumeItem(i); 
			}
		}
		return result;
	}
	
	public Role getResumeItem(int jobNumber) {
		return this.resume.get(jobNumber);
	}
	
	public List<Role> addResumeItem(Company roleCompany, String roleTitle, int roleDateStarted) {
		Role newRole = new Role(roleCompany, roleTitle, roleDateStarted);
		this.resume.add(newRole);
		return this.resume;
	}
	
	public List<Role> addResumeItem(Company roleCompany, String roleTitle, int roleDateStarted, int roleDateEnded) {
		Role newRole = new Role(roleCompany, roleTitle, roleDateStarted, roleDateEnded);
		this.resume.add(newRole);
		return this.resume;
	}
	
	public List<Role> removeRole(Role roleRemove) {
		this.resume.remove(roleRemove);
		return this.resume;
	}
	
	public List<Role> removeRole(int roleIndex) {
		this.resume.remove(roleIndex);
		return this.resume;
	}
	
	public List<Role> removeRole(String companyName) {
		for(int i=0; i<this.resume.size(); i++) {
			if(this.resume.get(i).getCompany().getName().equals(companyName)) {
				this.resume.remove(i);
			}
		}
		return this.resume;
	}
	
	
	public List<Role> endResumeRoll(int roleIndex, int endDate) {
		this.resume.get(roleIndex).endRoll(endDate);
		return this.resume;
	}
	
	public List<Role> endResumeRoll(String companyName, int endDate) {
		for(int i=0; i<this.resume.size(); i++) {
			if(this.resume.get(i).getCompany().getName().equals(companyName)) {				
				this.resume.get(i).endRoll(endDate);
				return this.resume;
			}
		}
		return null;
	}
	
	public List<Role> updateResumeRollTitle(int roleIndex, String newTitle) {
		this.resume.get(roleIndex).updateTitle(newTitle);
		return this.resume;
	}
	
	public List<Role> updateResumeRollTitle(String companyName, String newTitle) {
		for(int i=0; i<this.resume.size(); i++) {
			if(this.resume.get(i).getCompany().getName().equals(companyName)) {				
				this.resume.get(i).updateTitle(newTitle);
				return this.resume;
			}
		}
		return null;
	}
	
}
