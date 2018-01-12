package presentation.paymentUI;

import presentation.financeUI.Financeui;
import presentation.userUI.LoginController;
import vo.ReceiptVO;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PaybillController {
	
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
		Operator.setText(LoginController.CurrentUser);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String id=df.format(new Date());
		id="FKD-"+id;
		PaybillID.setText(id);
	}
	
	public void PaybillReturnAction(){
		Financeui.show();
		Paybillui.hide();
	}
	
	public void PaybillSubmitAction(){
		
	}

}
