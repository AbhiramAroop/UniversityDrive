
public class Mark {

	private int grade;
	private String comments;
	
	public void setGrade(int score,String comment) {
		this.grade = score;
		this.comments = comment;
			
	}
	
	public int getScore() {
		return grade;
	}
	
	public String getGrade() {
		return grade + ", " + comments;
	}
	

}
