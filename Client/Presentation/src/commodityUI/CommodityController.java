package commodityUI;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import userUI.Loginui;

public class CommodityController {

	@FXML
	Button GoodsManageButton;
	
	@FXML
	Button CheckInventoryButton;
	
	@FXML
	Button SaveInventoryButon;
	
	@FXML
	Button GiftInventoryButton;
	
	@FXML
	Button ExceptionInventoryButton;
	
	@FXML
	Button WarningButton;
	
	@FXML
	Button LogoutButton;

	
	public void initialize(){
	
	}
	
	public void ManageGoods(){
		Commodityui.hide();
		CommodityManageui.show();
	}
	
	public void CheckInventory(){
		Commodityui.hide();
		CommodityCheckui.show();
	}
	
	public void SaveInventory(){
		Commodityui.hide();
		CommoditySaveui.show();
	}
	
	public void GiftInventory(){
		Commodityui.hide();
		CommodityGiftui.show();
	}
	
	public void ExceptionInventory(){
		Commodityui.hide();
		CommodityAnalyzeui.show();
	}
	
	public void Warning(){
		Commodityui.hide();
		CommodityWarnui.show();
	}
	
	public void onLogout(){
		Commodityui.hide();
		Loginui.show();
	}
}
