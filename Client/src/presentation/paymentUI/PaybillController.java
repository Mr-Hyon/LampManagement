package presentation.paymentUI;

import presentation.BLFactory.BLServiceFactory;
import presentation.financeUI.Financeui;
import presentation.userUI.LoginController;
import util.ResultMessage;
import vo.PaymentVO;
import vo.ReceiptVO;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import blservice.paymentblservice.PaymentBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PaybillController {
	
	@FXML
	Button PaybillReturnButton;
	
	@FXML
	Button PaybillSubmitButton;
	
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
	TextField listName;
	
	@FXML
	TextArea Other;
	
	PaymentBLService paymentBLService=BLServiceFactory.getPaymentBLService();
	
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
	
	public void PaybillSubmitAction() throws RemoteException{
		String operator=Operator.getText();
		String other=Other.getText();
		String listname=listName.getText();
		String totalcash = TotalCash.getText();
		String cash=Cash.getText();
		String account=AccountName.getText();
		String id=PaybillID.getText();
		
		PaymentVO vo=new PaymentVO(id,operator,account,cash,other,totalcash);
		ResultMessage rm=paymentBLService.addPayBill(vo);
		if(rm==ResultMessage.SUCCESS){
			Alert alert=new Alert(Alert.AlertType.INFORMATION,"提交成功");
			alert.showAndWait();
		}
		else{
			Alert alert=new Alert(Alert.AlertType.INFORMATION,"提交失败");
			alert.showAndWait();
		}
	}

}
