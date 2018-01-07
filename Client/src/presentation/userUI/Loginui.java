package presentation.userUI;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Loginui {
	public static Stage LoginStage;

	private Loginui() {
		try{
			Parent root=FXMLLoader.load(getClass().getResource("Loginui.fxml"));
			Scene scene = new Scene(root);
			LoginStage=new Stage();
			LoginStage.setTitle("Welcome");
			LoginStage.setScene(scene);
			//RegisterStage.show();
			} catch(Exception e){
				e.printStackTrace();
			}
	}

	public static void hide(){
		LoginStage.hide();
	}

	public static void show(){
		new Loginui();
		LoginStage.show();
	}

}