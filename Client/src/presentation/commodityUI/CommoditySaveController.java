package presentation.commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CommoditySaveController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button SetEndTimeButton;
	
	@FXML
	Button SaveSnapshotButton;
	
	@FXML
	Button ExportSnapshotButton;
	
	public void initialize(){
		
	}
	
	public void Return(){
		CommoditySaveui.hide();
		Commodityui.show();
	}
	
	public void SetEndTime(){
		
	}
	
	public void SaveSnapShot(){
		
	}
	
	public void ExportSnapShot(){
		
	}

}
