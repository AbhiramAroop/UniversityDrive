import java.util.ArrayList;

public class AssessmentScheme {
	
	private ArrayList<Assessment> assessments = new ArrayList<Assessment>();

	public ArrayList<Assessment> getAssessments() {
		ArrayList<Assessment> copyAssessments = new ArrayList<Assessment>(assessments);
		return copyAssessments;
	}

	public void addAssessments(Assessment assessment) {
		assessments.add(assessment);
	}
	
	

}
