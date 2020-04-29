import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class creates the structure for a "unit" for the University Class, It has a unique Name and 
 * Code. Students can enroll into the unit VIA University, there are also Assessments and
 * total marks stored in this Class. 
 * @author Abhiram Aroop
 *
 */

public class Unit {
	private String unitCode;
	private String unitName;
	private ArrayList<String> enrolledStudents = new ArrayList<String>(); //ArrayList doesn't have fixed size on creation
	private AssessmentScheme AssessmentSchemeUnit = new AssessmentScheme();
	private HashMap<String, Float> totalMarks = new HashMap<String, Float>();
	
/**
 * This method returns the Name and Code of this particular unit.
 * 
 * @return unitCode + unitName a string that combines the unit code and unit name.
 */
	
	public String description() {
		return unitCode + " " + unitName;
	}
	
/**
 * This method sets the unit code and name given inputs of strings
 * 
 * @param unitCode a string representing the unitCode
 * @param unitName a string representing the unit's name
 */

	public Unit(String unitCode, String unitName) {
		super();
		this.unitCode = unitCode;
		this.unitName = unitName;
	}

/**
 * This method can be called in order to obtain the unit code for the unit
 * 
 * @return unitCode a string representing the unit's code
 */

	public String getUnitCode() {
		return unitCode;
	}

/**
 * This method takes input a string and sets it as the unit's code
 * 
 * @param unitCode a string representing the unit's code
 */

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * This method can be called in order to obtain the unit's name for the unit
	 * 
	 * @return unitName a string representing the unit's name
	 */
	
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * This method takes input a string and sets it as the unit's name
	 * 
	 * @param unitName a string representing the unit's name
	 */

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
/**
 * This method add a student in the form of StudentID into the enrolledStudents ArrayList
 * 
 * @param newStudentID a string representing the Student's ID
 */
	
	public void enrolStudent(String newStudentID) {
		enrolledStudents.add(newStudentID);
	}
	
/**
 * This method is used to obtain the list of students who are enrolled in
 * the unit.
 * 
 * @param allStudents a HashMap containing the Student (Student) and the StudentIDs (String)
 * @return students an Array representing students enrolled in unit 
 */
	

	public Student[] getStudents(HashMap<String,Student> allStudents) {
		Student[] students = new Student[enrolledStudents.size()];		
		
		for (int i = 0; i < totalStudent(); i++ ) {
			students[i] = allStudents.get(enrolledStudents.get(i));
		}
		return students;
		
	}
	
/**
 * This method find the total number of students that are enrolled in the unit
 * 
 * @return a integer representing the number of students who are enrolled in the unit
 */
	
	public int totalStudent() {
		return enrolledStudents.size();
	}
	
/**
 * This method sets the assessment scheme for the unit
 * 
 * @param newAssessment an ArrayList of assessments representing the assessment scheme
 */
	
	public void setAssessment(ArrayList<Assessment> newAssessment) {		
		AssessmentSchemeUnit.setAssessments(newAssessment);
				
	}
	
/**
 * This method is used to obtain the assessment scheme for the unit
 * 
 * @return an ArrayList of Assessments
 */
	
	public ArrayList<Assessment> getAssessmentScheme() {
		return AssessmentSchemeUnit.getAssessments();
	}
	
/**
 * This method is used check whether the students have completed all the
 * assessments in the unit
 * 
 * @param newStudent a student object representing the student that needs to be checked
 * @return a boolean, true if the assessments have been completed, else false 
 */
	
	public boolean checkStudentCompletion(String newStudent) {
		int nAssessment = AssessmentSchemeUnit.getAssessments().size();
		
		for (int i = 0; i < nAssessment; i++) {
			if (AssessmentSchemeUnit.getAssessments().get(i).checkStudentAssessment(newStudent) == false) {
				return false;
				
			}
		}
		return true;
		
	}
	
/**
 * This method is used compute the total marks of a particular student
 * 
 * @param newStudent a student object representing the student who's total marks needs to be computed.
 */
	
	public void setTotalMark(Student newStudent) {
		if (enrolledStudents.contains(newStudent.getStudentID()) == true) {
			if (checkStudentCompletion(newStudent.getStudentID()) == true) {
				float totalMark = 0;
				int nAssessment = AssessmentSchemeUnit.getAssessments().size();
				
				for (int i = 0; i < nAssessment; i++) {
					totalMark = totalMark +  ((float) AssessmentSchemeUnit.getAssessments().get(i).getScore(newStudent)) * ((float) AssessmentSchemeUnit.getAssessments().get(i).getWeight() / 100);
					
				}
				totalMarks.put(newStudent.getStudentID(), totalMark);
			}
			else {
				System.out.println("Student " + newStudent.getStudentID() + " has not completed all Assessments!");
			}
			
			
		}
		else {
			System.out.println("Student " + newStudent.getStudentID() + " not in Unit: " + getUnitName());
		}
	}
	
/**
 * This method is used to obtain the total marks of a student across all assessments
 * 
 * @param newStudent a student object who's marks need to be obtained
 * @return a float representing the overall marks of the student
 */
	
	public Float getTotalMark(String newStudent) {
		if (totalMarks.containsKey(newStudent) == true) {
			return totalMarks.get(newStudent);
		}
		return (float) 0;
	}
	
	public ArrayList<String> getStudentID() {
		ArrayList<String> studentsCopy= new ArrayList<String>(enrolledStudents);
		return studentsCopy;
	}
	
	public boolean isPass(String studentID) {
		
		boolean pass = false;
		if (checkStudentCompletion(studentID) == true) {
			if (getTotalMark(studentID) >= 50) {
			
				pass = true;
			}
		}
		
		return pass;
		
	}
	
}
	
		

