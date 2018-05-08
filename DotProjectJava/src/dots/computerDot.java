package dots;
import javafx.scene.paint.Color;
import userint.Keyboard;
import javax.swing.ImageIcon;

public class computerDot extends Dot{
	private int BOARD_HEIGHT;
	private int BOARD_WIDTH;
	private int centerChange;
	private int xChange = 0;
	private int yChange = 0;
	private int mType;
	private Keyboard  k;
	private boolean onBoard = true;
	
	
	public computerDot(int width, int height, Color color, int radius, Keyboard k) {
		super(0, 0, color, radius);
		mType = (int) (Math.random()*4);
		BOARD_HEIGHT=height;
		BOARD_WIDTH = width;
		//sets xCenter and yCenter based on direction of movement
		if(mType ==0) {
			//it goes only left so  it starts along the right side
			centerChange = (int) (Math.random()*BOARD_HEIGHT);//change this val if board height changes
			this.setCenter(BOARD_WIDTH, centerChange);
		}
		if(mType == 1) {
			//only right so  starts on left edge
			centerChange = (int) (Math.random()*BOARD_HEIGHT);
			this.setCenter(0, centerChange);
		}
		if(mType == 2) {
			//moves down so begins along top
			centerChange = (int) (Math.random()*BOARD_WIDTH);
			this.setCenter(centerChange, BOARD_HEIGHT);
		}
		if(mType == 3) {
			//moves up so begins on bottom
			centerChange = (int) (Math.random()*BOARD_WIDTH);
			this.setCenter(centerChange, 0);
		}
		
		this.k = k;
		//xCenter and yCenter are randomly assigned from the side of the frame
		//radius is randomly assigned
	}
	
	
	
	public void movement() {
		if (this.onBoard()){
			//doesn't move if not on board
			this.movementType();
			this.setCenter(this.getCenterX()+xChange, this.getCenterY()+yChange);
			//will go in direction of change
		}
	}
	
	public boolean onBoard() {
		//checks if it is within the board bounds
		if(this.getCenterX()<0 || this.getCenterX()>BOARD_WIDTH || this.getCenterY()<0 || this.getCenterY()>BOARD_HEIGHT) {
			return false;
		}
		return true;
	}
	
	public void movementType() {
		if(this.mType==0) {
			//goes only left
			xChange = -1;
		}
		if(this.mType==1) {
			//goes only right
			xChange = 1;
		}
		if(this.mType==2) {
			//goes down
			yChange = -1;
		}
		if(this.mType == 3) {
			//goes up
			yChange  = 1;
		}
		
	}
	
	
	
	
}
