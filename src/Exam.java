
public class Exam extends Assessment {
	private int duration;

	public Exam(int duration, int weight) {
		
		if (0 <= weight && 100 >= weight)  {
			this.weight = weight;

		}
		
		if ((30 >= duration) && (duration <= 180)) {
			this.duration = duration;	
		}
		
	}

	public String description() {
		return "Exam: duration" + " " + this.duration + " minutes, weight" + " " + this.weight + "%";
}

}

	


