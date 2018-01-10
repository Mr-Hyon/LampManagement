package presentation.accountUI;

import presentation.BLFactory.BLServiceFactory;
import presentation.financeUI.Financeui;
import util.ResultMessage;
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
	
	AccountBLService accountBLService = BLServiceFactory.getAccountBLService();
	
	private ObservableList<AccountVO> data=FXCollections.observableArrayList(
			new AccountVO("admin","2233"),
			new AccountVO("acfun","666"),
			new AccountVO("third","1111")
			);
	
	ObservableList<AccountVO> transfer=FXCollections.observableArrayList();
	
	public void changeData(int index,AccountVO vo){
		data.set(index, vo);
	}
	
	public void initialize() throws RemoteException{
		data.clear();
		ArrayList<AccountVO> accountList=accountBLService.show();
		for(int i=0;i<accountList.size();i++){
			data.add(accountList.get(i));
		}
		AccountTable.setEditable(true);
		AccountNameCol.setCellValueFactory(new PropertyValueFactory<>("accountName"));
		AccountCashCol.setCellValueFactory(new PropertyValueFactory<>("accountCash"));
		AccountTable.setItems(data);
	}
	
	public void SearchAccount(){
		transfer.clear();
		String key=keyWords.getText();
		if(key.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"关键字不能为空");
			alert.showAndWait();
			keyWords.clear();
		}
		else{
			int size=data.size();
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
	}
	
	public void ReturntoMainmenu(){
		Accountui.hide();
		Financeui.show();
	}
	
	public void AddAccount() throws RemoteException{
		
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
			AccountVO vo=new AccountVO(name,cash);
			ResultMessage rm=accountBLService.add(vo);
			
			if(rm==ResultMessage.SUCCESS){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"添加成功");
				information.showAndWait();
				data.add(vo);
				AccountNameAdd.clear();
				AccountCashAdd.clear();
			}
			else if(rm==ResultMessage.FAILED){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"添加失败");
				information.showAndWait();
			}
			
			//AccountInputui.hide();
			//Account account=new Account(name,cash);
			//data.add(account);
			//AccountTable.setItems(data);
			}
	}
	
	public void DeleteAccount() throws RemoteException{
		int index=AccountTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			AccountVO account=AccountTable.getSelectionModel().getSelectedItem();
			ResultMessage rm=accountBLService.delete(account);
			if(rm==ResultMessage.SUCCESS){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"删除成功");
				information.showAndWait();
				data.remove(account);
			}
		}
		else{
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个账户进行操作");
			warning.showAndWait();
		}
	}
	
	public void ModifyAccount() throws RemoteException{
		int index=AccountTable.getSelectionModel().getSelectedIndex();
		if(index>=0){
			AccountVO vo=AccountInputui.show();
			if(AccountInputui.getAccess()){
				AccountVO sample=data.get(index);
				vo.setAccountCash(sample.getAccountCash());
				ResultMessage rm = accountBLService.update(vo);
				if(rm==ResultMessage.SUCCESS){
					Alert information=new Alert(Alert.AlertType.INFORMATION,"修改成功");
					information.showAndWait();
					sample.setAccountName(vo.getAccountName());
					data.set(index, sample);
				}
				else if(rm==ResultMessage.FAILED){
					Alert information=new Alert(Alert.AlertType.INFORMATION,"修改失败");
					information.showAndWait();
					//System.out.println(vo.getAccountName()+" "+vo.getAccountCash());
				}
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
