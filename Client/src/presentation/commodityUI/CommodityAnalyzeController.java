package presentation.commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CommodityAnalyzeController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button AnalyzeButton;
	
	public void initialize(){
		
	}
	
	public void Return(){
		CommodityAnalyzeui.hide();
		Commodityui.show();
	}
	
	public void Analyze(){
		
	}

}
