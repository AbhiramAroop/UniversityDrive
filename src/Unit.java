import java.util.ArrayList;

public class Unit {
	private String unitCode;
	private String unitName;
	private ArrayList<Student> students = new ArrayList<Student>(); //ArrayList doesn't have fixed size on creation
	
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
	
	public void enrolStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public void printStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).description());
		}
	}
	
		
}
