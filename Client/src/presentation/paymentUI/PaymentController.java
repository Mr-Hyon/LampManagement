package presentation.paymentUI;

import presentation.financeUI.Financeui;
import vo.ReceiptVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	
	@FXML
	Label Operator;
	
	@FXML
	TextField AccountName;
	
	@FXML
	TextField Cash;
	
	@FXML
	TextField TotalCash;
	
	@FXML
	TextField Supplier;
	
	@FXML
	TextField Salesman;
	
	@FXML
	TextArea Other;
	
	public void initialize(){
		//test
	}
	
	public void ReceiptReturnAction(){
		Financeui.show();
		Receiptui.hide();
	}
	
	public void ReceiptSubmitAction(){
		String id=ReceiptID.getId();
		//need blsupport
	}
	
	public void PaybillReturnAction(){
		Financeui.show();
		Paybillui.hide();
	}
	
	public void PaybillSubmitAction(){
		
	}

}
