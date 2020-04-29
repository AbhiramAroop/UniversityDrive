/**
 * This Class is an extension of the assessment class and
 * represents the exam(s) that needs to be done by students for a unit
 * 
 * @author Abhiram Aroop
 *
 */

public class Exam extends Assessment {
	private int duration;
	
/**
 * This method sets the weight and duration of the exam and checks whether it is
 * within certain bounds
 * 
 * @param duration an integer representing the time the exam should last
 * @param weight a float representing the weight of the exam on the unit
 */

	public Exam(int duration, float weight) {
		
		setWeight(weight);
		
		try {
			checkExamDuration(duration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.duration = duration;	

		
	}

	public String description() {
		return "Exam: duration" + " " + this.duration + " minutes, weight" + " " + this.getWeight() + "%";
}
	
	public static void checkExamDuration(int duration) throws Exception {
		if (30 > duration) {
			throw new Exception("Exam duration too short");
		}
		else if (180 < duration) {
			throw new Exception("Exam duration too long");
		}
	}


}

	


