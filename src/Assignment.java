
public class Assignment extends Assessment {
	private String title;
	
	public Assignment(int weight, String title) {
		
		if (0 <= weight && 100 >= weight)  {
			this.weight = weight;

		}
		
		this.title = title;
		
	}
	public String description() {
		return "Assignment: " + this.title + ", weight " + this.weight + "%";
	}

}
