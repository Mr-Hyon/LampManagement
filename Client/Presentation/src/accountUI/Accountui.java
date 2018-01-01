package accountUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Accountui {
	
	public static Stage AccountStage;
	
	private Accountui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("Accountui.fxml"));
			Scene scene=new Scene(root);
			AccountStage=new Stage();
			AccountStage.setTitle("’Àªßπ‹¿Ì");
			AccountStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new Accountui();
		AccountStage.show();
	}
	
	public static void hide(){
		AccountStage.hide();
	}

}
