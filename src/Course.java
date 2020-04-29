import java.util.ArrayList;

/**
 * This class is used to support the concept of a course. It consists of core units that 
 * students have to pass in order to graduate 
 * 
 * @author Abhiram Aroop
 *
 */

public class Course {
	
	private String courseName;
	private int nElectives;
	private ArrayList<Unit> coreUnits = new ArrayList<Unit>();
	private ArrayList<String> students = new ArrayList<String>();

/**
 * This method is the initalises a name for a course and a core unit.
 * @param courseName a string representing the name of the course
 * @param coreUnit an Unit object representing the core unit of the course
 */
	public Course(String courseName, Unit coreUnit) {
		
		this.courseName = courseName;
		coreUnits.add(coreUnit);
		nElectives = 0;
	}

/**
 * This method gets the name of the course
 * @return courseName a string that represents the name of the course
 */
	public String getCourseName() {
		return courseName;
	}
	
/**
 * This method sets the name of the course
 * @param courseName a string that represents the given name of the course
 */

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
/**
 * This method gets the number of electives required to graduate this course.
 * @return nElectives an integer representing the number of electives
 */

	public int getnElectives() {
		return nElectives;
	}
	
/**
 * This method sets the number of electives required to graduate this course.
 * @param nElectives an integer representing the number of electives
 */

	public void setNElectives(int nElectives) {
		this.nElectives = nElectives;
	}

/**
 * This method adds more core units to the course
 * @param coreUnit an Unit object representing an additional core unit of the course
 */
	public void addCoreUnits(Unit coreUnit) {
		
		if (coreUnits.contains(coreUnit) == false) {
			coreUnits.add(coreUnit);
			
		}
	}
	
/**
 * This method gets the core units for the course
 * @return copyCoreUnits an ArrayList that contains the copy of the core units
 */
	
	public ArrayList<Unit> getCoreUnits() {
		
		ArrayList<Unit> copyCoreUnits = new ArrayList<Unit>(coreUnits);
		return copyCoreUnits;
	}
	
/**
 * This method adds a student to the course
 * @param newstudent a string representing the id of the student needing to be added
 */
	
	public void addStudent(String newstudent) {
		students.add(newstudent);

	}
	
/**
 * This method computes the students who are qualified to be graduates of this course
 * @return studentGraduates an ArrayList that contains strings representing student ID of students
 * 							that are eligible for graduation.
 */
	
	public ArrayList<String> graduates() {
		
		ArrayList<String> studentGraduates = new ArrayList<String>();
		
		for (int i = 0; i < students.size(); i++) {
			boolean pass = true;
			
			for (int j = 0; j < coreUnits.size(); j++) {
				if (coreUnits.get(j).getStudentID().contains(students.get(i)) == true) {
					if (coreUnits.get(j).isPass(students.get(i)) == false) {
						pass = false;
					}
					
				}
				else {
					pass = false;
				}
			}
			if (pass == true) {
				studentGraduates.add(students.get(i));
			}
			
		}
		
		return studentGraduates;
		
	}


}
