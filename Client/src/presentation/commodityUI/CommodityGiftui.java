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
			CommodityGiftStage.setTitle("库存赠送");
			CommodityGiftStage.setScene(scene);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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
