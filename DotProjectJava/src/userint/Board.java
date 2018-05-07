package userint;
//board class is the actual display of the game


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
	private Pane canvas;
	private Bounds bounds;
	private Timeline timeline;
	//sets location of dot start to center so that it begins in center
	
public static void main(String[] args) {
		
		launch(args);
		
	}
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	dots = new ArrayList<computerDot>();
	uDot = new userDot(startDot_X, startDot_Y, Color.CYAN, 3, k);
	k = new Keyboard();

	Pane canvas = new Pane();
	Scene scene = new Scene(canvas, WIDTH, HEIGHT);
	
	
	Circle ball = new Circle(30);
    ball.relocate(0, 10);
    
    canvas.getChildren().add(ball);
    
	canvas = new Pane();
	Scene scene = new Scene(canvas, WIDTH, HEIGHT);
	//TODO: add key event  listener keyboard
	
    primaryStage.setTitle("Moving Ball");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    bounds = canvas.getBoundsInLocal();
   
   
    timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> {
    	actionPerformed();
    }));
    
    Draw(uDot);
    startGame();
    
    //

/**
* new KeyFrame(Duration.seconds(3), 
            new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius()))
*/
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
}
private void Draw(Dot dot) {
	Circle circ = new Circle(dot.getRadius());
	circ.relocate(dot.getCenterX(),dot.getCenterY());
	//sets new circle for dot and sets center
	
	canvas.getChildren().add(circ);
	KeyValue keyV = new KeyValue(circ.layoutXProperty(), bounds.getMaxX() - circ.getRadius() );
	KeyFrame k = new KeyFrame(Duration.seconds(10), keyV);
	timeline.getKeyFrames().add(k);
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
	
	private void gameOver() {
		//currently make it just pause and exit
		
		inGame = false;
		System.out.println("Maximum radius: "+uDot.getRadius());
		System.exit(0);
		
	}
	//TODO: add this into  the auto run of timeline
	public void actionPerformed() {
		
		this.updateCDots();
		this.updateUDot();
		
	}
	
	public void checkCollisions() {
		Ellipse uEllipse = uDot.getCirc();
		for(computerDot c: dots) {
			Ellipse cEllipse = c.getCirc();
			int cRadius = c.getRadius();
			int uRadius = uDot.getRadius();
			
			if(uEllipse.intersects(cEllipse.getBoundsInLocal())) {
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
