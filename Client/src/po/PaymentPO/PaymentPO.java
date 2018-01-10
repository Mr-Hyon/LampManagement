package po.PaymentPO;

import java.io.Serializable;
import java.util.List;

import po.AccountPO.AccountPO;
import po.UserPO.UserPO;

public class PaymentPO implements Serializable{
	private static final long serialVersionUID=1L;
	public PaymentPO() {
		
	}

	private int id;
	private String billID;
	private String type;
	private String client;
	private AccountPO bank;
	private UserPO operator;
	private double totalAmount;
	private List<TransferInfo> transferList;
	private String state;
	private String date;
	
	public PaymentPO(String billID,UserPO operator,AccountPO bank,List<TransferInfo> transferList,double total){
		this.billID=billID;
		this.bank=bank;
		this.operator=operator;
		this.totalAmount=total;
		this.transferList=transferList;
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
	
	public void setBillID(String billID){
		this.billID=billID;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	public String getClient(){
		return client;
	}
	
	public void setClient(String po){
		this.client=po;
	}
	
	public AccountPO getBank(){
    	return bank;
    }
    
    public void setBank(AccountPO bank){
    	this.bank=bank;
    }

	public UserPO getOperator(){
		return operator;
	}
	
	public void setOperator(UserPO po){
		this.operator=po;
	}

	public double getTotalAmount(){
		return totalAmount;
	}
	
	public void setTotalAmount(double amount){
		this.totalAmount=amount;
	}

	public List<TransferInfo> getTransferList(){
		return transferList;
	}
	
	public void setTransferList(List<TransferInfo> list){
		this.transferList=list;
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

//	public String toString(){
//		return
//	}
}

