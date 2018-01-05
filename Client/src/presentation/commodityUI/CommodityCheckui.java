package presentation.commodityUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityCheckui {
	
	public static Stage CommodityCheckStage;
	
	private CommodityCheckui(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("CommodityCheckui.fxml"));
			Scene scene=new Scene(root);
			CommodityCheckStage=new Stage();
			CommodityCheckStage.setTitle("库存查看");
			CommodityCheckStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommodityCheckui();
		CommodityCheckStage.show();
	}
	
	public static void hide(){
		CommodityCheckStage.hide();
	}

}
