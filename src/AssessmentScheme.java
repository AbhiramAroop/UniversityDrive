import java.util.ArrayList;

/**
 * This Class stores a ArrayList of assessments for a particular unit and checks
 * wether the weights of the assessments adds up to 100
 * 
 * @author Abhiram Aroop
 *
 */

public class AssessmentScheme {
	
	private ArrayList<Assessment> assessments = new ArrayList<Assessment>();

/**
 * This method returns a copy of the array list of assessment in the class
 * 
 * @return copyAssessments an ArrayList which contains all the assessments for a unit
 */
	
	public ArrayList<Assessment> getAssessments() {
		ArrayList<Assessment> copyAssessments = new ArrayList<Assessment>(assessments);
		return copyAssessments;
	}
	
/**
 * This method is used to store an ArrayList of assessments in this class,
 * given that it has the correct weight
 *  
 * @param assessment an ArrayList of assessment
 */

	public void setAssessments(ArrayList<Assessment> assessment) {
		float totalWeight = 0;
		
		for (int i = 0; i < assessment.size(); i++) {
			totalWeight = totalWeight + assessment.get(i).getWeight();
		}
		
		try {
			checkTotalWeight(totalWeight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assessments = assessment;
		
	}
	
/**
 * This method is used to check if the total weight of all the assessment
 * in the assessments ArrayList adds up to 100
 *
 * @param totalWeight a float representing the total weight of all the assessment
 * @throws Exception if Assessments do not have a total weight of 100
 */
	
	public static void checkTotalWeight(float totalWeight) throws Exception {
		if (100 != totalWeight) {
			throw new Exception("Assessments Total Weight not 100!");
		}
	}
	
	

}
