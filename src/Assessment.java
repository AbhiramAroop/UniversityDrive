import java.util.HashMap;

public abstract class Assessment {
	protected int weight;
	protected HashMap<Student, Mark> results = new HashMap<Student, Mark>();

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (0 <= weight && 100 >= weight)  {
			this.weight = weight;

		}
	}
	
	public void setMark(Student newStudent, Mark marks) {
		this.results.put(newStudent, marks);
		
	}
	
	public String getMark(Student newStudent) {
		return results.get(newStudent).getGrade();
	}
	
	public int getScore(Student newStudent) {
		return results.get(newStudent).getScore();
	}
	
	public Boolean checkStudentAssessment(Student newStudent) {
		return results.containsKey(newStudent);
	}
	
	
	public abstract String description();
}
