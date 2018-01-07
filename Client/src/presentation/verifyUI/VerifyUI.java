package presentation.verifyUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VerifyUI {
	public static Stage stage;
	static FXMLLoader loader;
	public void setUp() {
		// TODO Auto-generated method stub
		stage=new Stage();
		FXMLLoader rootLoader = new FXMLLoader();
		loader=rootLoader;
		rootLoader.setLocation(getClass().getResource("Verify.fxml"));
	    Pane root;
		try {
			root = rootLoader.load();
			Scene scene = new Scene(root); 
			stage.setScene(scene);  
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void hide(){
		stage.hide();
	}
	public static void show(){
		stage.show();
	}
}