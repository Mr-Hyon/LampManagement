package presentation.accountUI;

import presentation.financeUI.Financeui;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AccountController {
	
	@FXML
	TableView<Account> AccountTable;
	
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
	TextField keyWords;
	
	@FXML
	TextField AccountName;
	
	@FXML
	TextField AccountNameAdd;
	
	@FXML
	TextField AccountCashAdd;
	
	private final ObservableList<Account> data=FXCollections.observableArrayList(
			new Account("admin","2233"),
			new Account("acfun","666"),
			new Account("third","1111")
			);
	
	public void initialize(){
		AccountTable.setEditable(true);
		AccountNameCol.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
		AccountCashCol.setCellValueFactory(new PropertyValueFactory<>("AccountCash"));
		AccountTable.setItems(data);
		data.add(new Account("here","123"));
		//System.out.println(data);
	}
	
	public void SearchAccount(){
		
	}
	
	public void ReturntoMainmenu(){
		Accountui.hide();
		Financeui.show();
	}
	
	public void AddAccount(){
		String name=AccountNameAdd.getText();
		String cash=AccountCashAdd.getText();
		
		data.add(new Account(name,cash));
		AccountNameAdd.clear();
		AccountCashAdd.clear();
		
		//AccountInputui.hide();
		//Account account=new Account(name,cash);
		//data.add(account);
		//AccountTable.setItems(data);
	}
	
	public void DeleteAccount(){
		int index=AccountTable.getSelectionModel().getSelectedIndex();
		Account account=AccountTable.getSelectionModel().getSelectedItem();
		data.remove(account);
	}


	public class Account{
		private final SimpleStringProperty accountName;
		private final SimpleStringProperty accountCash;
		
		public Account(String AccountName,String AccountCash){
			this.accountName=new SimpleStringProperty(AccountName);
			this.accountCash=new SimpleStringProperty(AccountCash);
		}
		
		public String getAccountName(){
			return accountName.get();
		}
		
		public String getAccountCash(){
			return accountCash.get();
		}
		
		public void setAccountName(String name){
			accountName.set(name);
		}
		
		public void setAccountCash(String cash){
			accountCash.set(cash);
		}
		
	}
}
