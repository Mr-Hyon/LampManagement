package userUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Registerui {
	
	public static Stage RegisterStage;
	
	private static String operator;

	private Registerui() {
		try{
			Parent root=FXMLLoader.load(getClass().getResource("Registerui.fxml"));
			Scene scene = new Scene(root);
			RegisterStage=new Stage();
			RegisterStage.setTitle("Welcome");
			RegisterStage.setScene(scene);
			//RegisterStage.show();
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public static void setOperator(String UserName){
		operator=UserName;
	}
	
	public static void show(){
		new Registerui();
		RegisterStage.show();
	}
	
	public static void hide(){
		RegisterStage.hide();
	}

}
