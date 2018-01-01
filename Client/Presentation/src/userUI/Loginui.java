package userUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Loginui extends Application {
	
	public static Stage LoginStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root=FXMLLoader.load(getClass().getResource("Loginui.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Welcome");
			primaryStage.setScene(scene);
			primaryStage.show();
			LoginStage=primaryStage;
	}
	
	public static void hide(){
		LoginStage.hide();
	}
	
	public static void show(){
		LoginStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


