package userint;
//board class is the actual display of the game


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;
import dots.*;

public class Board extends Application{
	
	private userDot uDot;
	private List<computerDot> dots;
	private boolean inGame;
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final int startDot_X = WIDTH/2;
	private final int startDot_Y = HEIGHT/2;
	private Keyboard k;
	//sets location of dot start to center so that it begins in center
	public Board(Stage stage) {
		dots = new ArrayList<computerDot>();
		k = new Keyboard();
		initBoard(stage);
		startGame();
	}
	
public static void main(String[] args) {
		
		launch(args);
		
	}
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	dots = new ArrayList<computerDot>();
	k = new Keyboard();
	Pane canvas = new Pane();
	Scene scene = new Scene(canvas, 500, 500);
	Circle ball = new Circle(30);
    ball.relocate(0, 10);
    
    canvas.getChildren().add(ball);
    
    primaryStage.setTitle("Moving Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    Bounds bounds = canvas.getBoundsInLocal();
   
    KeyValue keyV = new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius());
    KeyFrame k = new KeyFrame(Duration.seconds(5), keyV);
    Timeline timeline = new Timeline(k);

/**
* new KeyFrame(Duration.seconds(3), 
            new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius()))
*/
    timeline.setCycleCount(3);
    timeline.play();
}
	
	private void initBoard(Stage stage) {
		Pane root = new Pane();
		
		Scene scene = new Scene(root, 250, 220, Color.WHITE);
		stage.setTitle("Test");
		stage.setScene(scene);
		stage.show();
		
		uDot = new userDot(startDot_X, startDot_Y, Color.CYAN, 3, k);
		//creates new userdot
		Draw(uDot);
		//draws dot on screen
		
	}
	
	private void startGame() {
		//creates 5 computer dots to begin with
		this.addNewCDot(1);
		this.addNewCDot(2);
		this.addNewCDot(3);
		this.addNewCDot(4);
		this.addNewCDot(5);
		
	}
	
	private void updateUDot() {
		//checks userDot to move it if a key is pressed
		if(inGame) {
			uDot.movement();
			this.Draw(uDot);
			this.checkCollisions();
		}
	}
	
	private void updateCDots() {
		//updates computerDots with movement
		if(inGame) {
			for(computerDot cDot: dots) {
				if(cDot.onBoard()) {
					cDot.movement();
					this.Draw(cDot);
				}
				else {
					this.removeDot(cDot);
				}
			}
		}
	}
	
	private void removeDot(computerDot c) {
		//removes and replaces dot
		dots.remove(c);
		int rad = (int) (Math.random()*uDot.getRadius());
		//creates one smaller and one larger
		int rad2 = (int) (Math.random()*uDot.getRadius()+uDot.getRadius());
		this.addNewCDot(rad);
		this.addNewCDot(rad2);
	}
	
	private void addNewCDot(int radius) {
		dots.add(new computerDot(WIDTH, HEIGHT, Color.RED, radius, k));
	}
	
	private void Draw(Dot dot) {
		
	}
	
	private void gameOver() {
		//currently make it just pause and exit
		
		inGame = false;
		System.out.println("Maximum radius: "+uDot.getRadius());
		System.exit(0);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		this.updateCDots();
		this.updateUDot();
		
	}
	
	public void checkCollisions() {
		Ellipse2D.Double uEllipse = uDot.getCirc();
		for(computerDot c: dots) {
			Ellipse2D.Double cEllipse = c.getCirc();
			int cRadius = c.getRadius();
			int uRadius = uDot.getRadius();
			if(uEllipse.intersects(cEllipse.getBounds2D())) {
				//there's a collision but now has to check which is larger
				if(cRadius>uRadius) {
					//gameover
					gameOver();
				}
				else {
					//eats dot and grows
					uDot.grow();
					this.removeDot(c);
				}
			}
			
		}
	}

}
