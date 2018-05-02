//User Int class is the menu and display containing the board
package userint;
import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import dots.*;

public class userInt extends JFrame {
	
	public Stage stage;
	private userDot uDot;
	private ArrayList<computerDot> dots = new ArrayList<computerDot>();
	private boolean inGame;
	private final int Board_WIDTH = 500;
	private final int Board_HEIGHT = 400;
	private final int centerX = Board_WIDTH/2;
	private final int centerY = Board_HEIGHT/2;
	//initializes variables for location
	
	
	public userInt() {
		initUI();
	}
	
	private void initUI() {
		//creates the board and  initializes menu
		add(new Board());
		//TODO
		//this puts board in the center -- will be moved later
		setSize(250,200);
		setTitle("Dot Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//centers window on screen
		//creates buttons for menu on left
		
		//listens to button 
		
		
	}
	
	public Stage returnStage() {
		return stage;
	}
	
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        stage.setTitle("Dot Game");
        stage.setScene(scene);
        stage.show();
    }

 
}

