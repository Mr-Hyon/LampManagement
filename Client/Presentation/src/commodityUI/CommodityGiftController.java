package commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CommodityGiftController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button SendGiftButton;
	
	public void initialize(){
		
	}
	
	public void Return(){
		CommodityGiftui.hide();
		Commodityui.show();
	}
	
	public void SendGift(){
		
	}

}
