package vo;

import javafx.beans.property.SimpleStringProperty;

public class PaymentVO {
	//付款单
	private final SimpleStringProperty id;				//付款单编号
	private final SimpleStringProperty operatorName;		//操作员名称
	private final SimpleStringProperty accountName;			//账户名称
	private final SimpleStringProperty cash;			//额度
	private final SimpleStringProperty other;			//备注
	private final SimpleStringProperty totalCash;		//总额汇总
	
	public PaymentVO(String id,String operator,String account,String cash,String other,String totalCash){
		this.id=new SimpleStringProperty(id);
		this.operatorName=new SimpleStringProperty(operator);
		this.accountName=new SimpleStringProperty(account);
		this.cash=new SimpleStringProperty(cash);
		this.other=new SimpleStringProperty(other);
		this.totalCash=new SimpleStringProperty(totalCash);
	}
	
	public String getId(){
		return id.get();
	}
	
	public void setId(String id){
		this.id.set(id);
	}
	
	public String getOperatorName(){
		return operatorName.get();
	}
	
	public void setOperatorName(String name){
		operatorName.set(name);
	}
	
	public String getAccountName(){
		return accountName.get();
	}
	
	public void setAccountName(String name){
		accountName.set(name);
	}
	
	public String getCash(){
		return cash.get();
	}
	
	public void setCash(String cash){
		this.cash.set(cash);
	}
	
	public String getOther(){
		return other.get();
	}
	
	public void setOther(String other){
		this.other.set(other);
	}
	
	public String getTotalCash(){
		return totalCash.get();
	}
	
	public void setTotalCash(String cash){
		totalCash.set(cash);
	}

}
