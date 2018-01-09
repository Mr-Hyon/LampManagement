package po;

import java.io.Serializable;

public class SalesRecordInfo implements Serializable{
    private static final long serialVersionUID=1L;

	public SalesRecordInfo() {
		
	}

	private int id;
	private String date;
	private String name;
	private double amount;
	private double price;
	private double totalPrice;
	private String type;
	
	public SalesRecordInfo(String date,String name,String type,double amount,double price,double totalPrice){
		this.date=date;
		this.name=name;
		this.type=type;
		this.amount=amount;
		this.price=price;
		this.totalPrice=totalPrice;
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

    public String getDate(){
    	return date;
    }
    
    public void setDate(String date){
    	this.date=date;
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
    
    public void setTotalPrice(double totalPrice){
    	this.totalPrice=totalPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

