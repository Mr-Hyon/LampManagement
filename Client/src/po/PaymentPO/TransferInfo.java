package po.PaymentPO;

import java.io.Serializable;

public class TransferInfo implements Serializable{
    private static final long serialVersionUID=1L;
	public TransferInfo() {
		
	}

	private int id;
	private String bank;
	private double amount;
	private String remark;
	
	public TransferInfo(String bank,double amount,String remark){
		this.bank=bank;
		this.amount=amount;
		this.remark=remark;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank(){
    	return bank;
    }
    
    public void setBank(String bank){
    	this.bank=bank;
    }

    public double getAmount(){
    	return amount;
    }
    
    public void setAmount(double amount){
    	this.amount=amount;
    }

    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
}

