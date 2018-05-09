package userint;


import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

//this is the keyboard class to make telling if a key is pressed more simple

public class Keyboard implements EventHandler<KeyEvent>{
	
	private KeyCode keyDown;
	private boolean iskeyPressed;
	
	
	public void handle(KeyEvent e) {
		if(e.getCode().isArrowKey()) {
			this.iskeyPressed=true;
			keyDown = e.getCode();
		}
		else if(e.getCode().equals(KeyCode.ENTER)||e.getCode().equals(KeyCode.COMMA)||e.getCode().equals(KeyCode.PERIOD)) {
			//quits
			keyDown =  e.getCode();
			this.iskeyPressed=true;
		}
		else {
			this.iskeyPressed=false;
		}
	}
	
	public KeyCode whatKeyDown() {
		return keyDown;
	}
	
	public boolean isKeyPressed() {
		return iskeyPressed;
		//returns if it is currently down or not
	}
	

}
