package vo;

import javafx.beans.property.SimpleStringProperty;

public class ReceiptVO {
	//�տ
	private final SimpleStringProperty id;				//���ݱ��
	private final SimpleStringProperty supplierName;	//����������
	private final SimpleStringProperty salesmanName;		//����������
	private final SimpleStringProperty operatorName;		//����Ա����
	private final SimpleStringProperty accountName;			//�˻�����
	private final SimpleStringProperty cash;			//ת�˶��
	private final SimpleStringProperty other;			//��ע����
	private final SimpleStringProperty totalCash;		//�ܶ����
	
	private AccountVO account;						//�����˻�vo����
	private ClientVO supplier;							//������vo����
	private ClientVO salesman;							//������vo����
	private UserVO operator;							//����Աvo����
	
	public ReceiptVO(String id,ClientVO supplier,ClientVO salesman,UserVO operator,AccountVO account,String cash,String other,String totalCash){
		this.id=new SimpleStringProperty(id);
		this.supplierName=new SimpleStringProperty(supplier.getClientName());
		this.salesmanName=new SimpleStringProperty(salesman.getClientName());
		this.operatorName=new SimpleStringProperty(operator.getUserName());
		this.accountName=new SimpleStringProperty(account.getAccountName());
		this.cash=new SimpleStringProperty(cash);
		this.other=new SimpleStringProperty(other);
		this.totalCash=new SimpleStringProperty(totalCash);
		
		this.account=account;
		this.supplier=supplier;
		this.salesman=salesman;
		this.operator=operator;
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
	
	public ClientVO getSupplier(){
		return supplier;
	}
	
	public void setSupplier(ClientVO supplier){
		this.supplier=supplier;
		supplierName.set(supplier.getClientName());
	}
	
	public ClientVO getSalesman(){
		return salesman;
	}
	
	public void setSalesman(ClientVO salesman){
		this.salesman=salesman;
		salesmanName.set(salesman.getClientName());
	}
	
	public UserVO getOperator(){
		return operator;
	}
	
	public void setOperator(UserVO operator){
		this.operator=operator;
		operatorName.set(operator.getUserName());
	}
	
	public AccountVO getAccount(){
		return account;
	}
	
	public void setAccount(AccountVO account){
		this.account=account;
		accountName.set(account.getAccountName());
	}

}
