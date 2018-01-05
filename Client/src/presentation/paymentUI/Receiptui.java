package presentation.paymentUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Receiptui {
	
	public static Stage PaymentStage;
	
	private Receiptui(){
		try {
			Parent root=FXMLLoader.load(getClass().getResource("Paymentui.fxml"));
			Scene scene=new Scene(root);
			PaymentStage=new Stage();
			PaymentStage.setTitle("制定收款单");
			PaymentStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void show(){
		new Receiptui();
		PaymentStage.show();
	}
	
	public static void hide(){
		PaymentStage.hide();
	}

}
