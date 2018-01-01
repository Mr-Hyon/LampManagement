package presentation.tableUI;

import presentation.financeUI.Financeui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TableController {
	
	@FXML
	Button CheckSDReturnButton;
	
	@FXML
	Button CheckBPReturnButton;
	
	@FXML
	Button CheckBSReturnButton;
	
	public void initialize(){
		
	}
	
	public void CheckSDReturn(){
		CheckSalesDetailui.hide();
		Financeui.show();
	}
	
	public void CheckBPReturn(){
		CheckBusinessProgressui.hide();
		Financeui.show();
	}
	
	public void CheckBSReturn(){
		CheckBusinessStateui.hide();
		Financeui.show();
	}

}
