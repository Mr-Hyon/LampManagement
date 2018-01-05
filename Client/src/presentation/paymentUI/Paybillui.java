package presentation.paymentUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Paybillui {
	
	public static Stage PaybillStage;
	
	private Paybillui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("Paybillui.fxml"));
			Scene scene=new Scene(root);
			PaybillStage=new Stage();
			PaybillStage.setTitle("制定付款单");
			PaybillStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new Paybillui();
		PaybillStage.show();
	}

	public static void hide(){
		PaybillStage.hide();
	}
}
