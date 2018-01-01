package commodityUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityWarnui {
	
	public static Stage CommodityWarnStage;
	
	private CommodityWarnui(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CommodityWarnui.fxml"));
			Scene scene=new Scene(root);
			CommodityWarnStage=new Stage();
			CommodityWarnStage.setTitle("��汨��");
			CommodityWarnStage.setScene(scene);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void show(){
		new CommodityWarnui();
		CommodityWarnStage.show();
	}
	
	public static void hide(){
		CommodityWarnStage.hide();
	}


}
