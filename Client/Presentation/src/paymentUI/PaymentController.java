package paymentUI;

import financeUI.Financeui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaymentController {
	
	@FXML
	Button ReceiptReturnButton;
	
	@FXML
	Button ReceiptSubmitButton;
	
	@FXML
	Button PaybillReturnButton;
	
	@FXML
	Button PaybillSubmitButton;
	
	@FXML
	Label ReceiptID;
	
	@FXML
	Label PaybillID;
	
	@FXML
	Label currentUser;
	
	public void initialize(){
		
	}
	
	public void ReceiptReturnAction(){
		Financeui.show();
		Receiptui.hide();
	}
	
	public void ReceiptSubmitAction(){
		
	}
	
	public void PaybillReturnAction(){
		Financeui.show();
		Paybillui.hide();
	}
	
	public void PaybillSubmitAction(){
		
	}

}
