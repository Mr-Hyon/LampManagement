package presentation.accountUI;

import presentation.BLFactory.BLServiceFactory;
import presentation.financeUI.Financeui;
import vo.AccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.accountblservice.AccountBLService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AccountController {
	
	@FXML
	TableView<AccountVO> AccountTable;
	
	@FXML
	TableColumn AccountNameCol;
	
	@FXML
	TableColumn AccountCashCol;
	
	@FXML
	Button SearchButton;
	
	@FXML
	Button AddAccountButton;
	
	@FXML
	Button DeleteButton;
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button ModifyButton;
	
	@FXML
	TextField keyWords;
	
	@FXML
	TextField AccountNameAdd;
	
	@FXML
	TextField AccountCashAdd;
	
	
	private ObservableList<AccountVO> data=FXCollections.observableArrayList(
			new AccountVO("admin","2233"),
			new AccountVO("acfun","666"),
			new AccountVO("third","1111")
			);
	
	public void changeData(int index,AccountVO vo){
		data.set(index, vo);
	}
	
	public void initialize() throws RemoteException{
		AccountBLService accountBLService = BLServiceFactory.getAccountBLService();
		System.out.println("BLService connected");
		//ArrayList<AccountVO> accountList=accountBLService.show();
		//data=FXCollections.observableArrayList(accountList);
		AccountTable.setEditable(true);
		AccountNameCol.setCellValueFactory(new PropertyValueFactory<>("accountName"));
		AccountCashCol.setCellValueFactory(new PropertyValueFactory<>("accountCash"));
		AccountTable.setItems(data);
	}
	
	public void SearchAccount(){
		String key=keyWords.getText();
		int size=data.size();
		ObservableList<AccountVO> transfer=FXCollections.observableArrayList();
		for(int i=0;i<size;i++){
			AccountVO temp=data.get(i);
			if(temp.getAccountName().indexOf(key)>=0){
				transfer.add(temp);
			}
		}
		AccountShowController.setData(transfer);
		AccountShowui.show();
		keyWords.clear();
	}
	
	public void ReturntoMainmenu(){
		Accountui.hide();
		Financeui.show();
	}
	
	public void AddAccount(){
		
		String name=AccountNameAdd.getText();
		String cash=AccountCashAdd.getText();
		
		if(name.equals("") || cash.equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"账户名称或账户余额不能为空");
			warning.showAndWait();
			AccountNameAdd.setText("");
			AccountCashAdd.setText("");
		}
		else if(checkCash(cash)==false){
			Alert warning=new Alert(Alert.AlertType.WARNING,"输入的余额不规范");
			warning.showAndWait();
			AccountNameAdd.setText("");
			AccountCashAdd.setText("");
		}
		else{
			data.add(new AccountVO(name,cash));
			AccountNameAdd.clear();
			AccountCashAdd.clear();
		
			//AccountInputui.hide();
			//Account account=new Account(name,cash);
			//data.add(account);
			//AccountTable.setItems(data);
			}
	}
	
	public void DeleteAccount(){
		int index=AccountTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			AccountVO account=AccountTable.getSelectionModel().getSelectedItem();
			data.remove(account);
		}
	}
	
	public void ModifyAccount(){
		int index=AccountTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			AccountVO vo=AccountInputui.show();
			if(AccountInputui.getAccess()){
				AccountVO sample=data.get(index);
				sample.setAccountName(vo.getAccountName());
				data.set(index, sample);
			}
		}
		else{
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个账户进行操作");
			warning.showAndWait();
		}
	}
	
	public boolean checkCash(String cash){
		try{
			double d=Double.parseDouble(cash);
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
