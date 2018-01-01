package presentation.commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityAnalyzeui {
	
	public static Stage CommodityAnalyzeStage;
	
	private CommodityAnalyzeui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CommodityAnalyzeui.fxml"));
			Scene scene=new Scene(root);
			CommodityAnalyzeStage=new Stage();
			CommodityAnalyzeStage.setTitle("库存分析");
			CommodityAnalyzeStage.setScene(scene);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommodityAnalyzeui();
		CommodityAnalyzeStage.show();
	}
	
	public static void hide(){
		CommodityAnalyzeStage.hide();
	}


}
