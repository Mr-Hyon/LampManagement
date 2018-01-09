package po;

import java.io.Serializable;

public class GoodInfo implements Serializable{
    private static final long serialVersionUID=1L;
	public GoodInfo() {
		
	}

	private int id;
	private String name;
	private String type;
	private double amount;
	private double price;
	private double totalPrice;
	private String remark;
	
	public GoodInfo(String name,String type,double amount,double price,double totalPrice,String remark){
		this.name=name;
		this.type=type;
		this.amount=amount;
		this.price=price;
		this.totalPrice=totalPrice;
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

    public String getType(){
    	return type;
    }
    
    public void setType(String type){
    	this.type=type;
    }

    public double getAmount(){
    	return amount;
    }
    
    public void setAmount(double amount){
    	this.amount=amount;
    }

    public double getPrice(){
    	return price;
    }
    
    public void setPrice(double price){
    	this.price=price;
    }

    public double getTotalPrice(){
    	return totalPrice;
    }
    
    public void setTotalPrice(double total){
    	this.totalPrice=total;
    }

    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
	
}

