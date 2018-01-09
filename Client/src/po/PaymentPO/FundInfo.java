package po.PaymentPO;

import java.io.Serializable;

public class FundInfo implements Serializable{
    private static final long serialVersionUID=1L;
	public FundInfo() {
		
	}

	private int id;
	private String name;
	private double amount;
	private String remark;
	
	public FundInfo(String name,double amount,String remark){
		this.name=name;
		this.amount=amount;
		this.remark=remark;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
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

