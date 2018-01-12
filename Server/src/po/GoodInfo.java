package po;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="goodInfo")
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
	
	public GoodInfo(String name,String type,double amount,double price,double totalPrice){
		this.name=name;
		this.type=type;
		this.amount=amount;
		this.price=price;
		this.totalPrice=totalPrice;
	}
	
	public GoodInfo(String name,String type,double amount,double price,double totalPrice,String remark){
		this.name=name;
		this.type=type;
		this.amount=amount;
		this.price=price;
		this.totalPrice=totalPrice;
		this.remark=remark;
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
    
    @Column(name="type")
    public String getType(){
    	return type;
    }
    
    public void setType(String type){
    	this.type=type;
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
    
    public void setTotalPrice(double total){
    	this.totalPrice=total;
    }
    
    @Column(name="remark")
    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
	
}

