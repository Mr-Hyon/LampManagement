package vo;

import javafx.beans.property.SimpleStringProperty;

public class AccountVO {
	
	private final SimpleStringProperty accountName;
	private final SimpleStringProperty accountCash;
	
	public AccountVO(String AccountName,String AccountCash){
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
