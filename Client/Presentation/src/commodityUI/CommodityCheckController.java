package commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CommodityCheckController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button CheckButton;
	
	public void initialize(){
		
	}
	
	public void Return(){
		CommodityCheckui.hide();
		Commodityui.show();
	}
	
	public void Check(){
		
	}

}
