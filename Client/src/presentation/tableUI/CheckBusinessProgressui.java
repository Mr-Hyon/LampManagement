package presentation.tableUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckBusinessProgressui {
	
	public static Stage CheckBusinessProgressStage;
	
	private CheckBusinessProgressui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("CheckBusinessProgressui.fxml"));
			Scene scene=new Scene(root);
			CheckBusinessProgressStage=new Stage();
			CheckBusinessProgressStage.setTitle("查看经营历程表");
			CheckBusinessProgressStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CheckBusinessProgressui();
		CheckBusinessProgressStage.show();
	}
	
	public static void hide(){
		CheckBusinessProgressStage.hide();
	}

}
