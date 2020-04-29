//To list all student without duplicates: create an ArrayList to store all students,
//use a loop and if-statement to iterate and check for duplicate students
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implements an University system that creates students, units and assessments
 * and  
 * 
 * @author Abhiram Aroop
 *
 */

public class University {
	
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	
/**
 * This method reads an input string entered from the user and returns it as a string.
 * 
 * @param prompt a string to print at the start of the function so that the user knows what to input
 * @return s a string representing the input of the user
 */
	private String readString(String prompt) {
		System.out.print(prompt);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	private ArrayList<Unit> units = new ArrayList<Unit>(); //ArrayList to hold all units

/**
 * 
 * This method calls a series of other functions and acts like the main function for 
 * this class.
 * 
 */

	//Prints messages
	public void printStatus() {
		System.out.println("Welcome to Java University");
		System.out.println();
		
		createUnits();
		createStudents();
		displayUnits();
		createAssessment();
		testStudentMarks();
		displayTotalMark();
		testCourse();
		
		System.out.println("Thank you for using Java University");	
		
	}
		
/**
 * 
 * This method creates students for a particular unit based on the input of the 
 * user and adds them into the student arrayList. 
 * 
 */
	//Creates students by taking input from user
	private void createStudents() {
				
		for (int i = 0; i < units.size();i++) {
			int nStudents = Integer.parseInt(readString("Enter Number of Students for unit " + units.get(i).description() + ":"));
			
			for (int j = 0; j < nStudents; j++) {
				String id = readString("Enter Student ID: ");
				try {
					checkStudentID(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String fName = readString("Enter Student's Given Name: ");
				String lName = readString("Enter Student's Family Name: ");
				
				Student newStudent = new Student(id);
				newStudent.setFamilyName(lName);
				newStudent.setGivenName(fName);
			
				admitStudent(newStudent);
				units.get(i).enrolStudent(id);
			}
			
		}
		
	}
	
/**
 * This method creates units and adds them into the units arrayList.
 */
	
	//Creates 3 units
	public void createUnits() {
		units.add(new Unit("FIT2019","Object-Orientated 1"));
		units.add(new Unit("FIT2029","Object-Orientated 2"));
		units.add(new Unit("FIT2039","Object-Orientated 3"));

	}
	
/**
 * This method prints details of students and details of the particular units that
 * the students are part of. 
 */
	
	//Displays Units and Students enrolled in them
	public void displayUnits() {
		for (int i = 0;i < units.size(); i++ ) {
			System.out.println(units.get(i).description() + '\n' + "Enrolled Students:");
			for (int j = 0; j < units.get(i).totalStudent(); j++) {
				System.out.println(units.get(i).getStudents(students)[j].description());
			}
			units.get(i).getStudents(students);
			System.out.println();
			}
			
		}
/**
 * This method add a new student to the arrayList of students
 * @param newstudent A student object that needs to be added into the University.
 */

	public void admitStudent(Student newstudent) {
		students.put(newstudent.getStudentID(),newstudent);
	}
	
/**
 * This method is used to get the student object given a Student ID.
 * @param newStudentID a string suggesting the Student ID of a student already in students arrayList.
 * @return The student object given the studentID of the student.
 */
	
	public Student getStudent(String newStudentID) {
		return students.get(newStudentID);
	}
	
/**
 * This method is one used for testing the Assessment Abstract Class and AssessmentScheme Class.
 */
	
	public void createAssessment() {
		
		Assessment newAssignment = new Assignment(20, "Assignment 1");
		
		Assessment newAssignment2 = new Assignment(20, "Assignment 2");
		
		Assessment newExam = new Exam(180, 60);
		
		ArrayList<Assessment> allAssessment= new ArrayList<Assessment>();
		allAssessment.add(newAssignment);
		allAssessment.add(newAssignment2);
		allAssessment.add(newExam);
		
		
		units.get(0).setAssessment(allAssessment);
		units.get(1).setAssessment(allAssessment);
		units.get(2).setAssessment(allAssessment);
		//TEST
		System.out.println(units.get(0).getAssessmentScheme());
		
		
	}

/**
 * This method is used for testing the Mark Class.
 */
	
	public void testStudentMarks() {
		Student newStudent = units.get(0).getStudents(students)[0];
		
		Mark marks = new Mark();
		marks.setGrade(80, "Good Job!");
		units.get(0).getAssessmentScheme().get(0).setMark(newStudent, marks);
		
		Mark marks2 = new Mark();
		marks2.setGrade(50, "Good Job!");
		units.get(0).getAssessmentScheme().get(1).setMark(newStudent, marks2);
		
		Mark marks3 = new Mark();
		marks3.setGrade(70, "Good Job!");
		units.get(0).getAssessmentScheme().get(2).setMark(newStudent, marks3);
		
		System.out.println("1) " + units.get(0).getAssessmentScheme().get(0).getMark(newStudent));
		System.out.println("2) " + units.get(0).getAssessmentScheme().get(1).getMark(newStudent));
		System.out.println("3) " + units.get(0).getAssessmentScheme().get(2).getMark(newStudent));
	
	}
	
/**
 * This method is used to print the total marks for a particular student in a particular unit.
 */
	
	public void displayTotalMark() {
		Student newStudent = units.get(0).getStudents(students)[0];
		units.get(0).setTotalMark(newStudent);
		System.out.println("Total Mark for " + newStudent.getStudentID() + " in unit " + units.get(0).getUnitCode() + " is " + units.get(0).getTotalMark(newStudent.getStudentID()));
		
	}
/**
 * This method throws and exception if there not 8 chars in an input studentID.
 * 
 * @param ID a string representing the ID of a student.
 * @throws Exception a message suggesting that the length of input is incorrectly entered.
 */
	
	public static void checkStudentID(String ID) throws Exception {
		if (ID.length() != 8) {
			throw new Exception("Student ID must be 8 characters!");
		}
	}

/**
 * This method conducts different test cases for the Course class to meet its requirements.
 * 
 */
	public void testCourse() {
		
		//Units 0 and 1 core
		Course course1 = new Course("Computer Science",units.get(0));
		course1.addCoreUnits(units.get(1));
		course1.setNElectives(1);
		
		//Units 0 and 1 core 
		Course course2 = new Course("Science",units.get(0));
		course2.addCoreUnits(units.get(1));
		
		//Unit 2 core
		Course course3 = new Course("Engineering",units.get(2));
		
		
		Student student1 = new Student("test1234","Jeff","Jimmy");
		Student student2 = new Student("test0000","Cindy","Jimmy");
		Student student3 = new Student("test9999","Alex","Jimmy");
		Student student4 = new Student("test1212","John","Jimmy");
		
		course1.addStudent(student1.getStudentID());
		course1.addStudent(student2.getStudentID());
		course2.addStudent(student2.getStudentID());
		course3.addStudent(student3.getStudentID());
		
		//First two students in first unit
		units.get(0).enrolStudent(student1.getStudentID());
		units.get(0).enrolStudent(student2.getStudentID());
				
		//First two student in second unit
		units.get(1).enrolStudent(student1.getStudentID());
		units.get(1).enrolStudent(student2.getStudentID());
		
		units.get(2).enrolStudent(student1.getStudentID());
		units.get(2).enrolStudent(student3.getStudentID());
		units.get(2).enrolStudent(student4.getStudentID());
		
		Mark marks = new Mark();
		marks.setGrade(80, "Good Job!");
		units.get(0).getAssessmentScheme().get(0).setMark(student1, marks);
		units.get(0).getAssessmentScheme().get(0).setMark(student2, marks);
		units.get(1).getAssessmentScheme().get(0).setMark(student1, marks);
		units.get(2).getAssessmentScheme().get(0).setMark(student1, marks);
		units.get(2).getAssessmentScheme().get(0).setMark(student3, marks);
		
		Mark marks2 = new Mark();
		marks2.setGrade(50, "Good Job!");
		units.get(0).getAssessmentScheme().get(1).setMark(student1, marks2);
		units.get(0).getAssessmentScheme().get(1).setMark(student2, marks2);
		units.get(1).getAssessmentScheme().get(1).setMark(student1, marks2);
		units.get(2).getAssessmentScheme().get(1).setMark(student1, marks);
		units.get(2).getAssessmentScheme().get(1).setMark(student3, marks2);
		
		Mark marks3 = new Mark();
		marks3.setGrade(70, "Good Job!");
		units.get(0).getAssessmentScheme().get(2).setMark(student1, marks3);
		units.get(1).getAssessmentScheme().get(2).setMark(student1, marks3);
		units.get(2).getAssessmentScheme().get(2).setMark(student1, marks);
		units.get(2).getAssessmentScheme().get(2).setMark(student3, marks3);
		
		
		units.get(0).setTotalMark(student1);
		units.get(1).setTotalMark(student1);
		units.get(2).setTotalMark(student1);
		
		units.get(0).setTotalMark(student2);
		units.get(1).setTotalMark(student2);
		units.get(2).setTotalMark(student2);
		
		units.get(0).setTotalMark(student3);
		units.get(1).setTotalMark(student3);
		units.get(2).setTotalMark(student3);
		
		units.get(0).setTotalMark(student4);
		units.get(1).setTotalMark(student4);
		units.get(2).setTotalMark(student4);
		
		//Check all graduates
		System.out.println(course1.graduates());
		System.out.println(course2.graduates());
		System.out.println(course3.graduates());
		
		//results should be student1 = pass course1, student3 = pass course 3
		
		
		//TESTING FOR CORE UNITS
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		//Testing Unit1
		
		System.out.println("The courses in which Unit 1 is a core unit are: " + checkCoreUnits(units.get(0)));
		
		
	
	}

/**
 * This method checks the number of courses where the input unit is a core unit
 * @param currentUnit a Unit object that is the unit needing to be checked as a core unit for courses
 * @return coreUnits an ArrayList which contains all the course names in which the unit is a core
 * 		   unit of.
 */
	public ArrayList<String> checkCoreUnits(Unit currentUnit) {
		ArrayList<String> coreUnits = new ArrayList<String>();
		
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCoreUnits().contains(currentUnit)) {
				coreUnits.add(courses.get(i).getCourseName());
			}
		}
		
		
		return coreUnits;
	}
	
}


