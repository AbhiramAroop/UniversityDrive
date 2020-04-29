/**
 * This Class stores the grade and feedback for an assessment completed by
 * a Student for a unit
 * 
 * @author Abhiram Aroop
 *
 */

public class Mark {

	private float grade;
	private String comments;
	
/**
 * This method is used to set the grade and feedback of a student's assessment
 * 
 * @param score a float representing the grade they recieved on an assessment
 * @param comment a string representing the feedback
 */
	
	public void setGrade(float score,String comment) {
		
		try {
			checkScore(score);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.grade = score;
		this.comments = comment;
			
	}
	
/**
 * This method returns the grade achieved by a student for an assessment
 * 
 * @return grade a float representing the student's grade
 */
	
	public float getScore() {
		return grade;
	}
	
/**
 * This method is used to set the grade of a student for an assessment
 * 
 * @return a string representing the grade and the feedback for the student
 */
	
	public String getGrade() {
		return grade + ", " + comments;
	}
	
/**
 * This method check whether a given grade/score is valid
 * 
 * @param score a float representing the grade recieved for the student
 * @throws Exception when grade is below 0 or above 100
 */
	
	public static void checkScore(float score) throws Exception {
		if (0 > score) {
			throw new Exception("Weight too small");
		}
		else if (100 < score) {
			throw new Exception("Weight too large");
		}
	}

}
