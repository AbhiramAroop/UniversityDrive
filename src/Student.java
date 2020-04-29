/**
 * This Class creates a student for units and university to use, it stores a student
 * name, family name and a student ID to represent an individual unique student.
 * 
 * @author Abhiram Aroop
 *
 */

public class Student {
	private String studentID; //String can store both letters and numbers, make more meaningful IDs
	//Integers can be easier to keep track of and generate 
	private String givenName;
	private String familyName; 
	// People may have different First names than given names

/**
 * This method is used to set the studentID of the student.
 * 
 * @param newStudentID a string representing the ID of the student
 */

	public Student(String newStudentID) {
		this.studentID = newStudentID;
	}
	
/**
 * This method is used to set the student's given name, family name and student ID upon
 * creation of this student.
 * 
 * @param newStudentID a string representing the student's ID
 * @param newGivenName a string representing the student's First Name
 * @param newFamilyName a string representing the student's Last Name
 */
	
	public Student(String newStudentID, String newGivenName, String newFamilyName) {
		super();
		this.studentID = newStudentID;
		this.givenName = newGivenName;
		this.familyName = newFamilyName;
	}

/**
 * This method is used to change the given name of a student
 * 
 * @param givenName a string that the current student's given name need to be changed to.
 */

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
/**
* This method is used to change the family name of a student
* 
* @param familyName a string that the current student's family name need to be changed to.
*/

	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
/**
 * This method proves details of the student such as their ID, first and last name 
 * 
 * @return a string representing the details of the student as stated above
 */
	
	public String description() {
		return studentID + ' ' + givenName + ' ' + familyName;
	}
	
/**
 * This method is used to obtain the Student ID for a particular student
 * 
 * @return a string representing the ID of the student
 */
	
	public String getStudentID() {
		return studentID;
	}
	
	
	

	
}
