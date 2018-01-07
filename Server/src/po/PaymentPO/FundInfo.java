package po.PaymentPO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="fundInfo")
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
    
    @Column(name="amount")
    public double getAmount(){
    	return amount;
    }
    
    public void setAmount(double amount){
    	this.amount=amount;
    }
    
    @Column(name="remark")
    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
}

