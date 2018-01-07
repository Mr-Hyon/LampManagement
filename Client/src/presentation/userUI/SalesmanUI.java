package presentation.userUI;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SalesmanUI {
	public static Stage SalesmanStage;
	private SalesmanUI()  {
		try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("Salesman.fxml"));
            Scene scene=new Scene(root);
            SalesmanStage=new Stage();
            SalesmanStage.setTitle("进销管理");
            SalesmanStage.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	public static void hide(){
		SalesmanStage.hide();
	}
	public static void show(){
		new SalesmanUI();
		SalesmanStage.show();
	}
}
