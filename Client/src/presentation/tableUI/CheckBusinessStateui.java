package presentation.tableUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckBusinessStateui {
	
	public static Stage CheckBusinessStateuiStage;
	
	private CheckBusinessStateui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("CheckBusinessStateui.fxml"));
			Scene scene=new Scene(root);
			CheckBusinessStateuiStage=new Stage();
			CheckBusinessStateuiStage.setTitle("查询经营情况表");
			CheckBusinessStateuiStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CheckBusinessStateui();
		CheckBusinessStateuiStage.show();
	}
	
	public static void hide(){
		CheckBusinessStateuiStage.hide();
	}

}
