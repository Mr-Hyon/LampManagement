package presentation.tableUI;

import presentation.financeUI.Financeui;
import presentation.userUI.LoginController;
import presentation.userUI.ManagerUI;
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
		if(LoginController.getIdentity().equals("总经理"))
			ManagerUI.show();
		else
			Financeui.show();
	}
	
	public void CheckBPReturn(){
		CheckBusinessProgressui.hide();
		if(LoginController.getIdentity().equals("总经理"))
			ManagerUI.show();
		else
			Financeui.show();
	}
	
	public void CheckBSReturn(){
		CheckBusinessStateui.hide();
		if(LoginController.getIdentity().equals("总经理"))
			ManagerUI.show();
		else
			Financeui.show();
	}

}
