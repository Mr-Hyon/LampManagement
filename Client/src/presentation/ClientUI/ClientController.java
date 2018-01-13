package presentation.ClientUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.accountblservice.AccountBLService;
import blservice.clientblservice.ClientBLService;
import presentation.BLFactory.BLServiceFactory;
import presentation.accountUI.AccountShowController;
import presentation.accountUI.AccountShowui;
import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import util.ResultMessage;
import vo.AccountVO;
import vo.ClientVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.MenuButton;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;

public class ClientController {
	@FXML
	private Button ShowMessage;
	@FXML
	private Button AddClient;
	@FXML
	private Button Delete;
	@FXML
	private Button Modify;
	@FXML
	private Button BacktoMain;
	@FXML
	private TableView<ClientVO> ShowClientMes;
	@FXML
	private TableColumn ClientID;
	@FXML
	private TableColumn ClientName;
	@FXML
	private Label Label1;
	@FXML
	private Button Find;
	@FXML
	private MenuButton Menu;
	
	ClientBLService ClientBLService = BLServiceFactory.getClientBLService();
	private ObservableList<ClientVO> data=FXCollections.observableArrayList(
			new ClientVO("001","Supplier", "1", "admin", "tele","Addr","210046", "e-m", null, null),
			new ClientVO("102","Buyer", "3", "acfun", "tele","Addr","210046", "e-m",null, null),
			new ClientVO("103","Buyer", "5","bilibili", "tele","Addr", "210046","e-m", null, null)
			);
	ObservableList<ClientVO> transfer=FXCollections.observableArrayList();
	
	public void changeData(int index,ClientVO vo){
		data.set(index, vo);
	}
	public void initialize() throws RemoteException{
		//data.clear();
		ArrayList<ClientVO> ClientList=ClientBLService.show();
		for(int i=0;i<ClientList.size();i++){
			data.add(ClientList.get(i));
		}
		ShowClientMes.setEditable(true);
		ClientID.setCellValueFactory(new PropertyValueFactory<>("clientID"));
		ClientID.setCellValueFactory(new PropertyValueFactory<>("clientId"));
		ClientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
		ShowClientMes.setItems(data);
	}
	public void ShowUser(){
		Label1.setText("您好！YYY");
	}

	public void ShowMessage(ActionEvent event){
		int index=ShowClientMes.getSelectionModel().getSelectedIndex();
		if(index>=0){
			ClientVO client=ShowClientMes.getSelectionModel().getSelectedItem();
			ClientMesUI cm=new ClientMesUI();
			cm.setUp(client);
			ClientUI.hide();
		}
		else{
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个客户进行操作");
			warning.showAndWait();
		}
	}
	public void AddClient(ActionEvent event){
		ClientAddUI ca=new ClientAddUI();
		ca.setUp();
		ClientUI.hide();
	}
	public void Delete(ActionEvent event) throws RemoteException{
		int index=ShowClientMes.getSelectionModel().getSelectedIndex();
		if(index>=0){
			ClientVO client=ShowClientMes.getSelectionModel().getSelectedItem();
			ResultMessage rm=ClientBLService.delete(client);
			if(rm==ResultMessage.SUCCESS){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"删除成功");
				information.showAndWait();
				data.remove(client);
			}
		}
		else{
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个客户进行操作");
			warning.showAndWait();
		}
	}
	public void Modify(ActionEvent event){
		int index=ShowClientMes.getSelectionModel().getSelectedIndex();
		if(index>=0){
			ClientVO client=ShowClientMes.getSelectionModel().getSelectedItem();
			ClientMesUI cm=new ClientMesUI();
			cm.setUp(client);
			ClientUI.hide();
		}
		else{
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个客户进行操作");
			warning.showAndWait();
		}
	}
	public void BacktoMain(ActionEvent event){
		System.out.println("Button Clicked 5!");
		SalesmanUI.show();
		ClientUI.hide();
	}
	public void Find(ActionEvent event){
		System.out.println("Button Clicked 6!");
		ClientFindUI cf=new ClientFindUI();
		cf.setUp();
		ClientUI.hide();
	}
	public void logout(ActionEvent event){
		System.out.println("Button Clicked 7!");
		ClientUI.hide();
		Loginui.show();
	}
}
