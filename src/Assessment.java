import java.util.HashMap;

/**
 * This Abstract Class consists of a particular type of assessment that the is created by
 * the university and used by a Unit.
 * 
 * @author Abhiram Aroop
 *
 */

public abstract class Assessment {
	private float weight;
	private HashMap<String, Mark> results = new HashMap<String, Mark>();
//Copy student / STudent ID
	public float getWeight() {
		return weight;
	}
	
/**
 * This method is used to set the "weight"/impact of the assessment towards the overall
 * mark for the unit
 * 
 * @param weight a float representing the total impact of the assessment to the overall unit
 */

	public void setWeight(float weight) {
		try {
			checkWeight(weight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.weight = weight;
		
/**
 * This methods is used to check whether the assessment weight is within 
 * a valid range
 */
		
	}
	public static void checkWeight(float weight2) throws Exception {
		if (1 > weight2) {
			throw new Exception("Weight too small");
		}
		else if (100 < weight2) {
			throw new Exception("Weight too large");
		}
	}
	
/**
 * This method is used to set the mark of a student
 * 
 * @param newStudent a string representing the studentID of a student
 * @param marks a mark object representing the grade of the student in the assessment
 */
	
	public void setMark(Student newStudent, Mark marks) {
		this.results.put(newStudent.getStudentID(), marks);
		
	}
	
/**
 * This method is used to obtain the mark for a student in this assessment
 * 
 * @param newStudent a student object representing the student who's marks need to be found
 * @return a string representing the grade and marker's comment for the assessment
 */
	
	public String getMark(Student newStudent) {
		return results.get(newStudent.getStudentID()).getGrade();
	}
	
/**
 * This method is used to get the grade number of a student in the assessment
 * 
 * @param newStudent a student object representing the student
 * @return a float representing their score in this assessment
 */
	
	public float getScore(Student newStudent) {
		return results.get(newStudent.getStudentID()).getScore();
	}
	
/**
 * This method checks whether a student has completed this assessment
 * 
 * @param newStudent a student object representing the student
 * @return a boolean, true if the student has completed the assessment
 */
	
	public Boolean checkStudentAssessment(String newStudent) {
		return results.containsKey(newStudent);
	}
	
	
	public abstract String description();
}
