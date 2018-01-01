package commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommoditySaveui {
	
	public static Stage CommoditySaveStage;
	
	private CommoditySaveui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CommoditySaveui.fxml"));
			Scene scene=new Scene(root);
			CommoditySaveStage=new Stage();
			CommoditySaveStage.setTitle("����̵�");
			CommoditySaveStage.setScene(scene);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommoditySaveui();
		CommoditySaveStage.show();
	}
	
	public static void hide(){
		CommoditySaveStage.hide();
	}


}
