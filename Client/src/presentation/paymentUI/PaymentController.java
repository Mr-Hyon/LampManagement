package presentation.paymentUI;

import presentation.BLFactory.BLServiceFactory;
import presentation.financeUI.Financeui;
import presentation.userUI.LoginController;
import vo.PaymentVO;
import vo.ReceiptVO;

import java.text.SimpleDateFormat;
import java.util.Date;

import blservice.accountblservice.AccountBLService;
import blservice.clientblservice.ClientBLService;
import blservice.paymentblservice.PaymentBLService;
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
	Label ReceiptID;
	
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
	
	PaymentBLService paymenyBLService=BLServiceFactory.getPaymentBLService();
	AccountBLService accountBLService=BLServiceFactory.getAccountBLService();
	ClientBLService clientBLService=BLServiceFactory.getClientBLService();
	
	public void initialize(){
		Operator.setText(LoginController.CurrentUser);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");//设置日期格式
		String id=df.format(new Date());// new Date()为获取当前系统时间
		id="SKD-"+id;
		ReceiptID.setText(id);
	}
	
	public void ReceiptReturnAction(){
		Financeui.show();
		Receiptui.hide();
	}
	
	public void ReceiptSubmitAction(){
		String id=ReceiptID.getText();
		String salesman=Salesman.getText();
		String supplier=Supplier.getText();
		String account=AccountName.getText();
		String cash=Cash.getText();
		String totalCash=TotalCash.getText();
		String other=Other.getText();
		String operator=Operator.getText();
		
		ReceiptVO vo=new ReceiptVO(id,supplier,salesman,operator,account,cash,other,totalCash);
		
	}
	
}
