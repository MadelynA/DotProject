import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import userint.userInt;

//this class runs the program
public class run extends Application{

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			userInt run = new userInt();
			run.setVisible(true);
		});
		// TODO Auto-generated method stub
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		circle.setCenterX((float) 400); 
		circle.setCenterY(300); 
		circle.setRadius(30);
		
		Group root = new Group(circle);
		Scene scene = new Scene(root,600, 300);
		primaryStage.setTitle("PLEASE WORK"); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}
