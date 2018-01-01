package commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CommodityWarnController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button SetWarnValueButton;
	
	public void initialize(){
		
	}
	
	public void Return(){
		CommodityWarnui.hide();
		Commodityui.show();
	}
	
	public void SetWarnValue(){
		
	}

}
