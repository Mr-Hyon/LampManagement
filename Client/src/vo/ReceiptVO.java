package vo;

import javafx.beans.property.SimpleStringProperty;

public class ReceiptVO {
	//收款单
	private final SimpleStringProperty id;				//收款单编号
	private final SimpleStringProperty supplierName;	//供货商名称
	private final SimpleStringProperty salesmanName;		//销售商名称
	private final SimpleStringProperty operatorName;		//操作员名称
	private final SimpleStringProperty accountName;			//账户名称
	private final SimpleStringProperty cash;			//额度
	private final SimpleStringProperty other;			//备注
	private final SimpleStringProperty totalCash;		//总额汇总
	public boolean isVerified;							//是否被审批
	
	public ReceiptVO(String id,String supplier,String salesman,String operator,String account,String cash,String other,String totalCash){
		this.id=new SimpleStringProperty(id);
		this.supplierName=new SimpleStringProperty(supplier);
		this.salesmanName=new SimpleStringProperty(salesman);
		this.operatorName=new SimpleStringProperty(operator);
		this.accountName=new SimpleStringProperty(account);
		this.cash=new SimpleStringProperty(cash);
		this.other=new SimpleStringProperty(other);
		this.totalCash=new SimpleStringProperty(totalCash);
		isVerified=false;
	}
	
	public String getId(){
		return id.get();
	}
	
	public void setId(String id){
		this.id.set(id);
	}
	
	public String getSupplierName(){
		return supplierName.get();
	}
	
	public void setSupplierName(String name){
		supplierName.set(name);
	}
	
	public String getSalesmanName(){
		return salesmanName.get();
	}
	
	public void setSalesmanName(String name){
		salesmanName.set(name);
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
