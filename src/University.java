//To list all student without duplicates: create an ArrayList to store all students,
//use a loop and if-statement to iterate and check for duplicate students
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class University {
	
	private HashMap<String, Student> students = new HashMap<String, Student>();
	
	//Reads input
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
		
		System.out.println("Thank you for using Java University");	
		
	}
		
	//Creates students by taking input from user
	private void createStudents() {
				
		for (int i = 0; i < units.size();i++) {
			int nStudents = Integer.parseInt(readString("Enter Number of Students for unit " + units.get(i).description() + ":"));
			
			for (int j = 0; j < nStudents; j++) {
				String id = readString("Enter Student ID: ");
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
	//Creates 3 units
	public void createUnits() {
		units.add(new Unit("FIT2019","Object-Orientated 1"));
		units.add(new Unit("FIT2029","Object-Orientated 2"));
		units.add(new Unit("FIT2039","Object-Orientated 3"));

	}
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

	public void admitStudent(Student newstudent) {
		students.put(newstudent.getStudentID(),newstudent);
	}
	
	public Student getStudent(String newStudentID) {
		return students.get(newStudentID);
	}
	
	public void createAssessment() {
		Assessment newAssignment = new Assignment(20, "Assignment 1");
		units.get(0).addAssessment(newAssignment);
		Assessment newAssignment2 = new Assignment(20, "Assignment 2");
		units.get(0).addAssessment(newAssignment2);
		
		Assessment newExam = new Exam(180, 60);
		units.get(0).addAssessment(newExam);
		//TEST
		System.out.println(units.get(0).getAssessmentScheme());
		
				
		
	}
	
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
	
	public void displayTotalMark() {
		Student newStudent = units.get(0).getStudents(students)[0];
		units.get(0).setTotalMark(newStudent);
		System.out.println("Total Mark for " + newStudent.getStudentID() + " in unit " + units.get(0).getUnitCode() + " is " + units.get(0).getTotalMark(newStudent));
		
	}
	
	
		
	}
	


