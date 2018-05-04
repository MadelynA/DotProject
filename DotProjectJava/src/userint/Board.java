package userint;
//board class is the actual display of the game

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;

import javax.swing.JPanel;
import dots.*;

public class Board extends JPanel implements ActionListener{
	
	private userDot uDot;
	private List<computerDot> dots;
	private boolean inGame;
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final int startDot_X = WIDTH/2;
	private final int startDot_Y = HEIGHT/2;
	//sets location of dot start to center so that it begins in center
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.WHITE);
		//sets background of board to  be white for dots
		setDoubleBuffered(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		uDot = new userDot(startDot_X, startDot_Y, Color.CYAN, 3);
		//creates new userdot
		Draw(uDot);
		//draws dot on screen
		
	}
	
	private void updateUDot() {
		//checks userDot to move it if a key is pressed
		if(inGame) {
			uDot.movement();
		}
	}
	
	private void updateCDots() {
		//updates computerDots with movement
		if(inGame) {
			for(computerDot cDot: dots) {
				if(cDot.onBoard()) {
					cDot.movement();
				}
				else {
					dots.remove(cDot);
					int randomXORY;
					dots.add(new computerDot());
				}
			}
		}
	}
	
	private void Draw(Dot dot) {
		
	}
	
	private void gameOver() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
