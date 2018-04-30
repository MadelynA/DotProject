package dots;

import java.util.List;

public class DotList {
	//a class to  keep track of the dots involved in the game
	List<Dot> dots = new ArrayList<Dot>();
	userDot uDot;
	userInt UI;
	
	public DotList(int difficulty, userInt UI) {
		
		this.UI = UI;
		initDots(difficulty);
		uDot =  new userDot(//get center for this)
		
	}
	
	public static void initDots(int num) {
		
	}

}
