package presentation.ClientUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import presentation.BLFactory.BLServiceFactory;
import util.ResultMessage;
import vo.ClientVO;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import blservice.clientblservice.ClientBLService;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ClientAddController {
	@FXML
	private TextField clientLevel;
	@FXML
	private TextField clientName;
	@FXML
	private TextField clientContact;
	@FXML
	private TextField clientAddress;
	@FXML
	private TextField clientZip;
	@FXML
	private TextField clientEmail;
	@FXML
	private Button Back;
	@FXML
	private Button Confirm;
	@FXML
	private Label clientId;
	@FXML
	private Label clientType;
	@FXML
	private Label clientPay;
	@FXML
	private Label clientReceive;
	
	ClientBLService clientBLService=BLServiceFactory.getClientBLService();
	
	public void initialize(){
		clientPay.setText("暂无数据");
		clientReceive.setText("暂无数据");
		SimpleDateFormat df = new SimpleDateFormat("mmss");
		String id=df.format(new Date());
		clientId.setText(id);
		clientType.setText("暂无评级");
	}
	public void Back(ActionEvent event){
		ClientAddUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
	public void Add(ActionEvent event) throws RemoteException{
		//增加
		ClientVO client=new ClientVO(clientId.getText(),clientType.getText(),clientLevel.getText(), clientName.getText(), clientContact.getText(), clientAddress.getText(),clientZip.getText(),clientEmail.getText(), clientPay.getText(),clientReceive.getText());
		ResultMessage rm=clientBLService.add(client);
		
		if(rm==ResultMessage.SUCCESS){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"添加成功");
			information.showAndWait();
		}
		else if(rm==ResultMessage.FAILED){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"添加失败");
			information.showAndWait();
		}
		ClientAddUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
}
