package po.PaymentPO;

import java.io.Serializable;
import java.util.List;

import po.AccountPO.AccountPO;
import po.ClientPO.ClientPO;
import po.UserPO.UserPO;

public class CollectionPO implements Serializable{
    private static final long serialVersionUID=1L;
	public CollectionPO() {
		
	}

	private int id;
	private String billID;
	private ClientPO supplier;
	private ClientPO salesman;
	private UserPO operator;
	private AccountPO bank;
	private double totalAmount;
	private List<FundInfo> fundsList; 
	private String state;
	private String date;
	
	public CollectionPO(String billID,ClientPO supplier,ClientPO salesman,UserPO operator,AccountPO bank,double amount,List<FundInfo> list){
		this.billID=billID;
		this.supplier=supplier;
		this.salesman=salesman;
		this.bank=bank;
		this.operator=operator;
		this.totalAmount=amount;
		this.fundsList=list;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillID(){
    	return billID;
    }
    
    public void setBillID(String id){
    	this.billID=id;
    }
    
    public ClientPO getSupplier(){
    	return supplier;
    }
    
    public void setSupplier(ClientPO po){
    	this.supplier=po;
    }
    
    public ClientPO getSalesman(){
        return salesman;
    }
        
    public void setSalesman(ClientPO po){
        this.salesman=po;
    }

    public UserPO getOperator(){
    	return operator;
    }
    
    public void setOperator(UserPO po){
    	this.operator=po;
    }

    public AccountPO getBank(){
    	return bank;
    }
    
    public void setBank(AccountPO bank){
    	this.bank=bank;
    }

    public double getTotalAmount(){
    	return totalAmount;
    }
    
    public void setTotalAmount(double amount){
    	this.totalAmount=amount;
    }

    public List<FundInfo> getClausesList(){
    	return fundsList;
    }
    
    public void setClausesList(List<FundInfo> list){
    	this.fundsList=list;
    }

	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state=state;
	}

    public String getDate(){
        return  date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

