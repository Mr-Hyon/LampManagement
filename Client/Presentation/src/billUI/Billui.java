package billUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Billui {
	
	public static Stage BillStage;
	
	private Billui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("Billui.fxml"));
			Scene scene=new Scene(root);
			BillStage=new Stage();
			BillStage.setTitle("ÆÚ³õ½¨ÕË");
			BillStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new Billui();
		BillStage.show();
	}
	
	public static void hide(){
		BillStage.hide();
	}

}
