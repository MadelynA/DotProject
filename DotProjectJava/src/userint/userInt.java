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

public class userInt extends Application {
	
	public Stage stage;
	
	public userInt() {
		this.stage = new Stage(StageStyle.DECORATED);//stage
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

