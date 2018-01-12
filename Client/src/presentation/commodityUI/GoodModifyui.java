package presentation.commodityUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.CommodityVO;

public class GoodModifyui {
	
public static Stage GoodModifyStage;

	private static CommodityVO vo;
	private static boolean confirm;
	
	private GoodModifyui(){
		confirm=false;
		try{
			Parent root=FXMLLoader.load(getClass().getResource("GoodModifyui.fxml"));
			Scene scene=new Scene(root);
			GoodModifyStage=new Stage();
			GoodModifyStage.setTitle("修改商品信息");
			GoodModifyStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static CommodityVO show(){
		new GoodModifyui();
		GoodModifyStage.showAndWait();
		return getData();
	}
	
	public static void setAccess(boolean bool){
		confirm=bool;
	}
	
	public static boolean getAccess(){
		return confirm;
	}
	
	public static void setData(String num,String bp,String rp){
		vo=new CommodityVO(null,null,null,num,bp,rp);
	}
	
	public static CommodityVO getData(){
		return vo;
	}
	
	public static void hide(){
		GoodModifyStage.hide();
		
	}

}
