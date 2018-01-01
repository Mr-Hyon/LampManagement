package presentation.commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityGiftui {
	
	public static Stage CommodityGiftStage;
	
	private CommodityGiftui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CommodityGiftui.fxml"));
			Scene scene=new Scene(root);
			CommodityGiftStage=new Stage();
			CommodityGiftStage.setTitle("�������");
			CommodityGiftStage.setScene(scene);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommodityGiftui();
		CommodityGiftStage.show();
	}
	
	public static void hide(){
		CommodityGiftStage.hide();
	}


}
