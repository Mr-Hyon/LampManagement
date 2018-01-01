package financeUI;

import accountUI.Accountui;
import billUI.Billui;
import financeUI.Financeui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import userUI.Loginui;
import paymentUI.Paybillui;
import paymentUI.Receiptui;
import tableUI.CheckBusinessProgressui;
import tableUI.CheckBusinessStateui;
import tableUI.CheckSalesDetailui;
import paymentUI.Receiptui;


public class FinanceController {
	
	@FXML
	Button AccountManageButton;
	
	@FXML
	Button MakeReceiptButton;
	
	@FXML
	Button MakePaybillButton;

	@FXML
	Button CheckSalesButton;

	@FXML
	Button CheckRunButton;

	@FXML
	Button CheckStateButton;
	
	@FXML
	Button InitialAccountButton;
	
	@FXML
	Button LogoutButton;
	
	@FXML
	Label currentUser;
	
	public void initialize(){
		
	}
	
	public void onManageAccount(){
		Financeui.hide();
		Accountui.show();
	}
	
	public void onMakeReceipt(){
		Financeui.hide();
		Receiptui.show();
	}

	public void onMakePaybill(){
		Financeui.hide();
		Paybillui.show();
	}

	public void onCheckSales(){
		Financeui.hide();
		CheckSalesDetailui.show();
	}
	
	public void onCheckRun(){
		Financeui.hide();
		CheckBusinessProgressui.show();
	}
	
	public void onCheckState(){
		Financeui.hide();
		CheckBusinessStateui.show();
	}
	
	public void onInitialAccount(){
		Financeui.hide();
		Billui.show();
	}
	
	public void onLogout(){
		Financeui.hide();
		Loginui.show();
	}
}
