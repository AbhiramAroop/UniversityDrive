//To list all student without duplicates: create an ArrayList to store all students,
//use a loop and if-statement to iterate and check for duplicate students
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class University {
	
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
				
				units.get(i).enrolStudent(newStudent);
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
			units.get(i).printStudents();
			System.out.println();
			}
			
		}
	
		
	}
	


