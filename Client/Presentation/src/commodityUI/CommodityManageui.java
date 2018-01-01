package commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityManageui {
	
public static Stage CommodityManageStage;
	
	private CommodityManageui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CommodityManageui.fxml"));
			Scene scene=new Scene(root);
			CommodityManageStage=new Stage();
			CommodityManageStage.setTitle("商品管理");
			CommodityManageStage.setScene(scene);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommodityManageui();
		CommodityManageStage.show();
	}
	
	public static void hide(){
		CommodityManageStage.hide();
	}

}
