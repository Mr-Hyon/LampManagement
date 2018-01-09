package po.PaymentPO;

import java.io.Serializable;
import java.util.List;

public class PaymentPO implements Serializable{
	private static final long serialVersionUID=1L;
	public PaymentPO() {
		
	}

	private int id;
	private String billID;
	private String type;
	private String client;
	private String operator;
	private double totalAmount;
	private List<TransferInfo> transferList;
	private String state;
	private String date;
	
	public PaymentPO(String billID,String type,String client,String operator,List<TransferInfo> transferList,double total){
		this.billID=billID;
		this.type=type;
		this.client=client;
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

	public String getOperator(){
		return operator;
	}
	
	public void setOperator(String po){
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

