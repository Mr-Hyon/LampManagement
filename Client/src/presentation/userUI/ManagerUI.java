package presentation.userUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManagerUI  {
	public static Stage ManagerStage;
	private ManagerUI()  {
		try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
            Scene scene=new Scene(root);
            ManagerStage=new Stage();
            ManagerStage.setTitle("总经理");
            ManagerStage.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	public static void hide(){
		ManagerStage.hide();
	}
	public static void show(){
		new ManagerUI();
		ManagerStage.show();
	}
}
