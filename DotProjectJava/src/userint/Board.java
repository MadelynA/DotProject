package userint;
//board class is the actual display of the game


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
	private ParallelTransition pt;
	private userDot uDot;
	private List<computerDot> dots;
	private boolean inGame = true;
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final int startDot_X = WIDTH/2;
	private final int startDot_Y = HEIGHT/2;
	private Keyboard k;
	private Pane canvas;
	private Bounds bounds;
	private Timeline timeline;
	private Scene scene;
	private Group root;
	private Stage primaryStage;
	//sets location of dot start to center so that it begins in center
	
public static void main(String[] args) {
		
		launch(args);
		
	}
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	this.primaryStage = primaryStage;
	dots = new ArrayList<computerDot>();
	k = new Keyboard();
	uDot = new userDot(startDot_X, startDot_Y, Color.DARKRED, 3, k);
    
	root = new Group();
	canvas = new Pane();
	scene = new Scene(root, WIDTH, HEIGHT);
	scene.setOnKeyPressed(k);
	
    primaryStage.setTitle("Dot Project");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    bounds = canvas.getBoundsInLocal();
   
    pt = new ParallelTransition();
    timeline = new Timeline();
    
KeyFrame frame = new KeyFrame(Duration.millis(100),event -> {
		
		actionPerformed();
		
		});
	timeline.getKeyFrames().add(frame);
   
    startGame();
    actionPerformed();
    
    
    //
    pt.play();
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    
    scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>
    () {

          @Override
          public void handle(KeyEvent t) {
            if(t.getCode()==KeyCode.ESCAPE)
            {
              //Stage sb = (Stage)label.getScene().getWindow();//use any one object
             primaryStage.close();
            }
          }
      });
    
}

private void Draw(Dot dot) {
	Circle circ = new Circle(dot.getRadius());
	
	circ.setFill(dot.getColor());
	TranslateTransition t = new TranslateTransition(Duration.millis(10), circ);
	circ.relocate(dot.getCenterX(), dot.getCenterY());
	root.getChildren().add(circ);
	
	if(!dot.isOnBoard()) {
		root.getChildren().remove(circ);
	}
	t.setFromX(circ.getCenterX());
	t.setFromY(dot.getCenterY());
	dot.movement();
	t.setToX(circ.getCenterX());
	t.setToY(dot.getCenterY());
	//sets new circle for dot and sets center
	
	pt.getChildren().add(t);
	primaryStage.setScene(scene);
	primaryStage.show();
	
	//timeline part below
	

}

	
	private void startGame() {
		//creates 5 computer dots to begin with
		this.addNewCDot(1);
		this.addNewCDot(2);
		this.addNewCDot(3);
		this.addNewCDot(4);
		this.addNewCDot(5);
		inGame = true;
		
	}
	
	private void updateUDot() {
		//checks userDot to move it if a key is pressed
		if(inGame) {
			this.Draw(uDot);
			this.checkCollisions();
		}
	}
	
	private void updateCDots() {
		//updates computerDots with movement
		if(inGame) {
			for(computerDot cDot: dots) {
				if(cDot.onBoard()) {
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
		int addSecond = (int) (Math.random()*10);
		this.addNewCDot(rad);
		if(addSecond < 2) {
			this.addNewCDot(rad2);
		}
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
