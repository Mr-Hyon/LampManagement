package Server.src.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="salesrecordinfo")
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="name")
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    @Column(name="date")
    public String getDate(){
    	return date;
    }
    
    public void setDate(String date){
    	this.date=date;
    }
    
    @Column(name="amount")
    public double getAmount(){
    	return amount;
    }
    
    public void setAmount(double amount){
    	this.amount=amount;
    }
    
    @Column(name="price")
    public double getPrice(){
    	return price;
    }
    
    public void setPrice(double price){
    	this.price=price;
    }
    
    @Column(name="totalPrice")
    public double getTotalPrice(){
    	return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice){
    	this.totalPrice=totalPrice;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

