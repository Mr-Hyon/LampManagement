package billUI;

import financeUI.Financeui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BillController {
	
	@FXML Button BillReturnButton;
	
	public void initialize(){
		
	}
	
	public void BillReturn(){
		Billui.hide();
		Financeui.show();
	}

}
