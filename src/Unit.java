import java.util.ArrayList;
import java.util.HashMap;

public class Unit {
	private String unitCode;
	private String unitName;
	private ArrayList<String> enrolledStudents = new ArrayList<String>(); //ArrayList doesn't have fixed size on creation
	private AssessmentScheme AssessmentSchemeUnit = new AssessmentScheme();
	private HashMap<Student, Float> totalMarks = new HashMap<Student, Float>();
	
	public String description() {
		return unitCode + " " + unitName;
	}

	public Unit(String unitCode, String unitName) {
		super();
		this.unitCode = unitCode;
		this.unitName = unitName;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public void enrolStudent(String newStudentID) {
		enrolledStudents.add(newStudentID);
	}
	
	public Student[] getStudents(HashMap<String,Student> allStudents) {
		Student[] students = new Student[enrolledStudents.size()];		
		
		for (int i = 0; i < totalStudent(); i++ ) {
			students[i] = allStudents.get(enrolledStudents.get(i));
		}
		return students;
		
	}
	
	public int totalStudent() {
		return enrolledStudents.size();
	}
	
	public void addAssessment(Assessment newAssessment) {		
		AssessmentSchemeUnit.addAssessments(newAssessment);
				
	}
	
	public ArrayList<Assessment> getAssessmentScheme() {
		return AssessmentSchemeUnit.getAssessments();
	}
	
	public boolean checkStudentCompletion(Student newStudent) {
		int nAssessment = AssessmentSchemeUnit.getAssessments().size();
		
		for (int i = 0; i < nAssessment; i++) {
			if (AssessmentSchemeUnit.getAssessments().get(i).checkStudentAssessment(newStudent) == false) {
				return false;
				
			}
		}
		return true;
		
	}
	
	public void setTotalMark(Student newStudent) {
		if (enrolledStudents.contains(newStudent.getStudentID()) == true) {
			if (checkStudentCompletion(newStudent) == true) {
				float totalMark = 0;
				int nAssessment = AssessmentSchemeUnit.getAssessments().size();
				
				for (int i = 0; i < nAssessment; i++) {
					totalMark = totalMark +  ((float) AssessmentSchemeUnit.getAssessments().get(i).getScore(newStudent)) * ((float) AssessmentSchemeUnit.getAssessments().get(i).getWeight() / 100);
					
				}
				totalMarks.put(newStudent, totalMark);
			}
			else {
				System.out.println("Student not completed all Assessments!");
			}
			
			
		}
		else {
			System.out.println("Student not in Unit!");
		}
	}
	
	public Float getTotalMark(Student newStudent) {
		if (totalMarks.containsKey(newStudent) == true) {
			return totalMarks.get(newStudent);
		}
		return (float) 0;
	}
	
}
	
		

