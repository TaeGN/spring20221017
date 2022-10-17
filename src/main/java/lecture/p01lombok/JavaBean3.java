package lecture.p01lombok;

import lombok.Getter;
import lombok.Setter;

public class JavaBean3 {
	@Getter
	@Setter
	private String company;
	
	@Getter
	@Setter
	private int score;
	private String location;
}
