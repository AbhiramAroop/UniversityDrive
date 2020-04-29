
/**
 * This Class is an extension of the assessment class and
 * represents assignments that needs to be done by students for a unit
 * 
 * @author Abhiram Aroop
 *
 */

public class Assignment extends Assessment {
	private String title;
	
/**
 * This method sets the weight and title for the assignment
 * 
 * @param weight a float representing the weight of the assignment on the unit
 * @param title a string used as the name to identify the assignment
 */
	
	public Assignment(float weight, String title) {
		
		setWeight(weight);
		
		this.title = title;
		
	}
	public String description() {
		return "Assignment: " + this.title + ", weight " + this.getWeight() + "%";
	}
	

}
