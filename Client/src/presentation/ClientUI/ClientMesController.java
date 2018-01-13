package presentation.ClientUI;

import java.rmi.RemoteException;

import blservice.clientblservice.ClientBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import presentation.BLFactory.BLServiceFactory;
import util.ResultMessage;
import vo.ClientVO;
import javafx.scene.control.Label;

public class ClientMesController {
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
	private Label clientPay;
	@FXML
	private Label clientReceive;
	@FXML
	private Button Modify;
	@FXML
	private Button Back;
	@FXML
	private Button Confirm;
	@FXML
	private Label clientId;
	@FXML
	private Label clientType;

	ClientBLService clientBLService=BLServiceFactory.getClientBLService();
	
	public void initialize() throws RemoteException{
		clientId.setText(ClientMesUI.getVO().getClientId());
		clientType.setText(ClientMesUI.getVO().getClientType());
		clientLevel.setText(ClientMesUI.getVO().getClientLevel());
		clientName.setText(ClientMesUI.getVO().getClientName());
		clientContact.setText(ClientMesUI.getVO().getClientContact());
		clientAddress.setText(ClientMesUI.getVO().getClientAddress());
		clientZip.setText(ClientMesUI.getVO().getClientZip());
		clientEmail.setText(ClientMesUI.getVO().getClientEmail());
		clientPay.setText(ClientMesUI.getVO().getClientPay());
		clientReceive.setText(ClientMesUI.getVO().getClientReceive());
	}
	public void Modify(ActionEvent event){
		clientLevel.setEditable(true);
		clientName.setEditable(true);
		clientContact.setEditable(true);
		clientAddress.setEditable(true);
		clientZip.setEditable(true);
		clientEmail.setEditable(true);
	}
	public void Back(ActionEvent event){
		ClientMesUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
	public void Confirm(ActionEvent event) throws RemoteException{
		//新VO或改VO
		ClientVO client=new ClientVO(clientId.getText(),clientType.getText(),clientLevel.getText(), clientName.getText(), clientContact.getText(), clientAddress.getText(),clientZip.getText(),clientEmail.getText(), clientPay.getText(),clientReceive.getText());
		ResultMessage rm=clientBLService.add(client);
		
		if(rm==ResultMessage.SUCCESS){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"修改成功");
			information.showAndWait();
		}
		else if(rm==ResultMessage.FAILED){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"修改失败");
			information.showAndWait();
		}
		ClientMesUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
}

