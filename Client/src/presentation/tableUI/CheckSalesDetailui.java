package presentation.tableUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckSalesDetailui {
	
	public static Stage CheckSalesDetailStage;
	
	private CheckSalesDetailui(){
		try{
			Parent root=FXMLLoader.load(getClass().getResource("CheckSalesDetailui.fxml"));
			Scene scene=new Scene(root);
			CheckSalesDetailStage=new Stage();
			CheckSalesDetailStage.setTitle("�鿴������ϸ��");
			CheckSalesDetailStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CheckSalesDetailui();
		CheckSalesDetailStage.show();
	}
	
	public static void hide(){
		CheckSalesDetailStage.hide();
	}

}
