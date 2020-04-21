
public class Student {
	private String studentID; //String can store both letters and numbers, make more meaningful IDs
	//Integers can be easier to keep track of and generate 
	private String givenName;
	private String familyName; 
	// People may have different First names than given names
	
	public Student(String newStudentID) {
		this.studentID = newStudentID;
	}
	
	public Student(String newStudentID, String newGivenName, String newFamilyName) {
		super();
		this.studentID = newStudentID;
		this.givenName = newGivenName;
		this.familyName = newFamilyName;
	}


	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String description() {
		return studentID + ' ' + givenName + ' ' + familyName;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	
	

	
}
