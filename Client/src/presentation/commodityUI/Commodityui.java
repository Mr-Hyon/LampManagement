package presentation.commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Commodityui {
	
	public static Stage CommodityStage;
	
	private Commodityui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Commodityui.fxml"));
			Scene scene=new Scene(root);
			CommodityStage=new Stage();
			CommodityStage.setTitle("库存管理人员主界面");
			CommodityStage.setScene(scene);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new Commodityui();
		CommodityStage.show();
	}
	
	public static void hide(){
		CommodityStage.hide();
	}

}
