package dots;

import java.awt.geom.Ellipse2D;

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
import userint.userInt;
import javafx.scene.paint.Paint;

import java.awt.*;

public class Draw extends Application {
	
public static void main(String[] args) {
		
		launch(args);
		
	}
	
	//takes a g, draws images
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
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
}
